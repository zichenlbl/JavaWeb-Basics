package com.zichen.web.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Cookie 快速入门
 * @author zc
 * @date 2021-07-17 18:57
 */
@WebServlet("/cookie02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3.获取Cookie
        Cookie[] cookies = req.getCookies();
        // 获取数据，遍历Cookies 中文解码
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                name = URLDecoder.decode(name, "utf-8");
                value = URLDecoder.decode(value, "utf-8");
                System.out.println(name + ":" + value);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
