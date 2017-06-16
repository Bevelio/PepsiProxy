package net.daporkchop.pepsiproxy.pe.translator.translators.server;

import com.github.steveice10.mc.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.protocol.packet.login.client.LoginStartPacket;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pe.server.PeServer;
import net.daporkchop.pepsiproxy.pe.server.PeServerSession;
import net.marfgamer.jraknet.RakNetPacket;
import sul.protocol.pocket113.play.Login;
import sul.utils.Buffer;

public class LoginStartTranslator implements IPeTranslator<LoginStartPacket> {
    public RakNetPacket[] toPe(LoginStartPacket toTranslate, PeServerSession session, PeServer server) {
        HandshakePacket handshakePacket = (HandshakePacket) server.cache.getOrDefault(session.hashCode(), null);
        Login toSend = new Login();
        toSend.version = 0; //vanilla
                            //1 would be education edition
        //TODO: encode data
        return null;
    }
}
