package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Verify extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equals("/verify")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930") || event.getAuthor().getId().equals("705846419759562773")) {
				
				Pattern pattern = Pattern.compile("\\d+");
			    Matcher matcher = pattern.matcher(msg[1]);
			    int start = 0;
			    while (matcher.find(start)) {
			       String value = msg[1].substring(matcher.start(), matcher.end());
			       start = matcher.end();
			       
			       event.getGuild().addRoleToMember(value, event.getGuild().getRoleById("738803842090532915")).complete();
			       event.getGuild().addRoleToMember(value, event.getGuild().getRoleById("738799916272582796")).complete();
			       Embed.sendEmbed("User verifed!", event.getGuild().getMemberById(value).getAsMention() + " successfully verifed!", Color.green, event.getChannel().getName());
			    }
			
			}else {
				Embed.sendEmbed("Ban command", "You are not allowed to use that command", Color.red, event.getChannel().getName());
				return;
			}
			
		    
		}
	}

}
