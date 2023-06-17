package com.lukaroncevic.flightsapp.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("prod")
@Service
public class DashboardServiceProdImpl implements DashboardService {

    @Override
    public String getDashboard() {
        return "dashboardProd";
    }
}
