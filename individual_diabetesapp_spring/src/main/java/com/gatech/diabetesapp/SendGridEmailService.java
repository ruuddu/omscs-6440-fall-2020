package com.gatech.diabetesapp;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sun.xml.internal.ws.api.message.Attachment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sendgrid.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class SendGridEmailService {

    private static final Log LOG = LogFactory.getLog(SendGridEmailService.class);

    private SendGrid sendGridClient;

    @Autowired
    public SendGridEmailService(SendGrid sendGridClient) {
        this.sendGridClient = sendGridClient;
    }

    public void sendHTML(String from, String to, String subject, String body) throws IOException, ParseException {
        Response response = sendEmail(from, to, subject, new Content("text/html", body));
//        LOG.info("Status: " + response.getStatusCode() + ", Body: " + response.getBody() + ", Headers: "
//                + response.getHeaders());
    }

    private void plotReport() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Assign X and Y data
//        for(int i = 0; i < params.length; i++) {
//            dataset.addValue(finalFitnessValues[i], "pairs", params[i]);
//        }

        GraphPlot plot = new GraphPlot("Fitness Values vs GA-Pop-Mate-Mutate");
        plot.plotCategoryChart(dataset, "GA-Pop-Mate-Mutate", "Fitness Value");
        plot.saveChart("travel_salesman_new_training_ga_fitness_vs_GA_Pop_Mate_Mutate.png");
    }

    private Response sendEmail(String fromM, String toM, String subjectM, Content content) throws IOException, ParseException {
        Email from = new Email(fromM);
        String subject = subjectM;
        Email to = new Email(toM);
        Mail mail = new Mail(from, subject, to, content);


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
                new SimpleDateFormat("MM/dd/yyyy").parse("08/19/2020"));
        //        List<BloodGlucose> blooldGlucoseResult = bloodGlucoseService.findAll();
        List<BloodGlucose> blooldGlucoseResult = Arrays.asList(bg, bg2, bg3, bg4, bg5, bg6);

        //https://github.com/sendgrid/sendgrid-java/issues/439

        // build chart with this jfreechart
        //http://zetcode.com/java/jfreechart/

        // store image file on Spring Boot
        //https://bezkoder.com/spring-boot-upload-file-database/


        // sendgrid via javascript
        //https://github.com/sendgrid/sendgrid-java/issues/157

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = this.sendGridClient.api(request);
            LOG.info("Status: " + response.getStatusCode() + " Body: "
                    + response.getBody() + " Headers: " + response.getHeaders());
            return response;
        } catch (IOException ex) {
            LOG.error("Erroring mail: " + ex.getMessage());
            throw ex;
        }
    }
}
