package net.daporkchop.pepsiproxy.pe.server;

import net.daporkchop.pepsiproxy.pc.translator.PcTranslatorRegistry;
import net.daporkchop.pepsiproxy.pe.translator.PePacketGenerator;
import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.server.RakNetServerListener;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.protocol.raknet8.encapsulated.Mcpe;
import sul.utils.Packet;

public class PepsiRakNetServerListener implements RakNetServerListener {
    public final PeServer server;

    public PepsiRakNetServerListener(PeServer server) {
        this.server = server;
        server.listener = this;
    }

    // Client connected
    public void onClientConnect(RakNetClientSession session) {
        System.out.println("PE session " + session.getAddress() + " joined!!!");
    }

    // Client disconnected
    public void onClientDisconnect(RakNetClientSession session, String reason) {
        System.out.println("PE session " + session.getAddress() + " disconnected because \"" + reason + "\" again");
        server.removeSession(server.getPeSessionFromRakNetClientSession(session));
    }

    // Packet received
    public void handleMessage(RakNetClientSession session, RakNetPacket packet, int channel) {
        System.out.println("Client from address " + session.getAddress() + " sent packet with ID 0x" + Integer.toHexString(packet.getId()).toUpperCase() + " on channel " + channel);
        if (packet.getId() == 0xFE) {
            Mcpe mcpe = Mcpe.fromBuffer(packet.array());
            System.out.println("MCPE packet id: 0x" + Integer.toHexString(mcpe.packet[0]));
            String s = "";
            for (byte b : packet.array()) {
                s += b + ",";
            }
            System.out.println(s);
            s = "";
            for (byte b : mcpe.packet) {
                s += b + ",";
            }
            System.out.println(s);
            Packet pck = PePacketGenerator.getFromByteArray(mcpe.packet);
            PcTranslatorRegistry.translateFromClient(pck, session, server, server.getPeSessionFromRakNetClientSession(session));
        }
    }
}
