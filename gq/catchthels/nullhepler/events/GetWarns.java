package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GetWarns extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/warns")) {
			Pattern pattern = Pattern.compile("\\d+");
		    Matcher matcher = pattern.matcher(msg[1]);
		    int start = 0;
		    while (matcher.find(start)) {
		       String value = msg[1].substring(matcher.start(), matcher.end());
		       start = matcher.end();
		       Embed.sendEmbed("Warn list", "Total warns: " + WarnUtils.warns.get(value), Color.green, event.getChannel().getName());
		    }
		}
		
	}

}
