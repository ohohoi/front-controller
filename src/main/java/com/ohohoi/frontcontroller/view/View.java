package com.ohohoi.frontcontroller.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class View {
    private static final String REDIRECT = "redirect:";

    private final String viewName;
    private final Map<String, Object> modalMap;

    public View(String viewName, Map<String, Object> attributeMap) {
        this.viewName = viewName;
        this.modalMap = attributeMap;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (viewName.startsWith(REDIRECT)) {
            String redirectUrl = request.getContextPath() + viewName.replace(REDIRECT, "");

            response.sendRedirect(redirectUrl);
        }
        else {
            for (String key : modalMap.keySet()) {
                request.setAttribute(key, modalMap.get(key));
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/" + viewName);
            requestDispatcher.forward(request, response);
        }

    }

    public void addModel(String attributeName, Object object) {
        this.modalMap.put(attributeName, object);
    }
}
