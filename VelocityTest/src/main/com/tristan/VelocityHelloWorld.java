package com.tristan;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Properties;

public class VelocityHelloWorld {

    public static void main(String[] args) {

        VelocityEngine velocityEngine = new VelocityEngine();
        Properties p = new Properties();
        p.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.init(p);

        Template template = velocityEngine.getTemplate("velocityhelloworld.vm");

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name", "gordon");
        velocityContext.put("site","velocity");

        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        System.out.println(writer.toString());

    }

}
