package com.gatech.diabetesapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BloodGlucoseController {

    private static final Log LOG = LogFactory.getLog(BloodGlucoseController.class);

    @Autowired
    private BloodGlucoseService bloodGlucoseService;

    @Autowired
    private SendGridEmailService sendGridEmailService;


    // https://stackoverflow.com/questions/22947751/how-to-return-csv-data-in-browser-from-spring-controller
    @CrossOrigin
    @GetMapping(value = "/getBloodGlucoses")
    @ResponseBody
    public String findAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "inline; filename=daily-report.csv");

        List<BloodGlucose> blooldGlucoseResult = bloodGlucoseService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"id", "fasting", "afterMeal", "createdDate", "dateString"};

        csvWriter.writeHeader(header);

        Format formatter = new SimpleDateFormat("MM/dd/yy");

        for (BloodGlucose singleResult : blooldGlucoseResult) {
            singleResult.setDateString(formatter.format(singleResult.getCreatedDate()));
            csvWriter.write(singleResult, header);
        }
        csvWriter.close();
        return null;
    }

    @CrossOrigin
    @GetMapping(value = "/generateData")
    @ResponseBody
    public String generateData() throws ParseException {
        BloodGlucose bg = new BloodGlucose(1, 80, 10,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/15/2020"));
        BloodGlucose bg2 = new BloodGlucose(2, 95, 115,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/16/2020"));
        BloodGlucose bg3 = new BloodGlucose(3, 120, 140,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/17/2020"));
        BloodGlucose bg4 = new BloodGlucose(4, 100, 120,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/18/2020"));
        BloodGlucose bg5 = new BloodGlucose(5, 98, 118,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/19/2020"));
        BloodGlucose bg6 = new BloodGlucose(6, 130, 150,
                new SimpleDateFormat("MM/dd/yyyy").parse("08/20/2020"));

        List<BloodGlucose> blooldGlucoseResult = Arrays.asList(bg, bg2, bg3, bg4, bg5, bg6);

        Format formatter = new SimpleDateFormat("MM/dd/yy");

        for (BloodGlucose singleResult : blooldGlucoseResult) {
            singleResult.setDateString(formatter.format(singleResult.getCreatedDate()));
            bloodGlucoseService.addRecord(singleResult);
        }

        return null;
    }


    @PostMapping(value = "/bloodGlucose")
//    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    @CrossOrigin
    @ResponseBody
    public BloodGlucose addBloodGlucose(@RequestBody BloodGlucose bloodGlucose) {
        bloodGlucose.setCreatedDate(new Date());
        LOG.debug(bloodGlucose.getFasting());
        LOG.debug(bloodGlucose.getAfterMeal());
        return bloodGlucoseService.addRecord(bloodGlucose);
    }

    @DeleteMapping(value = "/bloodGlucose")
    @CrossOrigin
    @ResponseBody
//    @CrossOrigin(origins = "https://limitless-wildwood-48331.herokuapp.com/")
    public BloodGlucose deleteBloodGlucose(@RequestBody BloodGlucose bloodGlucose) {
        /* can use only id */
        return bloodGlucoseService.deleteRecord(bloodGlucose);
    }

    @PostMapping(value = "/sendEmail")
    @CrossOrigin
    @ResponseBody
    public int sendEmail(@RequestBody EmailForm emailForm) {
        sendGridEmailService.sendEmail("tvo41@gatech.edu", emailForm.getEmail(), "Blood Glucose Report",
                "Hi " + emailForm.getEmail().split("@")[0] + ". Attachment is the blood glucose report " +
                        "of patient. ");

        return 1;
    }

}
