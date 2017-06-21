package net.daporkchop.pepsiproxy.pe.translator;

import net.daporkchop.pepsiproxy.pe.misc.LoginPacketCustom;
import org.reflections.Reflections;
import sul.protocol.pocket113.Packets;
import sul.protocol.pocket113.play.Login;
import sul.utils.Packet;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PePacketGenerator {
    public static final HashMap<Class<? extends Packet>, Method> METHODS = new HashMap<>();

    public static void refreshMethods() {
        try {
            Field field = Packets.class.getDeclaredField("PLAY");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            Map<Integer, Class<? extends Packet>> map = new HashMap<>();

            for (Map.Entry<Integer, Class<? extends Packet>> entry : Packets.PLAY.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }

            //MODIFICATONS GO HERE
            map.put(1, LoginPacketCustom.class);

            field.set(null, map);

            Reflections reflections = new Reflections("sul.protocol.pocket113.play");
            Set<Class<? extends Packet>> kek = reflections.getSubTypesOf(Packet.class);
            for (Class<? extends Packet> clazz : kek) {
                try {
                    METHODS.put(clazz, clazz.getDeclaredMethod("fromBuffer", byte[].class));
                } catch (NoSuchMethodException e) {
                    //ignore, some classes don't have one
                }
            }

            Method method = LoginPacketCustom.class.getDeclaredMethod("fromBuffer", byte[].class);
            METHODS.put(LoginPacketCustom.class, method);
            METHODS.put(Login.class, method);
        } catch (Exception e) {
            e.printStackTrace();
            Runtime.getRuntime().exit(1);
        }
    }

    public static Packet getFromByteArray(byte[] bytesIn) {
        try {
            Class<? extends Packet> clazz = Packets.PLAY.get((Integer) (int) bytesIn[0]);
            Method m = METHODS.get(clazz);
            return (Packet) m.invoke(null, bytesIn);
        } catch (Exception e) {
            e.printStackTrace();
            //really, this can't happen
        }
        return null;
    }
}
