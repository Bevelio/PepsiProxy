package net.daporkchop.pepsiproxy.pe.server;

import net.daporkchop.pepsiproxy.util.RakNetUtil;
import net.marfgamer.jraknet.RakNetPacket;
import net.marfgamer.jraknet.protocol.Reliability;
import net.marfgamer.jraknet.session.RakNetClientSession;
import sul.protocol.pocket113.play.*;
import sul.protocol.pocket113.types.ChunkData;
import sul.protocol.pocket113.types.Rule;
import sul.utils.Packet;
import sul.utils.Tuples;

public abstract class PeServerUtils {
    public static final byte ContainerSetContent_SPECIAL_INVENTORY = 0;
    public static final byte ContainerSetContent_SPECIAL_ARMOR = 0x78;
    public static final byte ContainerSetContent_SPECIAL_CREATIVE = 0x79;
    public static final byte ContainerSetContent_SPECIAL_HOTBAR = 0x7a;

    public static void doHandshake1(PeServerSession session, FullChunkData... chunks) {
        sendPePacket(session.session, new PlayStatus(PlayStatus.OK));

        StartGame startGame = new StartGame();
        startGame.entityId = startGame.runtimeId = 0; //TODO: check if this is correct
        startGame.gamemode = 0; //TODO: get actual gamemode
        startGame.position = new Tuples.FloatXYZ(0, 256, 0); //TODO: get actual pos
        startGame.yaw = startGame.pitch = 0; //TODO: get actual rotation
        startGame.seed = 0;
        startGame.dimension = 0; //TODO: use actual dim id
        startGame.generator = 1; //infinite
        startGame.worldGamemode = 0;
        startGame.difficulty = 0; //TODO: get actual difficulty
        startGame.spawnPosition = new Tuples.IntXYZ(0, 128, 0); //TODO: use actual pos
        startGame.loadedInCreative = false;
        startGame.time = 1000; //TODO: use actual time
        startGame.version = 0; //normal MCPE, 1 would be edu
        startGame.rainLevel = startGame.lightingLevel = 0; //TODO: use actual rain and lightning levels
        startGame.commandsEnabled = true;
        startGame.textureRequired = false;
        startGame.gameRules = new Rule[0];
        startGame.levelId = startGame.worldName = "\u00A7cPepsi\u00A79Proxy \u00A7fWorld";
        startGame.premiumWorldTemplate = "\u00A7cPepsi";
        startGame.unknown23 = false;
        startGame.worldTicks = 0; //TODO: send actual tick count

        sendPePacket(session.session, startGame);

        for (FullChunkData data : chunks)   {
            sendPePacket(session.session, data);
        }
        /*ContainerSetContent setContent = new ContainerSetContent();
        setContent.window = ContainerSetContent_SPECIAL_INVENTORY;
        setContent.entityId = 0L;
        //other fields are filled out automagically with nothing
        //TODO: send inventory
        sendPePacket(session.session, setContent);*/

        ResourcePacksInfo resourcePacksInfo = new ResourcePacksInfo();
        resourcePacksInfo.mustAccept = false;
        //other fields are filled out automagically with nothing
        //TODO: send actual packs
        sendPePacket(session.session, resourcePacksInfo);
    }

    public static void sendPePacket(RakNetClientSession session, Packet packet) {
        session.sendMessage(Reliability.RELIABLE, RakNetUtil.prepareToSend(packet));
    }
}
