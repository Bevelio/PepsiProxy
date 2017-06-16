package net.daporkchop.pepsiproxy.pe.translator.translators.server;

import com.github.steveice10.mc.protocol.packet.handshake.client.HandshakePacket;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.RakNetPacket;

public class HandshakeTranslator implements IPeTranslator<HandshakePacket> {
    public RakNetPacket[] toPe(HandshakePacket toTranslate, PeServerSession session, PeServer server) {
        server.cache.put(session.hashCode(), toTranslate);
        return null;
    }
}
