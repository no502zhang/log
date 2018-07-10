package com.wiseyq.log.model;

public class ActionRecord {

    private Long id;

    private String parkId;

    private Integer actionId;

    private String sourceId;

    private String userParkId;

    private String userOrgId;

    private String userId;

    private String userClient;

    private String userIp;

    private String logContent;

    private String logYear;

    private String logMonth;

    private String logDay;

    private String logTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getUserParkId() {
        return userParkId;
    }

    public void setUserParkId(String userParkId) {
        this.userParkId = userParkId;
    }

    public String getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserClient() {
        return userClient;
    }

    public void setUserClient(String userClient) {
        this.userClient = userClient;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getLogYear() {
        return logYear;
    }

    public void setLogYear(String logYear) {
        this.logYear = logYear;
    }

    public String getLogMonth() {
        return logMonth;
    }

    public void setLogMonth(String logMonth) {
        this.logMonth = logMonth;
    }

    public String getLogDay() {
        return logDay;
    }

    public void setLogDay(String logDay) {
        this.logDay = logDay;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}