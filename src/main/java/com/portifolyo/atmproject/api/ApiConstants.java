package com.portifolyo.atmproject.api;

import org.springframework.beans.factory.annotation.Value;

public class ApiConstants {
    @Value("${base.version}")
    public static final String API_VERSION = "";
    @Value("${base.url}")
    public static final String API_BASE_URL = "";

}
