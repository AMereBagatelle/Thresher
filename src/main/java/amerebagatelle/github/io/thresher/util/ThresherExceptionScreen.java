package amerebagatelle.github.io.thresher.util;

import amerebagatelle.github.io.thresher.Settings;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
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
        this.addButton(new ButtonWidget(this.width/2+10, this.height-25, 200, 20, "Continue", press -> {
            this.minecraft.openScreen(new ThresherExceptionConfirmationScreen(this));
        }));
        this.addButton(new ButtonWidget(this.width/2-210, this.height-25, 200, 20, "Quit Game", press -> {
            this.minecraft.scheduleStop();
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.exceptionWidget.render(mouseX, mouseY, delta);
        this.drawCenteredString(this.font, I18n.translate("exceptionscreen.top1"), this.width/2, 15, 16777215);
        this.drawCenteredString(this.font, I18n.translate("exceptionscreen.bottom1"), this.width/2, this.height-60, 16777215);
        this.drawCenteredString(this.font, I18n.translate("exceptionscreen.bottom2"), this.width/2, this.height-50, 16711680);
        this.drawCenteredString(this.font, I18n.translate("exceptionscreen.bottom3"), this.width/2, this.height-40, 16711680);
        super.render(mouseX, mouseY, delta);
    }
}
