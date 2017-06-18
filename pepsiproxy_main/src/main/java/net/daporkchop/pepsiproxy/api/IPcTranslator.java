package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.session.RakNetClientSession;

public interface IPcTranslator<T extends sul.utils.Packet> extends ITranslator {
    public Packet[] toPc(T toTranslate, RakNetClientSession session, PeServer server, PeServerSession peServerSession);
}
