package net.daporkchop.pepsiproxy;

import net.daporkchop.pepsiproxy.api.IProxy;

public class PepsiProxy {
    private static PepsiProxy INSTANCE;

    public IProxy proxy;

    public static void main(String[] args)  {
        new PepsiProxy().start(args);
    }

    public void start(String[] args)  {
        INSTANCE = this;
        //TODO: load a thing
    }

    public static PepsiProxy getINSTANCE()  {
        return INSTANCE;
    }
}
