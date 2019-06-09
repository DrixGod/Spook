package spook.embeds;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import spook.Spook;

public class ClearEmbeds {

    public static void success(GuildMessageReceivedEvent event, int amount){
        EmbedBuilder success = new EmbedBuilder();
        success.setTitle("Success!");
        success.setColor(0x22ff2a);
        success.setDescription("Succesfully deleted " + amount + " messages.");
        event.getChannel().sendMessage(success.build()).queue();
    }

    public static void toManyMessages(GuildMessageReceivedEvent event, int amount){
        EmbedBuilder toManyMessages = new EmbedBuilder();
        toManyMessages.setTitle("To many messages!");
        toManyMessages.setColor(0xff3923);
        toManyMessages.setDescription("The server has less than " + amount + " messages.");
        event.getChannel().sendMessage(toManyMessages.build()).queue();
    }

    public static void notEnoughArguments(GuildMessageReceivedEvent event){
        EmbedBuilder tooFewArguments = new EmbedBuilder();
        tooFewArguments.setTitle("Not enough arguments!");
        tooFewArguments.setColor(0xff3923);
        tooFewArguments.setDescription("Usage: '" + Spook.prefix + "clear [# of messages]'");
        event.getChannel().sendMessage(tooFewArguments.build()).queue();
    }

    public static void exceedMessageLimit(GuildMessageReceivedEvent event){
        EmbedBuilder exceedMessageLimit = new EmbedBuilder();
        exceedMessageLimit.setTitle("To many messages selected!");
        exceedMessageLimit.setColor(0xff3923);
        exceedMessageLimit.setDescription("Between 1 and 100 messages can be deleted at one time");
        event.getChannel().sendMessage(exceedMessageLimit.build()).queue();
    }
}
