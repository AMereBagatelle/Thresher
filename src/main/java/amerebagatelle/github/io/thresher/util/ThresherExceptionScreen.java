package amerebagatelle.github.io.thresher.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ThresherExceptionScreen extends Screen {
    public ThresherExceptionScreen() {
        super(new LiteralText("ThresherExceptionScreen"));
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);
    }
}
