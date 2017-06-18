package net.daporkchop.pepsiproxy.api;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.packet.Packet;
import net.marfgamer.jraknet.RakNetPacket;

public interface IPeTranslator<T extends Packet> extends ITranslator {
    public RakNetPacket[] toPe(T toTranslate, Session session);
}
