package spook.embeds;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class InfoEmbeds {

    public static void info(GuildMessageReceivedEvent event){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Information");
        info.setDescription("Bot blanao.");
        info.setColor(Color.CYAN);
        info.setFooter("Created by Andrei Isvoran", event.getMember().getUser().getAvatarUrl());

        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage(info.build()).queue();
        info.clear();
    }
}
