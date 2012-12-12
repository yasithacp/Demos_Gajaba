/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kasuncp
 */
public class UserVO implements Serializable{
    
    private String username;
    private String password;
    private String aboutme;
    private ArrayList<MessageVO> messages;
    private String groupName;

//    public UserVO() {
//            super();
//    }
//
//    public UserVO(String username) {
//            this.username = username;
//    }

    public UserVO(String username, String password, String groupName) {
            super();

            this.username = username;
            this.password = password;
            messages = new ArrayList<>();
            this.groupName = groupName;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }
    
    public String getAboutMe() {
            return aboutme;
    }

    public void setAboutMe(String aboutme) {
            this.aboutme = aboutme;
    }
    
    public void addMessage(MessageVO msg){
     
        messages.add(msg);
    }
    
    public void setMessages(ArrayList<MessageVO> msgs){
        
        messages = msgs;
    }
    
    public ArrayList<MessageVO> getMessages(){
    
        return messages;
    }
    
    public void setGroupName(String groupName){
     
        this.groupName = groupName;
    }
    
    public String getGroupName(){
     
        return groupName;
    }
    
    public String toXML() {
            StringBuilder xml = new StringBuilder();
            xml.append("<user>");
            xml.append("<username>").append(username).append(" [" + groupName + "]").append("</username>");
            xml.append("<password>").append(password).append("</password>");
            xml.append("<aboutme>").append(aboutme).append("</aboutme>");
            xml.append("</user>");

            return xml.toString();
    }

    public String toJSON() {
            StringBuilder json = new StringBuilder();
            json.append("{\"user\":{\"username\":\"").append(username).append("\", \"password\":\"").append(password).append("\", \"link\":\"").append(getLink()).append("\"}}");

            return json.toString();
    }

    private String getLink() {
            return "/users/" + username;
    }
}
