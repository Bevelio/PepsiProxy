package net.daporkchop.pepsiproxy.pc.translator;

import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.api.IPcTranslator;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.session.RakNetClientSession;

public class IgnoreTranslator implements IPcTranslator {
    @Override
    public Packet[] toPc(sul.utils.Packet toTranslate, RakNetClientSession session, PeServer server, PeServerSession serverSession) {
        return null;
    }
}
