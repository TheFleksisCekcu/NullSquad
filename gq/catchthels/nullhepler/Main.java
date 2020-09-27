package gq.catchthels.nullhepler;

import java.awt.Color;

import javax.security.auth.login.LoginException;

import gq.catchthels.nullhepler.fun.InfiniteTyping;
import gq.catchthels.nullhepler.utils.Embed;
import gq.catchthels.nullhepler.utils.WarnUtils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
	public static JDA client;
	public static String prefix = "/";
	public static void main(String[] args) throws LoginException, InterruptedException {
		client = new JDABuilder("фи.уй.фа-I6b0").build().awaitReady();
		Embed.sendEmbed("Bot is active", "Hello everyone! I am NullHelper a.k.a AutismBot\nI'm helping to moderate that server.\n\nDeveloped by <@715345547476860999> :)\n\nTotal members: " + client.getGuildById("738720305668816966").getMemberCount(), Color.GREEN, "logging");
		
		EventListener.registerEvents();
		WarnUtils.loadWarnList();
		new InfiniteTyping().start();

	}

}
