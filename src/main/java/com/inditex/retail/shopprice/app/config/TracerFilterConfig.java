package com.inditex.retail.shopprice.app.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static com.inditex.retail.shopprice.app.constants.AppConstants.LOG_TRACER_ID_KEY;

@Slf4j
@Component
@Order(0)
@Primary
public class TracerFilterConfig implements Filter {
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        MDC.put(LOG_TRACER_ID_KEY, UUID.randomUUID().toString());

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        log.info("Logging request: {} {}", req.getMethod(), req.getRequestURI());
        chain.doFilter(request, response);
        log.info("Logging response: {}", res.getStatus());
    }
}
