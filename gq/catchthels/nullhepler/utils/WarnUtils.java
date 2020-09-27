package gq.catchthels.nullhepler.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gq.catchthels.nullhepler.Main;
import net.dv8tion.jda.api.entities.Member;

public class WarnUtils {
	public static int maxWarns = 3;
	
	public static Map<String, Integer> warns = new HashMap<String, Integer>();
	
	public static void loadWarnList() {
		List<Member> members = Main.client.getGuildById("738720305668816966").getMembers();
		for(int i = 0; i < members.size(); i++) {
			warns.put(members.get(i).getId(), 0);
		}
	}
	
	public static void setMaxAmountOfWarns(int i) {
		maxWarns = i;
	}

}
