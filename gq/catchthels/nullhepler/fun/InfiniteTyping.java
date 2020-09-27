package gq.catchthels.nullhepler.fun;

import java.util.List;

import gq.catchthels.nullhepler.Main;
import net.dv8tion.jda.api.entities.TextChannel;

public class InfiniteTyping extends Thread {
	@Override
	public void run() {
		List<TextChannel> channels = Main.client.getGuildById("738720305668816966").getTextChannels();
		while(true) {
			for(int i = 0; i < channels.size(); i++) {
				channels.get(i).sendTyping().queue();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
	}

}
