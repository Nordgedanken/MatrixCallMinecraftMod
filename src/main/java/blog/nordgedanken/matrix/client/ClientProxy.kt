package blog.nordgedanken.matrix.client

import blog.nordgedanken.matrix.Call
import blog.nordgedanken.matrix.Logger
import blog.nordgedanken.matrix.common.IProxy
import net.minecraftforge.client.model.obj.OBJLoader
import org.apache.logging.log4j.Level
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.IThreadListener
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext
import net.minecraft.client.Minecraft

open class ClientProxy : IProxy
{
    private val MINECRAFT = Minecraft.getMinecraft()

    override val clientPlayer: EntityPlayer
        get() = MINECRAFT.player
    override val clientWorld: World
        get() = MINECRAFT.world

    override fun preInit() {
        Logger.log(Level.INFO, "Adding " + Call.MOD_ID + " to OBJLoader Instance")
        OBJLoader.INSTANCE.addDomain(Call.MOD_ID)
    }

    override fun init() {}

    override fun postInit() {}

    override fun getThreadListener(context: MessageContext): IThreadListener {
        return if (context.side.isClient) {
            MINECRAFT
        } else {
            context.serverHandler.player.mcServer
        }
    }

    override fun getPlayer(context: MessageContext): EntityPlayer {
        return if (context.side.isClient) {
            MINECRAFT.player
        } else {
            context.serverHandler.player
        }
    }
}