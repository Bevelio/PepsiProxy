package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.marfgamer.jraknet.session.RakNetClientSession;

public interface IPcTranslator<T extends sul.utils.Packet> extends ITranslator {
    public Packet[] toPc(T toTranslate, RakNetClientSession session, PeServer server);
}
