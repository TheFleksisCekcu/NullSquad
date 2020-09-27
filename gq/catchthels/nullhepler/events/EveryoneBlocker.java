package gq.catchthels.nullhepler.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EveryoneBlocker extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String msg = event.getMessage().getContentRaw();
		if(msg.contains("@everyone") || msg.contains("@here")) {
			if(event.getAuthor().getId().equals("716230368688078930") ||  event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("302679502298021888")) {
			}else {
				event.getMessage().delete().complete();
				event.getChannel().sendMessage("<@" + event.getAuthor().getId() + ">, don't ping everyone.").queue();
			}
		}
	}

}
