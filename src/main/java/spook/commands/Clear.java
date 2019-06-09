package spook.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import spook.Ref;
import spook.Spook;

import java.util.List;

import static spook.embeds.ClearEmbeds.*;

public class Clear extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].equalsIgnoreCase(Ref.prefix + "clear")){
            if(args.length < 2){
                notEnoughArguments(event);
            } else {
                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    if (Integer.parseInt(args[1]) > messages.size()) {
                        toManyMessages(event, Integer.parseInt(args[1]));
                    }
                    deleteMessages(event,messages);
                    success(event,Integer.parseInt(args[1]));
                } catch (IllegalArgumentException e) {
                    if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                        exceedMessageLimit(event);
                    }
                }
            }
        }
    }

    private static void deleteMessages(GuildMessageReceivedEvent event, List<Message> messages){
        event.getChannel().deleteMessages(messages).queue();
    }
}
