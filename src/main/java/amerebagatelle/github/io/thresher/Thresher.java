package amerebagatelle.github.io.thresher;

import net.fabricmc.api.ModInitializer;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Thresher implements ModInitializer {
    public static final Checker checker = new Checker();

    @Override
    public void onInitialize() {
        Settings.initSettings();
    }
}
