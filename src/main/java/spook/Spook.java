package spook;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import spook.commands.Info;
import spook.commands.Clear;
import spook.events.GuildMemberJoin;

import javax.security.auth.login.LoginException;

public class Spook {

    private static JDA jda;

    public static void main(String... args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setGame(Game.listening(Ref.game));

        addEvents();
    }

    // Add events to jda
    private static void addEvents(){
        jda.addEventListener(new Info());
        jda.addEventListener(new Clear());
        jda.addEventListener(new GuildMemberJoin());
    }
}
