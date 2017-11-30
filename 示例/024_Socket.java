package org.jamee.demo.webapp;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SSEDemo extends HttpServlet {
    private static final long serialVersionUID = 6205864980814040417L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("get requestion from client");
            response.setContentType("text/event-stream"); //SSE header
            PrintWriter pw = response.getWriter();
            // do something
            Thread.sleep(10 * 1000); // time consume operation
            pw.write("data:{code:0, \"message\":\"success\"}\n\n"); // SSE protocol, data:
            System.out.println("response sent");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
