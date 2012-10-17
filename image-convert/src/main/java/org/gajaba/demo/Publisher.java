package org.gajaba.demo;

import org.gajaba.agent.Agent;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.Thread.sleep;

public class Publisher implements Runnable {

    private final Agent agent;

    public Publisher() {
        agent = ContextListener.getAgent();
    }

    @Override
    public void run() {
        while (true) {
            OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
            for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if (method.getName().startsWith("get")
                        && Modifier.isPublic(method.getModifiers())) {
                    Object value;
                    try {
                        value = method.invoke(operatingSystemMXBean);
                    } catch (Exception e) {
                        value = e;
                    }
                    String key = method.getName().substring(3);
                    System.out.println(key + " = " + value.toString());
                    if (agent != null) {
                        agent.publish(key, value.toString());
                    }
                }
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
