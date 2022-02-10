package com.ohohoi.frontcontroller.controller;

import com.ohohoi.frontcontroller.handler.Handler;
import com.ohohoi.frontcontroller.handler.impl.HomeHandler;
import com.ohohoi.frontcontroller.handler.impl.LoginHandler;
import com.ohohoi.frontcontroller.view.View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = { "/home/*", "/login/*" })
public class FrontController extends HttpServlet {
    private final Map<String, Handler> urlMap;

    public FrontController(HomeHandler homeController, LoginHandler loginController) {
        urlMap = new HashMap<>();

        urlMap.put("/home", homeController);
        urlMap.put("/login", loginController);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 모든 요청에 대한 공통 로직


        // URL Map에서 URL에 해당하는 Handler를 찾 Handler로부터 View를 리턴받는다.
        String requestURI = req.getRequestURI();

        if (urlMap.containsKey(requestURI)) {
            String method = req.getMethod();
            Handler handler = urlMap.get(requestURI);
            Map<String, Object> model = new HashMap<>();

            if (method.equals("GET")) {
                String viewName = handler.doGet(req.getParameterMap(), req.getSession(), model);
                View view = new View(viewName, model);

                view.render(req, resp);
            }
            else if (method.equals("POST")) {
                String viewName = handler.doPost(req.getParameterMap(), req.getSession(), model);
                View view = new View(viewName, model);

                view.render(req, resp);
            }
            else {
                resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            }
        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
