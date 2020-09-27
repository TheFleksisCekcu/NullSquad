package gq.catchthels.nullhepler.events;


import gq.catchthels.nullhepler.Main;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageCounter extends ListenerAdapter {
	private static int totalMessages;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().isBot() == false) {
			totalMessages++;
			Main.client.getPresence().setActivity(Activity.listening("Total messages: " + totalMessages));
		}
		
	}

}
