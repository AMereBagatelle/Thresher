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
        this.addButton(new ButtonWidget(this.width/2, this.height-15, 200, 20, "Turn off, I have been warned.", press -> {
            Settings.writeSetting("thresherEnabled", "false");
            this.minecraft.openScreen(new TitleScreen());
        }));
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);
        exceptionWidget = new ThresherExceptionWidget(this.minecraft, this.width, this.height, 48, this.height-64, 32, reasons, this);
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.exceptionWidget.render(mouseX, mouseY, delta);
        this.drawCenteredString(this.font, "Your computer/settings do not meet the minimum specs!", this.width/2, 10, 16777215);
        this.drawCenteredString(this.font, "The exception was thrown for the following reasons:", this.width/2, 30, 16777215);
        this.drawCenteredString(this.font, "Please fix these things if possible.", this.width/2, this.height-60, 16777215);
        this.drawCenteredString(this.font, "DO NOT DO THIS UNLESS YOU CANNOT FIX THE ISSUE", this.width/2, this.height-40, 16777215);
        this.drawCenteredString(this.font, "Alternatively, disable this mod in its config file.", this.width/2, this.height-30, 16777215);
        this.drawCenteredString(this.font, "Config File Name: thresher.properties", this.width/2, this.height-20, 16777215);
        super.render(mouseX, mouseY, delta);
    }
}
