package com.ideafix.model.dto;

public class ReportDTO {
    private String reportText;
    private long userId;
    private long ideaId;

    public ReportDTO(String reportText, long userId, long ideaId) {
        this.reportText = reportText;
        this.userId = userId;
        this.ideaId = ideaId;
    }

    public ReportDTO() {
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getReportText() {
        return reportText;
    }

    public long getUserId() {
        return userId;
    }

    public long getIdeaId() {
        return ideaId;
    }
}
