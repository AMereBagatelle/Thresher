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
        exceptionWidget = new ThresherExceptionWidget(this.minecraft, this.width, this.height, 40, this.height-70, 128, reasons, this);
        this.addButton(new ButtonWidget(this.width/2-100, this.height-25, 200, 20, "Continue", press -> {
            this.minecraft.openScreen(new ThresherExceptionConfirmationScreen(this));
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.exceptionWidget.render(mouseX, mouseY, delta);
        this.drawCenteredString(this.font, "Your computer/settings do not meet the recommended specifications!", this.width/2, 15, 16777215);
        this.drawCenteredString(this.font, "Click the button below to skip these warnings.", this.width/2, this.height-65, 16777215);
        this.drawCenteredString(this.font, "THIS IS NOT RECOMMENDED.", this.width/2, this.height-55, 16711680);
        this.drawCenteredString(this.font, "DO NOT REPORT ISSUES YOU ENCOUNTER TO THE MODPACK AUTHOR(S) IF YOU DO THIS.", this.width/2, this.height-45, 16711680);
        super.render(mouseX, mouseY, delta);
    }
}
