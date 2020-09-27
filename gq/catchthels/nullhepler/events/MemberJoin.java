package gq.catchthels.nullhepler.events;

import java.awt.Color;

import gq.catchthels.nullhepler.utils.TimeUtil;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.addField("A new member joined", "\nTime: " + TimeUtil.time() + "\nUser: " + event.getUser().getAsMention() + "\nBot: " + event.getUser().isBot() + "\nAccount creation date: " + event.getUser().getTimeCreated(), true);
		embed.setColor(Color.green);
		embed.setThumbnail(event.getUser().getAvatarUrl());
		event.getGuild().getTextChannelsByName("logging", true).get(0).sendMessage(embed.build()).queue();
		event.getUser().openPrivateChannel().queue((channel) ->
        {
        	embed.clear();
        	embed.addField("Hello, " + event.getUser().getName() + ", Welcome to NullSquad", "Wait until you get verifed.", true);
        	embed.setColor(Color.green);
        	channel.sendMessage(embed.build()).queue();
        	WarnUtils.warns.put(event.getUser().getId(), 0);
        });
        
	}

}
