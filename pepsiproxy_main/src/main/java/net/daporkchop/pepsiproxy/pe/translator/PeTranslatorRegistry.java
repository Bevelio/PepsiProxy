package net.daporkchop.pepsiproxy.pe.translator;

import com.github.steveice10.mc.protocol.packet.handshake.client.HandshakePacket;
import com.github.steveice10.mc.protocol.packet.login.client.EncryptionResponsePacket;
import com.github.steveice10.mc.protocol.packet.login.server.EncryptionRequestPacket;
import com.github.steveice10.packetlib.packet.Packet;
import net.daporkchop.pepsiproxy.api.IPeTranslator;
import net.daporkchop.pepsiproxy.pe.translator.translators.server.HandshakeTranslator;

import java.util.HashMap;

public abstract class PeTranslatorRegistry {
    /**
     * Maps all PC clientbound packets to their respective translators
     */
    public static final HashMap<Class<? extends Packet>, IPeTranslator> PC_TO_PE_CLIENT = new HashMap<>();

    /**
     * Maps all PC serverbound packets to their respective translators
     */
    public static final HashMap<Class<? extends Packet>, IPeTranslator> PC_TO_PE_SERVER = new HashMap<>();

    /**
     * optimize memory usage a bit by reusing the same ignore translator
     */
    private static final IgnoreTranslator ignore = new IgnoreTranslator();

    /**
     * SERVER -> CLIENT TRANSLATORS
     */
    static {
        PC_TO_PE_CLIENT.put(EncryptionRequestPacket.class, ignore);
    }

    /**
     * CLIENT -> SERVER TRANSLATORS
     */
    static {
        PC_TO_PE_SERVER.put(HandshakePacket.class, new HandshakeTranslator());
        PC_TO_PE_SERVER.put(EncryptionResponsePacket.class, ignore);
    }
}

