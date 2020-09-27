package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.utils.Embed;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ClearWarns extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equalsIgnoreCase("/clearwarns")) {
			Pattern pattern = Pattern.compile("\\d+");
		    Matcher matcher = pattern.matcher(msg[1]);
		    int start = 0;
		    while (matcher.find(start)) {
		       String value = msg[1].substring(matcher.start(), matcher.end());
		       start = matcher.end();
		       WarnUtils.warns.replace(value, 0);
		       Embed.sendEmbed("Clear warns", "User warns successfully removed!", Color.green, event.getChannel().getName());
		    }
		}
	}

}
