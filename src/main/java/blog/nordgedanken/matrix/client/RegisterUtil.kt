package blog.nordgedanken.matrix.client

import blog.nordgedanken.matrix.Logger
import blog.nordgedanken.matrix.init.BlockInit
import blog.nordgedanken.matrix.init.ItemInit
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent


/**
 * Created by Seine Eiligkeit on 30.06.2017.
 */

open class RegisterUtil {

    @SubscribeEvent
    open fun registerBlocks(event: RegistryEvent.Register<Block>) {
        Logger.info("Going to prepare blocks...")
        BlockInit.prepareBlocks()
        Logger.info("Going to register blocks...")
        BlockInit.registerBlocks(event)
        Logger.info("[REGISTER-UTIL] Done Blocks")
    }

    @SubscribeEvent
    open fun registerItems(event: RegistryEvent.Register<Item>) {
        Logger.info("Going to prepare items...")
        ItemInit.prepareItems()
        Logger.info("Going to register items...")
        ItemInit.registerItems(event)
        Logger.info("[REGISTER-UTIL] Done Items")
    }
}