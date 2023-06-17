package com.lukaroncevic.flightsapp.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("test")
@Service
public class DashboardServiceTestImpl implements DashboardService {

    @Override
    public String getDashboard() {
        return "dashboardTest";
    }
}
