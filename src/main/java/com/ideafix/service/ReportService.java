package com.ideafix.service;

import com.ideafix.model.dto.ReportDTO;
import com.ideafix.model.pojo.Report;

import java.util.List;

public interface ReportService {

    List<Report> getAll();

    Report create(ReportDTO newReport);

    void delete(long reportId);
}
