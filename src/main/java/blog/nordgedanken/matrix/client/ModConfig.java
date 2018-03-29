package blog.nordgedanken.matrix.client;

import blog.nordgedanken.matrix.Call;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/** Client Configuration Settings  */
@Config(modid = Call.MOD_ID)
public class  ModConfig {
    @Config.Name("Sound")
    @Config.Comment("Sound Channel Configuration")
    public static final Sound sound = new Sound();


    public static class Sound {
        @Config.Name("Automatically configure sound channels")
        @Config.LangKey("config.matrix_call:autoConfigureChannels")
        @Config.RequiresWorldRestart
        public Boolean autoConfigureChannels = true;

        // TODO Replace with array of strings containing possible devices to use
        @Config.Name("Source (Headphone) Channel Name to use")
        @Config.LangKey("config.matrix_call:SourceNameToUse")
        public String SourceChannel = "";

        // TODO Replace with array of strings containing possible devices to use
        @Config.Name("Target (Microphone) Channel Name to use")
        @Config.LangKey("config.matrix_call:TargetNameToUse")
        public String  TargetChannel = "";
    }

    @Mod.EventBusSubscriber
    private static class RegistrationHandler {
        @SubscribeEvent
        public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
            //Logger.info("On ConfigChanged: %s", event.modID);
            if (event.getModID().equals(Call.MOD_ID)) {
                ConfigManager.sync(Call.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}