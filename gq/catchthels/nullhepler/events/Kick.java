package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/kick")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930") || event.getAuthor().getId().equals("705846419759562773") || event.getAuthor().getId().equals("302679502298021888")) {
				
				Embed.sendEmbed("Kick command", "Kicking " + msg[1], Color.GREEN, event.getChannel().getName());
				try {Pattern pattern = Pattern.compile("\\d+");
			    Matcher matcher = pattern.matcher(msg[1]);
			    int start = 0;
			    while (matcher.find(start)) {
			       String value = msg[1].substring(matcher.start(), matcher.end());
			       start = matcher.end();
			       	
			       event.getGuild().kick(event.getGuild().getMemberById(value)).complete();
			       Embed.sendEmbed("Kick command", msg[1] + " has successfully kicked!", Color.green, event.getChannel().getName());
			    }
				}catch(HierarchyException e) {
					Embed.sendEmbed("Kick command", "Cannot kick " + msg[1] + "\nMember have higher role than you", Color.red, event.getChannel().getName());
				}
			
			}else {
				Embed.sendEmbed("Kick command", "You are not allowed to use that command", Color.red, event.getChannel().getName());
				return;
			}
			
		}
	}

}
