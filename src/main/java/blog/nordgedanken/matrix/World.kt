package blog.nordgedanken.matrix

import blog.nordgedanken.matrix.audio.Magic
import blog.nordgedanken.matrix.audio.Magic.startMagic
import kotlinx.coroutines.experimental.launch
import net.minecraftforge.event.world.WorldEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


open class WorldUtil {
    @SubscribeEvent
    fun onWorldLoadEvent(event: WorldEvent.Load) {
        if (event.world.isRemote) {
            launch {
                startMagic()
            }
        }
    }
    @SubscribeEvent
    fun onWorldUnloadEvent(event: WorldEvent.Unload) {
        if (event.world.isRemote) {
            Magic.stop = true
        }
    }
}
