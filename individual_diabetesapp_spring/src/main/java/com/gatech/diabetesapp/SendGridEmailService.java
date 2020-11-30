package com.gatech.diabetesapp;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sendgrid.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class SendGridEmailService {

    private static final Log LOG = LogFactory.getLog(SendGridEmailService.class);

    private SendGrid sendGridClient;

    @Autowired
    private BloodGlucoseService bloodGlucoseService;

//    @Autowired
    public SendGridEmailService() {
        this.sendGridClient = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    }




    private String plotReport(List<BloodGlucose> bloodGlucoses) {
        Path temp = null;
        try {

            // Create an temporary file
            temp = Files.createTempFile("daily_report", ".png");
            LOG.error("Temp file's path: " + temp.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Format formatter = new SimpleDateFormat("MM/dd/yy");


        for (BloodGlucose singleResult : bloodGlucoses) {
            singleResult.setDateString(formatter.format(singleResult.getCreatedDate()));
            dataset.setValue(singleResult.getFasting(), "", singleResult.getDateString());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Daily Blood Glucose Level",
                "Date",
                "Fasting (mg/dL)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        File chartFile = new File(temp.toString());

        try {
            ChartUtils.saveChartAsPNG(chartFile, barChart, 800, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp.toString();
    }

    public Response sendEmail(String fromM, String toM, String subjectM, String body) {
        Content content = new Content("text/html", body);

        Email from = new Email(fromM);
        String subject = subjectM;
        Email to = new Email(toM);
        Mail mail = new Mail(from, subject, to, content);

        List<BloodGlucose> bloodGlucoseResult = bloodGlucoseService.findAll();

        String filePath = plotReport(bloodGlucoseResult);


        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");

            Attachments attachments = new Attachments();
            Path file = Paths.get(filePath);
            byte[] attachmentContentBytes = Files.readAllBytes(file);
            Base64 x = new Base64();
            String imageDataString = x.encodeAsString(attachmentContentBytes);
            attachments.setContent(imageDataString);
            attachments.setType("image/png");
            attachments.setFilename("daily_report.png");
            attachments.setDisposition("attachment");
            attachments.setContentId("Banner");
            mail.addAttachments(attachments);

            request.setBody(mail.build());

            Response response = this.sendGridClient.api(request);
            LOG.info("Status: " + response.getStatusCode() + " Body: "
                    + response.getBody() + " Headers: " + response.getHeaders());
            return response;
        } catch (IOException ex) {
            LOG.error("Error mail: " + ex.getMessage());
        }
        return null;
    }
}
