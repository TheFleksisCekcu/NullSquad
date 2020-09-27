package gq.catchthels.nullhepler.utils;

import java.awt.Color;
import java.util.List;

import gq.catchthels.nullhepler.Main;
import gq.catchthels.nullhepler.fun.Facts;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

public class Embed {
	public static void sendEmbed(String title, String message, Color color, String channel) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.addField(title, message, true);
		embed.setColor(color);
		embed.setFooter(Facts.getRandomFact());
		TextChannel ch = Main.client.getTextChannelsByName(channel, true).get(0);
		ch.sendMessage(embed.build()).queue();
	}

}
