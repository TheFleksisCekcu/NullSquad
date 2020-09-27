package gq.catchthels.nullhepler;

import gq.catchthels.nullhepler.events.*;

public class EventListener extends Main {
	public static void registerEvents() {
		client.addEventListener(new MessageCounter());
		client.addEventListener(new GayDetector());
		client.addEventListener(new EveryoneBlocker());
		client.addEventListener(new Kick());
		client.addEventListener(new Ban());
		client.addEventListener(new MemberJoin());
		client.addEventListener(new MemberLeave());
		client.addEventListener(new Verify());
		client.addEventListener(new GetWarns());
		client.addEventListener(new WarnUser());
		client.addEventListener(new SetMaxWarns());
		client.addEventListener(new ClearWarns());
		client.addEventListener(new BotPingEvent());
		client.addEventListener(new Clear());
		client.addEventListener(new Help());
	}

}
