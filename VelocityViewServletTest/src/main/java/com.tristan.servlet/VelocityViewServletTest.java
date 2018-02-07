package com.tristan.servlet;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//如果有需要可以自己继承VelocityViewServlet这个类并覆写handleRequest
//启动后访问
// http://localhost:8080/vm/Velocityviewtest.vm
// http://localhost:8080/Velocityviewtest.vm
// //http://localhost:8080/abc/Velocityviewtest.vm 都可以，因为在配置文件中配置了vm的访问路径了
public class VelocityViewServletTest extends VelocityViewServlet {

    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        ctx.put("key", "This is value for the key");
        ctx.put("favoriteFruit","All");
        ctx.put("elements", new String[]{"One", "Two", "Three"});
        return getTemplate("Velocityviewtest.vm");
    }

}
