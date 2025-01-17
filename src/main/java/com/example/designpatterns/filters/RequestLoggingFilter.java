package com.example.designpatterns.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        LOGGER.info("Incoming request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());

        // Continue cu procesarea cererii
        chain.doFilter(request, response);

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        LOGGER.info("Outgoing response: " + httpResponse.getStatus());
    }
}
