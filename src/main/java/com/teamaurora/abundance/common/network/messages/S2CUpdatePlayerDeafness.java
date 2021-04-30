package com.teamaurora.abundance.common.network.messages;

import com.teamaurora.abundance.common.network.work.ClientWork;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class S2CUpdatePlayerDeafness {

    public final boolean deafened;

    public S2CUpdatePlayerDeafness(boolean deafened) {
        this.deafened = deafened;
    }

    public static void handle(S2CUpdatePlayerDeafness message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();

        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> ClientWork.handleUpdatePlayerDeafness(message));
        }
        context.setPacketHandled(true);
    }

    public static S2CUpdatePlayerDeafness decode(PacketBuffer buffer) {
        return new S2CUpdatePlayerDeafness(buffer.readBoolean());
    }

    public static void encode(S2CUpdatePlayerDeafness message, PacketBuffer buffer) {
        buffer.writeBoolean(message.deafened);
    }
}
