package com.lukaroncevic.flightsapp.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!test & !prod")
@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public String getDashboard() {
        return "dashboard";
    }
}
