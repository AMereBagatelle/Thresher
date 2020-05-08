package amerebagatelle.github.io.thresher.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.EntryListWidget;

import java.util.ArrayList;

public class ThresherExceptionWidget extends EntryListWidget<ThresherExceptionWidget.Entry> {
    private ArrayList<String> reasons;

    public ThresherExceptionWidget(MinecraftClient client, int width, int height, int top, int bottom, int itemHeight, ArrayList<String> reasons, ThresherExceptionScreen screen) {
        super(client, width, height, top, bottom, itemHeight);
        this.reasons = reasons;
        reasons.forEach(reason -> this.addEntry(new ThresherExceptionWidget.ExceptionEntry(screen, reason)));
    }

    public class ExceptionEntry extends ThresherExceptionWidget.Entry {
        public ThresherExceptionScreen screen;
        public String reason;

        public ExceptionEntry(ThresherExceptionScreen screen, String reason) {
            this.screen = screen;
            this.reason = reason;
        }

        @Override
        public void render(int index, int y, int x, int width, int height, int mouseX, int mouseY, boolean hovering, float delta) {
            ThresherExceptionWidget.this.drawCenteredString(ThresherExceptionWidget.this.minecraft.textRenderer, reason, x+width/2, y, 16777215);
        }
    }

    public abstract static class Entry extends EntryListWidget.Entry<ThresherExceptionWidget.Entry> {
    }
}
