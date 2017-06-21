package net.daporkchop.pepsiproxy.util;

import net.marfgamer.jraknet.RakNetPacket;
import sul.protocol.raknet8.encapsulated.Mcpe;

/**
 *
 * @author enims
 */
public class RakNetUtil {
    public static RakNetPacket prepareToSend(byte[] buffer) {
        return new RakNetPacket(append(buffer));
    }

    public static RakNetPacket prepareToSend(sul.utils.Packet packet) {
        return new RakNetPacket(new Mcpe(packet.encode()).encode());
        //return new RakNetPacket(append(packet.encode())); // The packet encapsulation is handled by JRakNet
    }

    private static byte[] append(byte[] buff) {
        byte[] buff2 = new byte[buff.length + 1];
        int index = 0;
        buff2[index++] = (byte) 0xFE;
        for (byte b : buff) {
            buff2[index++] = b;
        }
        return buff2;
    }
}
