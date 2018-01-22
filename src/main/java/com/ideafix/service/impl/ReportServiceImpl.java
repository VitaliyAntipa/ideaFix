package com.ideafix.service.impl;

import com.ideafix.dao.ReportDAO;
import com.ideafix.model.dto.ReportDTO;
import com.ideafix.model.pojo.Report;
import com.ideafix.service.IdeaService;
import com.ideafix.service.ReportService;
import com.ideafix.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    private ReportDAO reportDAO;
    private UserService userService;
    private IdeaService ideaService;

    public ReportServiceImpl(ReportDAO reportDAO, UserService userService, IdeaService ideaService) {
        this.reportDAO = reportDAO;
        this.userService = userService;
        this.ideaService = ideaService;
    }

    @Override
    public Report create(ReportDTO newReport) {
        Report report = new Report();

        report.setDescription(newReport.getReportText());
        report.setAuthor(userService.getUserById(newReport.getUserId()));
        report.setReportedOn(ideaService.getIdeaById(newReport.getIdeaId()));

        return reportDAO.saveAndFlush(report);
    }

    @Override
    public void delete(long reportId) {
        reportDAO.delete(reportId);
    }
}
