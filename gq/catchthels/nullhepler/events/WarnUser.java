package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WarnUser extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/warn")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930") || event.getAuthor().getId().equals("705846419759562773") || event.getAuthor().getId().equals("302679502298021888")) {
				Pattern pattern = Pattern.compile("\\d+");
			    Matcher matcher = pattern.matcher(msg[1]);
			    int start = 0;
			    while (matcher.find(start)) {
			       String value = msg[1].substring(matcher.start(), matcher.end());
			       start = matcher.end();
			       WarnUtils.warns.replace(value, WarnUtils.warns.get(value).intValue()+1);
			       if(WarnUtils.warns.get(value).intValue() < WarnUtils.maxWarns) {
			    	   Embed.sendEmbed("Warn system", "<@" + value + "> successfully warned(" + WarnUtils.warns.get(value).intValue() + ")", Color.green, event.getChannel().getName());
			       }else {
			    	   Embed.sendEmbed("Warn system", "<@" + value + "> have " + WarnUtils.warns.get(value).intValue() + " warns. Kicking...", Color.orange, event.getChannel().getName());
				       event.getGuild().kick(event.getGuild().getMemberById(value)).complete();
			       }
			
			}
		    }else {
		    	Embed.sendEmbed("Ban command", "You are not allowed to use that command\n" + event.getAuthor().getId(), Color.red, event.getChannel().getName());
				return;
		    }
		}
	}

}
