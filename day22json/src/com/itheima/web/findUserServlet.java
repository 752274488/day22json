package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class findUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("111111");
        //获取用户名
        String username = request.getParameter("username");
        System.out.println(username);
        //进行判断
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map= new HashMap<>();
        if("tom".equals(username))
        {
            //存在
            map.put("userExsit",true);
            map.put("msg","用户名已存在");
        }
        else{
            map.put("userExsit",false);
            map.put("msg","注册成功");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
