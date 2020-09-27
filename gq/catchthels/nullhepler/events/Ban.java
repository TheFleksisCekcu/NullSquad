package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ban extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/ban")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930")|| event.getAuthor().getId().equals("302679502298021888")) {
				Embed.sendEmbed("Ban command", "Banning " + msg[1], Color.GREEN, event.getChannel().getName());
				try {
					Pattern pattern = Pattern.compile("\\d+");
				    Matcher matcher = pattern.matcher(msg[1]);
				    int start = 0;
					while (matcher.find(start)) {
					       String value = msg[1].substring(matcher.start(), matcher.end());
					       start = matcher.end();
					       event.getGuild().ban(event.getGuild().getMemberById(value), 7).complete();
					       Embed.sendEmbed("Ban command", msg[1] + " has successfully banned for 7 days!", Color.green, event.getChannel().getName());
					    }
				}catch(HierarchyException e) {
					Embed.sendEmbed("Ban command", "Cannot ban " + msg[1] + "\nMember have higher role than you", Color.red, event.getChannel().getName());
				}
			
			}else {
				Embed.sendEmbed("Ban command", "You are not allowed to use that command", Color.red, event.getChannel().getName());
				return;
			}
		}
	}

}
