package ua.jackson.sweater.util;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectInterceptor extends HandlerInterceptorAdapter {


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            String args = request.getQueryString() != null ? request.getQueryString() : "";
            String url = request.getRequestURI().toString() + "?" + args;
            response.setHeader("Turbolinks-Location", url);

        }
    }
}
