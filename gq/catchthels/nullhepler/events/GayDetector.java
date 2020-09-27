package gq.catchthels.nullhepler.events;

import java.awt.Color;

import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GayDetector extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] msg = event.getMessage().getContentRaw().split(" ");
		if(msg[0].equals("/gay")) {
			Embed.sendEmbed("Gay Detector", ":rainbow_flag: " + msg[1] + " is gay with " + (byte) (Math.random()*101) + "%", Color.GREEN, event.getChannel().getName());
		}
	}

}
