package spook.events;

import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static spook.embeds.GuildMemberJoinEmbed.greetMember;

public class GuildMemberJoin extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        // Greet new user
        greetMember(event);

        // Add role
        event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Member",true)).complete();
    }
}
