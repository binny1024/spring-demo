package com.servlet.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = {"/demo"},loadOnStartup = -1)
public class MyServlet implements Servlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * Called by the servlet container to allow the servlet to respond to
     * a request.
     *
     * <p>This method is only called after the servlet's <code>init()</code>
     * method has completed successfully.
     *
     * <p>  The status code of the response always should be set for a servlet
     * that throws or sends an error.
     *
     *
     * <p>Servlets typically run inside multithreaded servlet containers
     * that can handle multiple requests concurrently. Developers must
     * be aware to synchronize access to any shared resources such as files,
     * network connections, and as well as the servlet's class and instance
     * variables.
     * More information on multithreaded programming in Java is available in
     * <a href="http://java.sun.com/Series/Tutorial/java/threads/multithreaded.html">
     * the Java tutorial on multi-threaded programming</a>.
     *
     * @param req the <code>ServletRequest</code> object that contains
     *            the client's request
     * @param res the <code>ServletResponse</code> object that contains
     *            the servlet's response
     * @throws ServletException if an exception occurs that interferes
     *                          with the servlet's normal operation
     * @throws IOException      if an input or output exception occurs
     */
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service ......");
    }

    /**
     * Returns information about the servlet, such
     * as author, version, and copyright.
     *
     * <p>The string that this method returns should
     * be plain text and not markup of any kind (such as HTML, XML,
     * etc.).
     *
     * @return a <code>String</code> containing servlet information
     */
    public String getServletInfo() {
        return null;
    }

    /**
     * Called by the servlet container to indicate to a servlet that the
     * servlet is being taken out of service.  This method is
     * only called once all threads within the servlet's
     * <code>service</code> method have exited or after a timeout
     * period has passed. After the servlet container calls this
     * method, it will not call the <code>service</code> method again
     * on this servlet.
     *
     * <p>This method gives the servlet an opportunity
     * to clean up any resources that are being held (for example, memory,
     * file handles, threads) and make sure that any persistent state is
     * synchronized with the servlet's current state in memory.
     */
    public void destroy() {

    }
}
