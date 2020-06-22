package amerebagatelle.github.io.thresher;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.server.ServerStartCallback;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Environment(EnvType.CLIENT)
public class Thresher implements ClientModInitializer {
    public static final Checker checker = new Checker();

    @Override
    public void onInitializeClient() {
        Settings.initSettings();
    }
}
