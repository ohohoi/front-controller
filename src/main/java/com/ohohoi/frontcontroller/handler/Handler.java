package com.ohohoi.frontcontroller.handler;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface Handler {
    public String doGet(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap);
    public String doPost(Map<String, String[]> parameterMap, HttpSession session, Map<String, Object> attributeMap);
}
