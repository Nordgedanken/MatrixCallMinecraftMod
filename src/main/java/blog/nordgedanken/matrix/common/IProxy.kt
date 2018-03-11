package blog.nordgedanken.matrix.common

import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.IThreadListener
import net.minecraft.world.World
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext
import javax.annotation.Nullable


interface IProxy {

    /**
     * Get the client player.
     *
     * @return The client player
     * @throws WrongSideException If called on the dedicated server.
     */
    @get:Nullable
    val clientPlayer: EntityPlayer

    /**
     * Get the client [World].
     *
     * @return The client World
     * @throws WrongSideException If called on the dedicated server.
     */
    @get:Nullable
    val clientWorld: World

    fun preInit()

    fun init()

    fun postInit()

    /**
     * Perform a right click on the client side.
     *
     * @throws WrongSideException If called on the dedicated server.
     */
    //fun doClientRightClick()

    /**
     * Get the [IThreadListener] for the [MessageContext]'s [Side].
     *
     * @param context The message context
     * @return The thread listener
     */
    fun getThreadListener(context: MessageContext): IThreadListener

    /**
     * Get the [EntityPlayer] from the [MessageContext].
     *
     * @param context The message context
     * @return The player
     */
    fun getPlayer(context: MessageContext): EntityPlayer

    /**
     * Display the lock GUI.
     *
     * @param pos    The lock's block position
     * @param facing The lock's facing
     * @throws WrongSideException If called on the dedicated server.
     */
    //fun displayLockGUI(pos: BlockPos, facing: EnumFacing)

    /**
     * Thrown when a proxy method is called from the wrong side.
     */
    class WrongSideException : RuntimeException {
        constructor(message: String) : super(message) {}

        constructor(message: String, cause: Throwable) : super(message, cause) {}
    }
}