package net.daporkchop.pepsiproxy.pe.translator.translators.server;

import com.github.steveice10.mc.protocol.packet.login.client.LoginStartPacket;
import com.github.steveice10.packetlib.Session;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pc.server.PcServer;
import net.daporkchop.pepsiproxy.pc.server.PcServerSession;
import net.marfgamer.jraknet.RakNetPacket;

public class LoginStartTranslator implements IPeTranslator<LoginStartPacket> {
    public RakNetPacket[] toPe(LoginStartPacket toTranslate, Session session, PcServer server, PcServerSession serverSession) {
        /*HandshakePacket handshakePacket = (HandshakePacket) server.cache.getOrDefault(session.hashCode(), null);
        Login toSend = new Login();
        toSend.version = 0; //vanilla
                            //1 would be education edition
        Buffer buffer = new Buffer();*/

        //TODO
        return null;
    }
}
