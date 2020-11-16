package com.gatech.diabetesapp;

import javax.persistence.*;

@Entity
public class TestCode {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;

    private double normalLimit;

    private double prediabetesMin;

    private double prediabetesMax;

    private double diabetesLimit;

    public long getId(){
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getNormalLimit() {
        return normalLimit;
    }

    public void setNormalLimit(double normalLimit) {
        this.normalLimit = normalLimit;
    }

    public double getPrediabetesMin() {
        return prediabetesMin;
    }

    public void setPrediabetesMin(double prediabetesMin) {
        this.prediabetesMin = prediabetesMin;
    }

    public double getPrediabetesMax() {
        return prediabetesMax;
    }

    public void setPrediabetesMax(double prediabetesMax) {
        this.prediabetesMax = prediabetesMax;
    }

    public double getDiabetesLimit() {
        return diabetesLimit;
    }

    public void setDiabetesLimit(double diabetesLimit) {
        this.diabetesLimit = diabetesLimit;
    }
}
