package amerebagatelle.github.io.thresher.util;

import amerebagatelle.github.io.thresher.Settings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

import java.util.ArrayList;

public class ThresherExceptionScreen extends Screen {
    public ArrayList<String> reasons;

    public ThresherExceptionScreen(ArrayList<String> reasons) {
        super(new LiteralText("ThresherExceptionScreen"));
        this.reasons = reasons;
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);
        this.addButton(new ButtonWidget(width/2, 100, 270, 100, "Override", press -> {
            Settings.writeSetting("thresherEnabled", "false");
            client.openScreen(new TitleScreen());
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        super.render(mouseX, mouseY, delta);
        this.renderBackground();
    }
}
