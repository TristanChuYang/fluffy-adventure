package com.tristan.test;

import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

public class TestGroovy {

    public static void main(String[] args) {

        GroovyShell groovyShell = new GroovyShell();
        try {
            groovyShell.evaluate("println 'Hello World!!!'");
            Object result = groovyShell.evaluate(new File("Groovy_Samples/src/groovy/GroovyMetaProTest.groovy"));
            System.out.println(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
