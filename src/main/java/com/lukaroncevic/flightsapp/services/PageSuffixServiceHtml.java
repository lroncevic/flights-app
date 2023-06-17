package com.lukaroncevic.flightsapp.services;

import org.springframework.stereotype.Service;

@Service("html")
public class PageSuffixServiceHtml implements PageSuffixService {
    @Override
    public String getSuffix() {
        return "html";
    }
}
