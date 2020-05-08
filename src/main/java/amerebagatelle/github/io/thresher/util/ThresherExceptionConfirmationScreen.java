package amerebagatelle.github.io.thresher.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class ThresherExceptionConfirmationScreen extends Screen {
    private Screen parent;

    public ThresherExceptionConfirmationScreen(Screen parent) {
        super(new LiteralText("ThresherConfirmationScreen"));
        this.parent = parent;
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);
        this.addButton(new ButtonWidget(this.width/2-100, this.height/2-30, 200, 20, "I Agree", press -> {
            this.minecraft.openScreen(new TitleScreen());
        }));
        this.addButton(new ButtonWidget(this.width/2-100, this.height/2, 200, 20, "Go back", press -> {
            this.minecraft.openScreen(parent);
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        this.drawCenteredString(this.font, "Do you really wish to ignore the warnings?", this.width/2, 20, 16777215);
        this.drawCenteredString(this.font, "DO NOT REPORT ISSUES YOU ENCOUNTER TO THE MODPACK AUTHOR(S) IF YOU DO THIS.", this.width/2, 40, 16711680);
        super.render(mouseX, mouseY, delta);
    }
}
