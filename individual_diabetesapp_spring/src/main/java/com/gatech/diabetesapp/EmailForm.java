package com.gatech.diabetesapp;

public class EmailForm {
    private String email;
    private String timestamp;
    private String smtpId;
    private String event;
    private String category;

    public EmailForm() {
    }

    public EmailForm(String email, String timestamp, String smtpId, String event, String category, String sgEventId, String sgMessageId, String reason, String status) {
        this.email = email;
        this.timestamp = timestamp;
        this.smtpId = smtpId;
        this.event = event;
        this.category = category;
        this.sgEventId = sgEventId;
        this.sgMessageId = sgMessageId;
        this.reason = reason;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSmtpId() {
        return smtpId;
    }

    public void setSmtpId(String smtpId) {
        this.smtpId = smtpId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSgEventId() {
        return sgEventId;
    }

    public void setSgEventId(String sgEventId) {
        this.sgEventId = sgEventId;
    }

    public String getSgMessageId() {
        return sgMessageId;
    }

    public void setSgMessageId(String sgMessageId) {
        this.sgMessageId = sgMessageId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String sgEventId;
    private String sgMessageId;
    private String reason;
    private String status;

}
