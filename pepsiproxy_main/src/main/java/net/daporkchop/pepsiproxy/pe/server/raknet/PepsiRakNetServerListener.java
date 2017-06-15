package net.daporkchop.pepsiproxy.pe.server.raknet;

import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.server.RakNetServerListener;
import net.marfgamer.jraknet.session.RakNetClientSession;

public class PepsiRakNetServerListener implements RakNetServerListener {
    public final PeServer server;

    public PepsiRakNetServerListener(PeServer server) {
        this.server = server;
        server.listener = this;
    }

    // Client connected
    public void onClientConnect(RakNetClientSession session) {
        System.out.println("PE session " + session.getAddress() + " joined!!!");
        server.addSession(new PeServerSession(session));
        System.out.println("PE session " + session.getAddress() + " joined again!!!");
    }

    // Client disconnected
    public void onClientDisconnect(RakNetClientSession session, String reason) {
        System.out.println("PE session " + session.getAddress() + " disconnected because \"" + reason + "\" again");
        server.removeSession(server.getPeSessionFromRakNetClientSession(session));
        System.out.println("PE session " + session.getAddress() + " disconnected because \"" + reason + "\"");
    }

    // Packet received
    public void handleMessage(RakNetClientSession session, RakNetPacket packet, int channel) {
        System.out.println("Client from address " + session.getAddress() + " sent packet with ID 0x" + Integer.toHexString(packet.getId()).toUpperCase() + " on channel " + channel);
    }
}
