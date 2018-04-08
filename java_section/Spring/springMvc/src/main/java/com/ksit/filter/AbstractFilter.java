package com.ksit.filter;

import javax.servlet.*;
import java.io.IOException;

public abstract class AbstractFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public abstract void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException ;

    @Override
    public void destroy() {

    }

}