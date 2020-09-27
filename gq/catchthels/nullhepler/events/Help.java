package gq.catchthels.nullhepler.events;

import java.awt.Color;

import gq.catchthels.nullhepler.utils.Embed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equals("/help")) {
            Embed.sendEmbed("Lets help somebody", "Available commands:\n ban\n clearwarns\n warns\n kick\n warn\n help\n clear\n Maybe coming soon: setmaxwarns.", Color.RED, event.getChannel().getName());
        }
    }

}