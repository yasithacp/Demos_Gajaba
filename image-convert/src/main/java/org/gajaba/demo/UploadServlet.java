package org.gajaba.demo;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.gajaba.demo.converter.BlackAndWhiteConverter;
import org.gajaba.demo.converter.BlurConverter;
import org.gajaba.demo.converter.ImageConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {

    private static final String TMP_DIR_PATH = "./content";
    private File tmpDir;
    private File destinationDir;
    private static final Map<String, ImageConverter> converters = new HashMap<String, ImageConverter>();

    static {
        converters.put("bw", new BlackAndWhiteConverter());
        converters.put("bl", new BlurConverter());
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        destinationDir = tmpDir = ContextListener.getTempDir();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("<h1>Servlet File Uploader using Commons File Upload</h1>");
        out.println();

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        /* *Set the size threshold, above which content will be stored on disk. */
        fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB
        /* * Set the temporary directory to store the uploaded files of size above threshold. */
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
        try {
            /* * Parse the request */
            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                /* * Handle Form Fields. */
                if (item.isFormField()) {
                    out.println("File Name = " + item.getFieldName() + ", Value = " + item.getString());
                } else {
                    //Handle Uploaded files.
                    out.println("Field Name = " + item.getFieldName()
                            + ", File Name = " + item.getName()
                            + ", Content type = " + item.getContentType()
                            + ", File Size = " + item.getSize());

                    File file = new File(destinationDir, item.getName());
                    item.write(file);

                    String action = request.getParameter("action");
                    ConvertTask task = new ConvertTask(destinationDir, item.getName(), action);
                    new Thread(task).start();

                }
                out.close();
                System.gc();
            }
        } catch (FileUploadException ex) {
            log("Error encountered while parsing the request", ex);
        } catch (Exception ex) {
            log("Error encountered while uploading file", ex);
        }

    }
}
