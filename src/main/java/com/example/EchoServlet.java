package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/echo")
public class EchoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        long sleep_ms = (long) Math.random() * 1000;
        try {
            PrintWriter writer = response.getWriter();
            Thread.sleep(sleep_ms);
            writer.println("echo - slept for " + sleep_ms + "ms");
            writer.close();
        } catch(Exception e) {
            System.err.println("Bummer: " + e);
        }
    }
}

// vim: sw=4 sts=4 et
