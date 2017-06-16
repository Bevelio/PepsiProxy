package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.RakNetPacket;

public interface IPeTranslator<T extends Packet> extends ITranslator {
    public RakNetPacket[] toPe(T toTranslate, PeServerSession session, PeServer server);
}
