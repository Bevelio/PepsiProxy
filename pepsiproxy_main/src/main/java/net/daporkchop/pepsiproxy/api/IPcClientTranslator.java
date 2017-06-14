package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.marfgamer.jraknet.RakNetPacket;

public interface IPcClientTranslator extends ITranslator {
    public Packet[] toPcClient(sul.utils.Packet toTranslate);

    public RakNetPacket[] toPeServer(Packet toDecode);
}
