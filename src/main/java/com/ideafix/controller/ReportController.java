/*
 * Created by Antipa Vitaly (meloman@gmail.com) © All Rights Reserved.
 */

package com.ideafix.controller;

import com.ideafix.exception.ExceptionHandlerController;
import com.ideafix.exception.RestException;
import com.ideafix.model.dto.ReportDTO;
import com.ideafix.model.security.JwtUser;
import com.ideafix.service.ReportService;
import com.ideafix.service.util.ValidationUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.ideafix.model.response.ControllerResponseEntity.*;

@RestController
@RequestMapping("/reports")
public class ReportController extends ExceptionHandlerController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        return successResponse("data", reportService.getAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, Object> create(@RequestBody ReportDTO reportDTO) throws RestException {
        try {
            ValidationUtil.assertNotBlank(reportDTO.getReportText(), "Report text field");

            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            reportDTO.setAuthorId(user.getId());

            return successResponse("data", reportService.create(reportDTO));
        } catch (Exception e) {
            throw new RestException();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestParam(value = "id") long id) throws RestException {
        try {
            JwtUser user = (JwtUser) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            if (user.getAuthorities()
                    .iterator()
                    .next()
                    .toString()
                    .equals("ADMIN")) {
                reportService.delete(id);

                return emptyResponse();
            }

            return errorResponse("Only Admin can delete reports");
        } catch (Exception e) {
            throw new RestException(e.getMessage(), e);
        }
    }


}
