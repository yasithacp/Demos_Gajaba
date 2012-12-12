package org.gajaba.demo;

import org.gajaba.agent.Agent;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

public class ContextListener implements ServletContextListener {

    public static final String LOCALHOST = "localhost";
    public static final String SERVER_ID = "serverId";
    public static final String IMAGE_SERVER = "imageServer";
    private static final String TMP_DIR_PATH = "./content";

    private static Agent agent;
    private static String serverId;
    private static File tempDir;
    private static Stack<String> done = new Stack<String>();
    private static List<String> processing = new ArrayList<String>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        agent = new Agent();
        serverId = servletContextEvent.getServletContext().getInitParameter(SERVER_ID);
        String ipAddress = getIPAddress();
        agent.start(ipAddress, IMAGE_SERVER + getServerId());
        agent.publish("id",getServerId());


        tempDir = new File(TMP_DIR_PATH);
        if (tempDir.exists()) {
            if (tempDir.isDirectory()) {
                deleteFolder(tempDir);
            } else {
                tempDir.delete();
            }
        }
        tempDir.mkdirs();


//        new Thread(new Publisher()).start();
    }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) { //some JVMs return null for empty dirs
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public static Agent getAgent() {
        return agent;
    }

    public static String getServerId() {
        return serverId;
    }

    public static File getTempDir() {
        return tempDir;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    public static String getIPAddress() {
        List<InetAddress> ipAddresses = new ArrayList<InetAddress>();
        String ipAddress = null;

        Enumeration e;
        try {
            e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface ni;
                ni = (NetworkInterface) e.nextElement();
                if (ni.isLoopback() || !ni.isUp()) continue;

                for (Enumeration e2 = ni.getInetAddresses(); e2.hasMoreElements(); ) {
                    InetAddress ip = (InetAddress) e2.nextElement();
                    ipAddresses.add(ip);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        if (ipAddresses.isEmpty()) {
            return LOCALHOST;
        } else {
            for (InetAddress ip : ipAddresses) {
                if (ip instanceof Inet4Address) {
                    ipAddress = ip.getHostAddress();
                    break;
                }
            }
        }

        if (ipAddress == null) {
            ipAddress = ipAddresses.get(0).getHostAddress();
        }

        if (ipAddress == null) {
            ipAddress = LOCALHOST;
        }

        return ipAddress;
    }

    public static void addDone(File file) {
        done.add(0, file.getName());
    }

    public static void removeProcessing(File file) {
        processing.remove(file.getName());
    }

    public static void addProcessing(File file) {
        processing.add(file.getName());
    }

    public static List<String> getDoneList() {
        return Collections.unmodifiableList(done);
    }

    public static List<String> getProcessingList() {
        return Collections.unmodifiableList(processing);
    }
}

