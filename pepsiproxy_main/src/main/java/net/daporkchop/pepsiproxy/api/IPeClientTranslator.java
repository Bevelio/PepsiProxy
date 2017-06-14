package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.marfgamer.jraknet.RakNetPacket;

public interface IPeClientTranslator extends ITranslator {
    public RakNetPacket[] toPeClient(Packet toTranslate);

    public Packet[] toPcServer(sul.utils.Packet toDecode);
}
