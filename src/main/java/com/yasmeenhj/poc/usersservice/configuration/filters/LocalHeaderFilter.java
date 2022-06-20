package com.yasmeenhj.poc.usersservice.configuration.filters;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

/**
 * @author YasmeenHj
 * created on 6/20/2022 at 1:38 PM
 * @project users-service
 * to Read the request header parameter (Local Param)
 */
@Component
public class LocalHeaderFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //cast servlet req to reach the header functions
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String language = httpServletRequest.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if (language == null) {
            language = "en";
        }
        LocaleContextHolder.setLocale(new Locale(language));

        chain.doFilter(request, response);
    }

}




