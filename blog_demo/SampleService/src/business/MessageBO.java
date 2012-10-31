/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import exception.InvalidXMLException;
import exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.GroupVO;
import model.MessageVO;
import model.UserVO;

/**
 *
 * @author kasuncp
 */
public class MessageBO {
    
    GroupVO db = null;
    
    public MessageBO(GroupVO db) {
    
        this.db = db;
    }

    public String create(String content, String uname, String pword, String group) throws InvalidXMLException, UserNotFoundException {
            //ObjectContainer db = null;

        try {
                //db = Db4o.openFile(Constants.DB_NAME);
                //MessageVO messageVO = XMLUtil.getMessageVOFromXML(xml);
                MessageVO messageVO = new MessageVO(content, new UserVO(uname, pword, group));

                if (messageVO != null) {
                        // Add message only if user is registered
                        if (db.addMessage(messageVO)) {

                                return messageVO.toXML();
                        } else {
                                throw new UserNotFoundException();
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

    private ArrayList<MessageVO> getAllForUser(final String username) {
            //ObjectContainer db = null;
        ArrayList<MessageVO> list = null;

        try {
                //db = Db4o.openFile(Constants.DB_NAME);

                // Check that user exists
                //final UserVO userVO = UserBO.query(db, username);
            final UserVO userVO = db.getUser(username);
                if (userVO == null) {
                        return new ArrayList<MessageVO>();
                }

                list = db.getAllMessagesByName(username);

                ArrayList<MessageVO> newList = new ArrayList<MessageVO>();
                for (MessageVO vo : list) {
                        newList.add(vo);
                }

                return (list == null) ? new ArrayList<MessageVO>() : newList;
        } finally {
                if (db != null) {
                        //db.close();
                }
        }
}

    public String getAllXMLForUser(String username) {
            return getAllXMLStructure(getAllForUser(username));
    }

    public String getAllJSONForUser(String username) {
            return getAllJSONStructure(getAllForUser(username));
    }

    private ArrayList<MessageVO> searchMessages(final String search_item) {
            
        //ObjectContainer db = null;
            ArrayList<MessageVO> list = null;
            try {
                    //db = Db4o.openFile(Constants.DB_NAME);

                    list = db.searchMessages(search_item);

                    ArrayList<MessageVO> newList = new ArrayList<MessageVO>();
                    for (MessageVO vo : list) {
                            newList.add(vo);
                    }

                    return (list == null) ? new ArrayList<MessageVO>() : newList;
            } finally {
                    if (db != null) {
                            //db.close();
                    }
            }
	}

	private static String getAllXMLStructure(List<MessageVO> result) {
		StringBuilder users = new StringBuilder();
		users.append("<messages>");
		users.append("<count>").append(result.size()).append("</count>");

		for (MessageVO vo : result) {
			users.append(vo.toXML());
		}

		users.append("</messages>");

		return users.toString();
	}

	// Declared final because of inner class access
	public String searchAllXML(String search_item) {
		return getAllXMLStructure(searchMessages(search_item));
	}

	private String getAllJSONStructure(List<MessageVO> result) {
		StringBuilder messages = new StringBuilder();
		int size = result.size();
		messages.append("{\"messages-result\":{\"count\":\"").append(size).append("\", \"messages\":[");

		for (int i = 0; i < size; i++) {
			messages.append(result.get(i).toJSON());

			if (i + 1 < size) {
				messages.append(",");
			}
		}

		messages.append("]}}");

		return messages.toString();
	}

	public String searchAllJSON(String search_item) {
		return getAllJSONStructure(searchMessages(search_item));
	}

	public String getAllXML() {
		//ObjectContainer db = null;
		try {
			//db = Db4o.openFile(Constants.DB_NAME);
			// Refer to Chapter 4 for the specific structure
			StringBuilder users = new StringBuilder();
			users.append("<messages>");

			ArrayList<MessageVO> result = db.getAllMessages();
			users.append("<count>").append(result.size()).append("</count>");

			for(int i=0; i<result.size(); ++i) {
				users.append(result.get(i).toXML());
			}

			users.append("</messages>");

			return users.toString();
		} finally {
			if (db != null) {
				//db.close();
			}
		}
	}

	public String getAllJSON() {
		//ObjectContainer db = null;
		try {
			//db = Db4o.openFile(Constants.DB_NAME);
			// Refer to Chapter 4 for the specific structure
			StringBuilder messages = new StringBuilder();

			ArrayList<MessageVO> result = db.getAllMessages();
			messages.append("{\"messages-result\":{\"count\":\"").append(result.size()).append("\", \"messages\":[");

			for(int i=0; i<result.size(); ++i) {
				messages.append(result.get(i).toJSON());

				if (result.get(i+1) != null) {
					messages.append(",");
				}
			}

			messages.append("]}}");

			return messages.toString();
		} finally {
			if (db != null) {
				//db.close();
			}
		}
	}

//	private static MessageVO queryMessage(ObjectContainer db, String messageID) {
//		ObjectSet<MessageVO> result = db.queryByExample(new MessageVO(messageID));
//
//		if (result.hasNext()) {
//			return result.next();
//		} else {
//			return null;
//		}
//	}
//
//	private static MessageVO queryMessage(String messageID) {
//		ObjectContainer db = null;
//
//		try {
//			db = Db4o.openFile(Constants.DB_NAME);
//			ObjectSet<MessageVO> result = db.queryByExample(new MessageVO(messageID));
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

//	public static String getXML(String messageID) {
//		MessageVO messageVO = queryMessage(messageID);
//
//		return (messageVO != null) ? messageVO.toXML() : null;
//	}
//
//	public static String getJSON(String messageID) {
//		MessageVO messageVO = queryMessage(messageID);
//
//		return (messageVO != null) ? messageVO.toJSON() : null;
//	}
//
//	public static void delete(String messageID) throws ItemNotFoundException {
//		ObjectContainer db = null;
//
//		try {
//			db = Db4o.openFile(Constants.DB_NAME);
//			// Check that message for messageID exists
//			MessageVO messageVO = queryMessage(db, messageID);
//			if (messageVO != null) {
//				db.delete(messageVO);
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
