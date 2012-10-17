package org.gajaba.demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.apache.commons.io.IOUtils.copy;

public class ImageServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String path = ((HttpServletRequest) servletRequest).getPathInfo();
        ServletContext cntx = getServletContext();
        String mime = cntx.getMimeType(path);

        servletResponse.setContentType(mime);
        File file = new File(ContextListener.getTempDir(), path);
        servletResponse.setContentLength((int) file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = servletResponse.getOutputStream();

        copy(in, out);

        out.close();
        in.close();
    }
}
