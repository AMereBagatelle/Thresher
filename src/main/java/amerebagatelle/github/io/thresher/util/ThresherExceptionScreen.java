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
    public ArrayList<String[]> reasons;

    public ThresherExceptionScreen(ArrayList<String[]> reasons) {
        super(new LiteralText("ThresherExceptionScreen"));
        this.reasons = reasons;
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);
        exceptionWidget = new ThresherExceptionWidget(this.minecraft, this.width, this.height, 40, this.height-64, 128, reasons, this);
        // TODO: add a override button with a confirm screen behind it
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.exceptionWidget.render(mouseX, mouseY, delta);
        this.drawCenteredString(this.font, "Your computer/settings do not meet the recommended specifications!", this.width/2, 15, 16777215);
        // TODO: Replace the rendered lines with the below comments in red
        // Alternatively, disable Thresher in config/thresher.properties to proceed without the recommended specs.
        // THIS IS NOT RECOMMENDED. DO NOT REPORT ISSUES YOU ENCOUNTER TO THE MODPACK AUTHOR(S) IF YOU DO THIS.
        this.drawCenteredString(this.font, "DO NOT DO THIS UNLESS YOU CANNOT FIX THE ISSUE", this.width/2, this.height-35, 16777215);
        this.drawCenteredString(this.font, "Alternatively, disable this mod in its config file.", this.width/2, this.height-25, 16777215);
        this.drawCenteredString(this.font, "Config File Name: thresher.properties", this.width/2, this.height-15, 16777215);
        super.render(mouseX, mouseY, delta);
    }
}
