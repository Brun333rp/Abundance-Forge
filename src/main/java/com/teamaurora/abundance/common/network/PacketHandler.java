package com.teamaurora.abundance.common.network;

import com.teamaurora.abundance.common.network.messages.S2CUpdatePlayerDeafness;
import com.teamaurora.abundance.core.Abundance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {

    private static final String PROTOCOL_NAME = "ABUNDANCE";
    public static final SimpleChannel CHANNEL = createChannel();

    private int messageIndex;

    private static SimpleChannel createChannel() {
        return NetworkRegistry.ChannelBuilder
                .named(Abundance.resourceLoc("channel"))
                .serverAcceptedVersions(PROTOCOL_NAME::equals)
                .clientAcceptedVersions(PROTOCOL_NAME::equals)
                .networkProtocolVersion(() -> PROTOCOL_NAME)
                .simpleChannel();
    }

    public void registerMessages() {
        CHANNEL.registerMessage(messageIndex++, S2CUpdatePlayerDeafness.class, S2CUpdatePlayerDeafness::encode, S2CUpdatePlayerDeafness::decode, S2CUpdatePlayerDeafness::handle);
    }

    /**
     * Sends the given message to client.
     *
     * @param message The message to send to the client.
     * @param player The client player that should receive this message.
     */
    public static <MSG> void sendToClient(MSG message, ServerPlayerEntity player) {
        CHANNEL.sendTo(message, player.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
    }
}
