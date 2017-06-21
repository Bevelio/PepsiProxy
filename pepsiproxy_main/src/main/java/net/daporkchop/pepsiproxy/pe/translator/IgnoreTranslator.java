package net.daporkchop.pepsiproxy.pe.translator;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pc.server.PcServer;
import net.daporkchop.pepsiproxy.pc.server.PcServerSession;
import net.marfgamer.jraknet.RakNetPacket;

public class IgnoreTranslator implements IPeTranslator {
    public RakNetPacket[] toPe(Packet toTranslate, Session session, PcServer server, PcServerSession serverSession) {
        return null;
    }
}
