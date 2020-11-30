package com.gatech.diabetesapp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    private FileObjectRepository fileObjectRepository;

    public FileObject store(MultipartFile file) throws IOException {


//        ClassPathResource jsaCoverImgFile = new ClassPathResource("files/jsa-cover.png");


//        jsaCoverImgFile.getInputStream().read(arrayData);

        String xTitle = "x-";
        String yTitle = "y-";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "row", "col1");
        dataset.addValue(2, "row", "col2");
        dataset.addValue(3, "row", "col3");
        dataset.addValue(4, "row", "col4");
        dataset.addValue(5, "row", "col5");

        JFreeChart chart = null;
        StandardChartTheme theme = new StandardChartTheme("JFree/Shadow", true);
//        theme.setPlotBackgroundPaint(Color.darkGray);
        ChartFactory.setChartTheme(theme);
        chart = ChartFactory.createLineChart(
                xTitle + " vs " + yTitle,
                xTitle, yTitle,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ChartUtils.writeChartAsPNG(out, chart, 10, 10);

        byte[] arrayData = new byte[(int) out.toByteArray().length];

        FileObject coverModel = new FileObject("JSA-Cover", "png", arrayData);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileObject FileDB = new FileObject(fileName, file.getContentType(), file.getBytes());

        // create temp file
        // https://mkyong.com/java/how-to-create-temporary-file-in-java/
        // build jfreechart and save into temp file
        // already done
        // attach temp file to email and send
        // need to add to attachments
        // https://medium.com/@asbnotebook/send-email-with-attachment-spring-boot-e365ab4a8dee

        return fileObjectRepository.save(FileDB);
    }

    public FileObject getFile(long id) {
        return fileObjectRepository.findById(id).get();
    }

    public Stream<FileObject> getAllFiles() {
        return fileObjectRepository.findAll().stream();
    }
}
