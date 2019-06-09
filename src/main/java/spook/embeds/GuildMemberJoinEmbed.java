package spook.embeds;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;
import java.util.Objects;

public class GuildMemberJoinEmbed {

    public static void greetMember(GuildMemberJoinEvent event){
        EmbedBuilder greet = new EmbedBuilder();
        greet.setColor(Color.ORANGE);
        greet.setDescription("Welcome to the server, " + event.getMember().getAsMention());
        Objects.requireNonNull(event.getGuild().getDefaultChannel()).sendMessage(greet.build()).queue();
    }
}
