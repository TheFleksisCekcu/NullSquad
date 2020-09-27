package gq.catchthels.nullhepler.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotPingEvent extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].contains("<@739428844217434124>")){
			event.getChannel().sendMessage("I'm here, sir.").queue();
		}
	}

}
