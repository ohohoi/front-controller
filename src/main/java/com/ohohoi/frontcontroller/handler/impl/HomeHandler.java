package com.ohohoi.frontcontroller.handler.impl;

import com.ohohoi.frontcontroller.handler.Handler;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class HomeHandler implements Handler {

    @Override
    public String doGet(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap) {
        attributeMap.put("homeMsg", "sample data");

        return "home.jsp";
    }

    @Override
    public String doPost(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap) {
        return "home.jsp";
    }
}
