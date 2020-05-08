package amerebagatelle.github.io.thresher.util;

import amerebagatelle.github.io.thresher.Settings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;

import java.util.ArrayList;

public class ThresherExceptionScreen extends Screen {
    public ThresherExceptionWidget exceptionWidget;
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
        exceptionWidget = new ThresherExceptionWidget(this.minecraft, this.width, this.height, 48, this.height-64, 32, reasons, this);
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        super.render(mouseX, mouseY, delta);
        this.renderBackground();
        this.exceptionWidget.render(mouseX, mouseY, delta);
        this.drawCenteredString(this.font, "Thresher Exeption Thrown!", this.width/2, 10, 16777215);
        this.drawCenteredString(this.font, "The exception was thrown for the following reasons:", this.width/2, 30, 16777215);
    }
}
