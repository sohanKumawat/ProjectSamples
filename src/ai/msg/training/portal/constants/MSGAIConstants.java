package ai.msg.training.portal.constants;

import java.util.HashMap;

public class MSGAIConstants {
	
	public static final String TENANT_USER="user";
	public static final HashMap<Integer,String> visitorStatus=new HashMap<Integer,String>(){{put(1,"REQUESTED");put(3,"ACTIVE");put(2,"CLOSED");}};
	public static final int NewConversation=1;
	public static final int AssignedToOther=4;
	public static final int ClosedConversation=2;
	public static final int AssignedToMe=3;

}
