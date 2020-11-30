package com.gatech.diabetesapp;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class GraphPlot extends ApplicationFrame {
    private JFreeChart chart = null;

    public GraphPlot(String applicationTitle) {
        super(applicationTitle);
    }

    public void plotChart(XYDataset dataset, String xTitle, String yTitle) {
        StandardChartTheme theme = new StandardChartTheme("JFree/Shadow", true);
        //theme.setPlotBackgroundPaint(Color.darkGray);
        ChartFactory.setChartTheme(theme);
        chart = ChartFactory.createXYLineChart(
                xTitle + " vs " + yTitle,
                xTitle, yTitle,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);
    }

    public void plotBarChart(DefaultCategoryDataset dataset, String xTitle, String yTitle) {
        StandardChartTheme theme = new StandardChartTheme("JFree/Shadow", true);
//        theme.setPlotBackgroundPaint(Color.darkGray);
        ChartFactory.setChartTheme(theme);
        chart = ChartFactory.createBarChart(
                xTitle + " vs " + yTitle,
                xTitle, yTitle,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);
    }

    public void plotCategoryChart(DefaultCategoryDataset dataset, String xTitle, String yTitle) {
        StandardChartTheme theme = new StandardChartTheme("JFree/Shadow", true);
//        theme.setPlotBackgroundPaint(Color.darkGray);
        ChartFactory.setChartTheme(theme);
        chart = ChartFactory.createLineChart(
                xTitle + " vs " + yTitle,
                xTitle, yTitle,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);
    }

    public void saveChart(String name) {
        File chartFile = new File(name);

        try {
            ChartUtils.saveChartAsPNG(chartFile, chart, 800, 600);
        } catch (IOException ioe) {
            System.err.println("cannot create chart " + chartFile.getName());
        }
        System.out.print('.');
        System.out.flush();
    }
}
