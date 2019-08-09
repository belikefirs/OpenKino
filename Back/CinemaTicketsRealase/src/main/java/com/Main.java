package com;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class Main {
    private static int PORT = 8089;
    public static void main(String[] args) throws Exception {
        String appBase = ".";
        Tomcat tomcat;
        tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir());
        tomcat.setPort(PORT);
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
    private static String createTempDir(){
        try {
            File tempDir = File.createTempFile("tomcat", "." + PORT);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException e){
            throw new RuntimeException(
                "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"), e);
            }
        }
    }

