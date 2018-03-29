package blog.nordgedanken.matrix

import blog.nordgedanken.matrix.client.RegisterUtil
import blog.nordgedanken.matrix.common.IProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.common.MinecraftForge





@Mod(modid = Call.MOD_ID, name = Call.MOD_NAME, version = Call.VERSION, dependencies = Call.DEPENDENCIES, acceptedMinecraftVersions = "[1.12]")
object Call {

    const val MOD_ID = "matrix_call"
    const val MOD_NAME = "Matrix Call"
    const val VERSION = "1.0-SNAPSHOT"
    const val DEPENDENCIES = "required-after:forgelin@[1.6.0,);"
    const val CLIENT_PROXY = "blog.nordgedanken.matrix.client.ClientProxy"
    const val SERVER_PROXY = "blog.nordgedanken.matrix.common.CommonProxy"

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    lateinit var PROXY: IProxy

    @JvmStatic
    @Mod.InstanceFactory
    fun createModInstance() = this

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    fun preinit(event: FMLPreInitializationEvent) {
        Logger.setLogger(event.modLog)
        Logger.info("Starting Preinitialization...")
        PROXY.preInit()

        MinecraftForge.EVENT_BUS.register(RegisterUtil())
        MinecraftForge.EVENT_BUS.register(WorldUtil())
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Logger.info("Starting Initialization...")
        PROXY.init()
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    fun postinit(event: FMLPostInitializationEvent) {
        Logger.info("Starting PostInitialization...")
        PROXY.postInit()
    }
}