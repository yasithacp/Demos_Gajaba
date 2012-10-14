
import org.gajaba.agent.Agent;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static java.lang.Thread.sleep;
import org.gajaba.sample.agent.AgentFrame;

public class Main {

    public static final String LOCALHOST = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {

        Agent agent = new Agent();

        agent.start(getIPAddress(), String.valueOf(System.currentTimeMillis()));


        AgentFrame f = new AgentFrame();
        f.show();

        while (true){
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            f.updateData(operatingSystemMXBean);
            for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().startsWith("get")
                        && Modifier.isPublic(method.getModifiers())) {
                    Object value;
                    try {
                        value = method.invoke(operatingSystemMXBean);
                    } catch (Exception e) {
                        value = e;
                    } // try
                    System.out.println(method.getName() + " = " + value.toString());
                    agent.publish(method.getName(), value.toString());
                } // if
            } // for
           sleep(2000);
        }

    }

    public static String getIPAddress() {
        List<InetAddress> ipAddresses = new ArrayList<InetAddress>();
        String ipAddress = null;

        Enumeration e;
        try {
            e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                if (ni.isLoopback() || !ni.isUp()) continue;

                for (Enumeration e2 = ni.getInetAddresses(); e2.hasMoreElements(); ) {
                    InetAddress ip = (InetAddress) e2.nextElement();
                    ipAddresses.add(ip);
                }
            }
        } catch (SocketException e1) {
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

        if(ipAddress == null){
            ipAddress = LOCALHOST;
        }

        return ipAddress;
    }
}
