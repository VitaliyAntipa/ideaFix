package com.ideafix.service;

import com.ideafix.model.dto.ReportDTO;
import com.ideafix.model.pojo.Report;

public interface ReportService {

    Report create(ReportDTO newReport);

    void delete(long reportId);
}
