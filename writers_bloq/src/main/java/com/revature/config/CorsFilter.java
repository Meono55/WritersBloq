package com.revature.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;
    res.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    res.addHeader("Access-Control-Allow-Headers", "Content-Type");
    res.addHeader("Access-Control-Allow-Credentials", "true"); // For cookies
    res.addHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE");
    
    chain.doFilter(request, response);
  }
  
}
