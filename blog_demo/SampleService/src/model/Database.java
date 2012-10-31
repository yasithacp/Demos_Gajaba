/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author kasuncp
 */
public class Database {
    
    private Map<String, UserVO> users;
    private Map<String, ArrayList<MessageVO>> messages;
    
    private GroupVO group;
    
    public Database(String groupName){
        
        users = new HashMap<String, UserVO>();
        messages = new HashMap<String, ArrayList<MessageVO>>();
        
        group = new GroupVO(groupName);
    }
    
    public boolean addUser(UserVO user){
    
        return group.addUser(user);
        
//        if(!users.containsKey(user.getUsername())){
//            
//            users.put(user.getUsername(), user);
//            return true;
//        }
//        
//        return false;
    }
    
    public boolean addMessage(MessageVO message){
        
        return group.addMessage(message);
        
//        String username = message.getUserVO().getUsername();
//    
//        if(users.containsKey(username)){
//        
//            if(messages.containsKey(username)){
//            
//                users.get(username).
//                messages.get(username).add(message);
//                return true;
//            }
//            else{
//            
//                ArrayList<MessageVO> msgs = new ArrayList<MessageVO>();
//                msgs.add(message);
//                
//                messages.put(username, msgs);
//                
//                return true;
//            }
//        }
//        
//        return false;
    }
    
    public UserVO getUser(String username){
    
        return users.get(username);
    }
    
    public ArrayList<UserVO> getAllUsers(){
    
        return (ArrayList<UserVO>)users.values();
    }
    
    public ArrayList<MessageVO> getAllMessagesByName(String username){
    
        return messages.get(username);
    }
    
    public ArrayList<MessageVO> getAllMessages(){
    
        ArrayList<MessageVO> list = new ArrayList<>();
        
        ArrayList<UserVO> userList = new ArrayList<>();
        
        Iterator iter = users.entrySet().iterator();
        while(iter.hasNext()){
        
            Map.Entry entry = (Map.Entry) iter.next();
            UserVO tempUser = (UserVO) entry.getValue();
            
            userList.add(tempUser);
        }
        
        ArrayList<MessageVO> msgList = new ArrayList<>();
        
        for(int i=0; i<userList.size(); ++i){
         
            msgList = messages.get(userList.get(i).getUsername());
            
            if(msgList != null) {
                for(int j=0; j<msgList.size(); ++j){
                    
                        list.add(msgList.get(j));
                }
            }
        }
        
        return list;
    }
    
    public ArrayList<MessageVO> searchMessages(final String search_term){
     
        ArrayList<MessageVO> list = new ArrayList<>();
        
        ArrayList<UserVO> userList = new ArrayList<>();
        
        Iterator iter = users.entrySet().iterator();
        while(iter.hasNext()){
        
            Map.Entry entry = (Map.Entry) iter.next();
            UserVO tempUser = (UserVO) entry.getValue();
            
            userList.add(tempUser);
        }
        
        
        for(int i=0; i<userList.size(); ++i){
         
            ArrayList<MessageVO> msgList = messages.get(userList.get(i).getUsername());
            
            if(msgList != null) {
                for(int j=0; j<msgList.size(); ++j){
                    
                    if(msgList.get(j).getContent().contains(search_term)) {
                        list.add(msgList.get(j));
                    }
                }
            }
        }
        
        return list;
    }
    
}
