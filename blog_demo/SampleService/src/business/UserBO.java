/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;
import java.util.ArrayList;
import model.GroupVO;
import model.UserVO;

/**
 *
 * @author kasuncp
 */
public class UserBO {

    GroupVO db = null;

    public UserBO(GroupVO db) {

        this.db = db;
    }

    public String create(String uname, String pword, String aboutme, String group) throws InvalidXMLException, ItemAlreadyExistsException {

        try {

            UserVO userVO = new UserVO(uname, pword, group);
            if (userVO != null) {

                userVO.setAboutMe(aboutme);
                if (db.addUser(userVO)) {

                    return userVO.toXML();
                } else {
                    throw new ItemAlreadyExistsException();
                }
            } else {
                throw new InvalidXMLException();
            }
        } finally {
            if (db != null) {
                //db.close();
            }
        }
    }
    
    public boolean addUser(UserVO user){
    
        return db.addUser(user);
    }
         
    public UserVO removeUser(String username){
        
        return db.removeUser(username);
    }

    public String getAllXML() {

        try {
            StringBuilder users = new StringBuilder();
            users.append("<users>");

            ArrayList<UserVO> result = db.getAllUsers();
            users.append("<count>").append(result.size()).append("</count>");

            for (int i = 0; i < result.size(); ++i) {
                users.append(result.get(i).toXML());
            }

            users.append("</users>");

            return users.toString();
        } finally {
            if (db != null) {
            }
        }
    }

    public String getAllJSON() {

        try {
            StringBuilder users = new StringBuilder();

            ArrayList<UserVO> result = db.getAllUsers();

            users.append("{\"users-result\":{\"count\":\"").append(result.size()).append("\", \"users\":[");

            for (int i = 0; i < result.size(); ++i) {
                users.append(result.get(i).toJSON());

                if (result.get(i + 1) != null) {
                    users.append(",");
                }
            }

            users.append("]}}");

            return users.toString();
        } finally {
            if (db != null) {
            }
        }
    }

//	protected static UserVO query(String username) {
//		ObjectContainer db = null;
//
//		try {
//			db = Db4o.openFile(Constants.DB_NAME);
//			ObjectSet<UserVO> result = db.queryByExample(new UserVO(username));
//
//			if (result.hasNext()) {
//				return result.next();
//			} else {
//				return null;
//			}
//		} finally {
//			if (db != null) {
//				db.close();
//			}
//		}
//	}
//
//	protected static UserVO query(ObjectContainer db, String username) {
//		return query(db, username, null);
//	}
//
//	protected static UserVO query(ObjectContainer db, String username, String password) {
//		ObjectSet<UserVO> result = db.queryByExample(new UserVO(username, password));
//
//		if (result.hasNext()) {
//			return result.next();
//		} else {
//			return null;
//		}
//	}
    public String getXML(String username) {
        UserVO userVO = db.getUser(username);

        return (userVO != null) ? userVO.toXML() : null;
    }

    public String getJSON(String username) {
        UserVO userVO = db.getUser(username);

        return (userVO != null) ? userVO.toJSON() : null;
    }
//	public static String update(String xml) throws InvalidXMLException, ItemNotFoundException {
//		ObjectContainer db = null;
//		try {
//			db = Db4o.openFile(Constants.DB_NAME);
//			UserVO userVO = XMLUtil.getUserVOFromXML(xml);
//			if (userVO != null) {
//				// Check that user exists in our DB: if so, update; else, throw
//				// exception
//				UserVO tmpUser = query(db, userVO.getUsername());
//				if (tmpUser != null) {
//					// We only let the user update the password
//					tmpUser.setPassword(userVO.getPassword());
//					db.store(tmpUser);
//
//					return tmpUser.toXML();
//				} else {
//					throw new ItemNotFoundException();
//				}
//			} else {
//				throw new InvalidXMLException();
//			}
//		} finally {
//			if (db != null) {
//				db.close();
//			}
//		}
//	}
//	public void delete(String username) throws ItemNotFoundException {
//		//ObjectContainer db = null;
//
//		try {
//			//db = Db4o.openFile(Constants.DB_NAME);
//			// Check that user for username exists
//			UserVO userVO = db.getUser(username);
//			if (userVO != null) {
//				db.delete(userVO);
//			} else {
//				throw new ItemNotFoundException();
//			}
//		} finally {
//			if (db != null) {
//				db.close();
//			}
//		}
//	}
}
