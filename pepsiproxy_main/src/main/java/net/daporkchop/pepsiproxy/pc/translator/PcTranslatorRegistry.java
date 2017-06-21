package net.daporkchop.pepsiproxy.pc.translator;

import net.daporkchop.pepsiproxy.api.IPcTranslator;
import net.daporkchop.pepsiproxy.pc.translator.translators.server.LoginTranslator;
import net.daporkchop.pepsiproxy.pe.PePacketIDs;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.protocol.pocket113.play.Login;
import sul.utils.Packet;

import java.util.HashMap;

public abstract class PcTranslatorRegistry {
    /**
     * Maps all PC clientbound packets to their respective translators
     */
    public static final HashMap<Byte, IPcTranslator> PE_TO_PC_CLIENT = new HashMap<>();

    /**
     * Maps all PC serverbound packets to their respective translators
     */
    public static final HashMap<Byte, IPcTranslator> PE_TO_PC_SERVER = new HashMap<>();

    /**
     * Slightly optimize RAM usage by keeping the same instance
     */
    private static final IPcTranslator ignore = new IgnoreTranslator();

    /**
     * SERVER -> CLIENT TRANSLATORS
     */
    static {

    }

    /**
     * CLIENT -> SERVER TRANSLATORS
     */
    static {
        PE_TO_PC_SERVER.put(PePacketIDs.LOGIN_PACKET, new LoginTranslator());
    }

    public static void translateFromClient(Packet packet, RakNetClientSession netSession, PeServer server, PeServerSession session) {
        IPcTranslator translator = PE_TO_PC_SERVER.getOrDefault((Byte) (byte) packet.getId(), null);
        if (translator != null) {
            com.github.steveice10.packetlib.packet.Packet[] packets = translator.toPc(packet, netSession, server, session);
            if (packets == null || packets.length == 0) {
                return;
            }

            if (packet._buffer[0] == Login.ID) {
                session = server.getPeSessionFromRakNetClientSession(netSession);
            }

            for (com.github.steveice10.packetlib.packet.Packet pck : packets) {
                session.client.client.getSession().send(pck);
            }
        }
    }
}
