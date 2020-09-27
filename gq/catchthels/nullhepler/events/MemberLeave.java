package gq.catchthels.nullhepler.events;

import java.awt.Color;

import gq.catchthels.nullhepler.utils.TimeUtil;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@SuppressWarnings("deprecation")
public class MemberLeave extends ListenerAdapter {
	@Override
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.addField("Member leave", "\nTime: " + TimeUtil.time() + "\nUser: " + event.getUser().getAsMention() + "\nBot: " + event.getUser().isBot(), true);
		embed.setThumbnail(event.getUser().getAvatarUrl());
		embed.setColor(Color.green);
		event.getGuild().getTextChannelsByName("logging", true).get(0).sendMessage(embed.build()).queue();
		WarnUtils.warns.remove(event.getUser().getId());
		
	}

}
