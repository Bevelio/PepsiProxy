package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.pc.server.PcServer;
import net.daporkchop.pepsiproxy.pc.server.PcServerSession;

public interface IPcTranslator<T extends sul.utils.Packet> extends ITranslator {
    public Packet[] toPc(T toTranslate, PcServerSession session, PcServer server);
}
