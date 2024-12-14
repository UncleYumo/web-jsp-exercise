package com.example.jspsevletecerc07.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

/**
 * @author uncle_yumo
 * @fileName TestLinster
 * @createDate 2024/12/14 December
 * @school 无锡学院
 * @studentID 22344131
 * @description
 */

@WebListener
public class TestListener implements HttpSessionListener, HttpSessionAttributeListener {

    // 私有类属性 表示访问量
    private int count = 0;
    private int userCount = 0;

    public TestListener() {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute("count", count);  // 将访问量存入ServletContext中
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String attribute = event.getName();
        if ("username".equals(attribute)) {
            userCount++;
        }
        HttpSession session = event.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute("userCount", userCount);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String attribute = event.getName();
        if ("username".equals(attribute)) {
            userCount--;
            HttpSession session = event.getSession();
            ServletContext context = session.getServletContext();
            context.setAttribute("userCount", userCount);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }
}
