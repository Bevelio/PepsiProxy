package net.daporkchop.pepsiproxy.pe.translator;

import org.reflections.Reflections;
import sul.protocol.pocket113.Packets;
import sul.utils.Packet;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class PePacketGenerator {
    public static final HashMap<Class<? extends Packet>, Method> METHODS = new HashMap<>();

    static {
        try {
            Reflections reflections = new Reflections("sul.protocol.pocket113.play");
            Set<Class<? extends Packet>> kek = reflections.getSubTypesOf(Packet.class);
            for (Class<? extends Packet> clazz : kek) {
                METHODS.put(clazz, clazz.getDeclaredMethod("fromBuffer", Byte[].class));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }
    }

    public static Packet getFromByteArray(byte[] bytesIn) {
        try {
            return (Packet) METHODS.get(Packets.PLAY.get(bytesIn[0])).invoke(null, bytesIn);
        } catch (Exception e) {
            e.printStackTrace();
            //really, this can't happen
        }
        return null;
    }
}
