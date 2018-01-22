package com.ideafix.model.dto;

public class ReportDTO {
    private final String reportText;
    private final long userId;
    private final long ideaId;

    public ReportDTO(String reportText, long userId, long ideaId) {
        this.reportText = reportText;
        this.userId = userId;
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
