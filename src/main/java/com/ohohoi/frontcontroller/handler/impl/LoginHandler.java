package com.ohohoi.frontcontroller.handler.impl;

import com.ohohoi.frontcontroller.handler.Handler;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginHandler implements Handler {

    @Override
    public String doGet(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap) {
        return "login.jsp";
    }

    @Override
    public String doPost(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap) {
        String loginIds = parameterMap.get("loginId")[0];

        return "login.jsp";
    }
}
