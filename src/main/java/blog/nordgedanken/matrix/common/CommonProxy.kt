package blog.nordgedanken.matrix.common

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.IThreadListener
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext

open class CommonProxy : IProxy
{

    override fun preInit() {}

    override fun init() {}

    override fun postInit() {}

    override val clientPlayer: EntityPlayer
        get() = throw IProxy.WrongSideException("Tried to get the client player on the dedicated server")
    override val clientWorld: World
        get() = throw IProxy.WrongSideException("Tried to get the client world on the dedicated server")

    override fun getThreadListener(context: MessageContext): IThreadListener {
        return if (context.side.isServer) {
            context.serverHandler.player.mcServer
        } else {
            throw IProxy.WrongSideException("Tried to get the IThreadListener from a client-side MessageContext on the dedicated server")
        }
    }

    override fun getPlayer(context: MessageContext): EntityPlayer {
        return if (context.side.isServer) {
            context.serverHandler.player
        } else {
            throw IProxy.WrongSideException("Tried to get the player from a client-side MessageContext on the dedicated server")
        }
    }
}