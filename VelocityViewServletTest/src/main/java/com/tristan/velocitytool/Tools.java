package com.tristan.velocitytool;

//在web.xml中配置了tool，可以直接在页面上使用
public class Tools {
    public static String testTool() {
        System.out.println("test tool~~~~~");
        return "velocity tool box working!";
    }


}
