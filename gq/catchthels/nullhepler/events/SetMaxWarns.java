package gq.catchthels.nullhepler.events;

import java.awt.Color;

import gq.catchthels.nullhepler.utils.Embed;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SetMaxWarns extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/setwarns")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930") || event.getAuthor().getId().equals("705846419759562773") || event.getAuthor().getId().equals("302679502298021888")) {
				
				if(WarnUtils.maxWarns != Integer.valueOf(msg[1])) {
					WarnUtils.maxWarns = Integer.valueOf(msg[1]);
				}else {
					Embed.sendEmbed("Set max warns", "This value is already in use", Color.red, event.getChannel().getName());
				}
			
			}else {
				Embed.sendEmbed("Warn command", "You are not allowed to use that command", Color.red, event.getChannel().getName());
				return;
			}
		}
	}

}
