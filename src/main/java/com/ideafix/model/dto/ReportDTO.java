package com.ideafix.model.dto;

public class ReportDTO {
    private String reportText;
    private long authorId;
    private long ideaId;

    public ReportDTO(String reportText, long ideaId) {
        this.reportText = reportText;
        this.ideaId = ideaId;
    }

    public ReportDTO() {
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public void setIdeaId(long ideaId) {
        this.ideaId = ideaId;
    }

    public String getReportText() {
        return reportText;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getIdeaId() {
        return ideaId;
    }
}
