package com.gatech.diabetesapp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blood_glucose")
public class BloodGlucose {
    public BloodGlucose(long id, double fasting, double afterMeal, Date createdDate) {
        this.id = id;
        this.fasting = fasting;
        this.afterMeal = afterMeal;
        this.createdDate = createdDate;
    }

    public BloodGlucose(double fasting, double afterMeal) {
        this.fasting = fasting;
        this.afterMeal = afterMeal;
    }

    public BloodGlucose(){};

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double fasting;

    private double afterMeal;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Transient
    private String dateString;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getFasting() {
        return fasting;
    }

    public void setFasting(double fasting) {
        this.fasting = fasting;
    }

    public double getAfterMeal() {
        return afterMeal;
    }

    public void setAfterMeal(double afterMeal) {
        this.afterMeal = afterMeal;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
