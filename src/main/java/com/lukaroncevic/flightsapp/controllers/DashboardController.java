package com.lukaroncevic.flightsapp.controllers;

import com.lukaroncevic.flightsapp.services.DashboardService;
import com.lukaroncevic.flightsapp.services.PageSuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import util.FilenameUtils;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Qualifier("html")
    @Autowired
    private PageSuffixService pageSuffixService;

    @Autowired
    private FilenameUtils filenameUtils;

    @GetMapping("/dashboard")
    public String getDashboard(){
        return dashboardService.getDashboard() + filenameUtils.getSuffixSeparator() + pageSuffixService.getSuffix();
    }
}
