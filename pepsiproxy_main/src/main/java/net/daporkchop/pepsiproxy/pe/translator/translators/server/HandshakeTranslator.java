package net.daporkchop.pepsiproxy.pe.translator.translators.server;

import com.github.steveice10.mc.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.packetlib.Session;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pc.server.PcServer;
import net.daporkchop.pepsiproxy.pc.server.PcServerSession;
import net.marfgamer.jraknet.RakNetPacket;

public class HandshakeTranslator implements IPeTranslator<HandshakePacket> {
    public RakNetPacket[] toPe(HandshakePacket toTranslate, Session session, PcServer server, PcServerSession serverSession) {
        //TODO:
        return null;
    }
}
