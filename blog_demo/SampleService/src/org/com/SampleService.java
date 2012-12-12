/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.com;

import business.Constants;
import business.MessageBO;
import business.UserBO;
import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;
import exception.UserNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GroupVO;
import model.UserVO;
import org.gajaba.agent.Agent;

/**
 *
 * @author kasuncp
 */
public class SampleService {
    
    public static final String LOCALHOST = "localhost";
    
    
    private UserBO user;
    private MessageBO message;
    //private Database group;
    private GroupVO group;
    
    private Agent agent;
    
    private String currentUser;
    
    public SampleService(){
        super();
        
        agent = new Agent();
        agent.start(getIPAddress(), "xblog_service_1");
        
        InputStream file;
        
        try {
            file = new FileInputStream(Constants.DB_NAME);
            InputStream buffer = new BufferedInputStream( file );
            ObjectInput input = new ObjectInputStream ( buffer );
            
            try {
                group = (GroupVO)input.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
            }
        finally {
                input.close();
            }
    
        } catch (IOException ex) {
            Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        if(group == null)
            group = new GroupVO(Constants.BEGINNER);
        
        user = new UserBO(group);
        message = new MessageBO(group);
        
        currentUser = null; 
    }
    
    public String getIPAddress() {
        List<InetAddress> ipAddresses = new ArrayList<>();
        String ipAddress = null;

        Enumeration e;
        try {
            e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e.nextElement();
                if (ni.isLoopback() || !ni.isUp()) {
                    continue;
                }

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
    
    public String createUser(String name, String password, String aboutme, String group){
        
        try {
            String result = user.create(name, password, aboutme, group);
            
            agent.publish(name, "true");
            
            currentUser = name;
            
            
            OutputStream file;
            try {
                file = new FileOutputStream(Constants.DB_NAME);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);

                try {
                    output.writeObject(this.group);
                } 
                finally {
                    output.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    
            return result;
            
        } catch (InvalidXMLException | ItemAlreadyExistsException ex) {
            Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        StringBuilder xml = new StringBuilder();
//        xml.append("<user>");
//        xml.append("<username>").append("Error creating user!").append("</username>");
//        xml.append("<password>").append("").append("</password>");
//        xml.append("<aboutme>").append("").append("</aboutme>");
//        xml.append("</user>");
//
//        return xml.toString();
        
        return "Error creating user!";
    }
    
    public String logIn(String name, String password){
    
        UserVO loginUser = group.getUser(name);
        
        if(loginUser != null){
        
            if(loginUser.getPassword().equals(password)){
            
                currentUser = name;
                
                return loginUser.toXML();
            }
            else{
            
//                StringBuilder xml = new StringBuilder();
//                xml.append("<user>");
//                xml.append("<username>").append(name).append("</username>");
//                xml.append("<password>").append("Incorrect password!").append("</password>");
//                xml.append("<aboutme>").append("").append("</aboutme>");
//                xml.append("</user>");
//
//                return xml.toString();
                return "Incorrect password!";
            }
        }
        
//        StringBuilder xml = new StringBuilder();
//        xml.append("<user>");
//        xml.append("<username>").append("User does not exist!").append("</username>");
//        xml.append("<password>").append("").append("</password>");
//        xml.append("<aboutme>").append("").append("</aboutme>");
//        xml.append("</user>");
//
//        return xml.toString(); 
        return "User does not exist!";
    }
    
    public String getCurrentUser(){
    
        return user.getXML(currentUser);
    }
    
    public String insertMessage(String name, String password, String group, String content){
        
        try {
            String msg = message.create(content, name, password, group);
            
            OutputStream file;
            try {
                file = new FileOutputStream(Constants.DB_NAME);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);

                try {
                    output.writeObject(this.group);
                } 
                finally {
                    output.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return msg;
            
        } catch (InvalidXMLException ex) {
            Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error inserting message!";
    }
    
//    public String addUser(UserVO user){
//    
//        if(group.addUser(user)){
//        
//            OutputStream file;
//            try {
//                file = new FileOutputStream(Constants.DB_NAME);
//                OutputStream buffer = new BufferedOutputStream(file);
//                ObjectOutput output = new ObjectOutputStream(buffer);
//
//                try {
//                    output.writeObject(this.group);
//                } 
//                finally {
//                    output.close();
//                }
//
//            } catch (IOException ex) {
//                Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            return "User addition successful!";
//        }
//        else{
//        
//            return "User addition unsuccessful!";
//        }
//    }
//    
//    public UserVO removeUser(String name){
//    
//        UserVO usr = group.removeUser(name);
//        
//        if(usr != null){
//         
//            OutputStream file;
//            try {
//                file = new FileOutputStream(Constants.DB_NAME);
//                OutputStream buffer = new BufferedOutputStream(file);
//                ObjectOutput output = new ObjectOutputStream(buffer);
//
//                try {
//                    output.writeObject(this.group);
//                } 
//                finally {
//                    output.close();
//                }
//
//            } catch (IOException ex) {
//                Logger.getLogger(SampleService.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        return usr;
//    }
    
    public String getGroup(){
        return group.getName();
    }
    
    public String getXML(String name){
    
        return user.getXML(name);
    }
    
    public String getJSON(String name){
    
        return user.getJSON(name);
    }
    
    public String getAllXML(){
    
        return message.getAllXML();
    }
    
    public String getAllJSON(){
    
        return message.getAllJSON();
    }
    
    public String getAllXMLForUser(String name){
    
        return message.getAllXMLForUser(name);
    }
    
    public String getAllJSONForUser(String name){
    
        return message.getAllJSONForUser(name);
    }
    
    public String searchAllXML(String search_key){
    
        return message.searchAllXML(search_key);
    }
    
    public String searchAllJSON(String search_key){
    
        return message.searchAllJSON(search_key);
    }
    
    public String publish(String user, String key, String value){
    
        agent.publish(key, value);
        
        return "Cache updated.";
    }
    
}
