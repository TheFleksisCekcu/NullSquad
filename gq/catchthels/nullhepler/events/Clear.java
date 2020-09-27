package gq.catchthels.nullhepler.events;

import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gq.catchthels.nullhepler.Main;
import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equals("/clear")) {
			if(event.getAuthor().getId().equals("715345547476860999") || event.getAuthor().getId().equals("716230368688078930") || event.getAuthor().getId().equals("705846419759562773") || event.getAuthor().getId().equals("302679502298021888")) {
		
		if (args[0].equalsIgnoreCase(Main.prefix + "clear")) {
			if (args.length < 2) {
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete");
				usage.setDescription("Usage: `" + Main.prefix + "clear [amount of messages]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
				
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("✅ Successfully deleted " + args[1] + " messages.");
					event.getChannel().sendMessage(success.build()).queue();
				}
				catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Too many messages selected");
						error.setDescription("Between 1-100 messages can be deleted at one time.");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Selected messages are older than 2 weeks");
						error.setDescription("Messages older than 2 weeks cannot be deleted.");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		}
	}
	}
}
}
