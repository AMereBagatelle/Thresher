package amerebagatelle.github.io.thresher.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.EntryListWidget;

import java.util.ArrayList;

public class ThresherExceptionWidget extends EntryListWidget<ThresherExceptionWidget.Entry> {
    private ArrayList<String[]> reasons;

    public ThresherExceptionWidget(MinecraftClient client, int width, int height, int top, int bottom, int itemHeight, ArrayList<String[]> reasons, ThresherExceptionScreen screen) {
        super(client, width, height, top, bottom, itemHeight);
        this.reasons = reasons;
        reasons.forEach(reason -> this.addEntry(new ThresherExceptionWidget.ExceptionEntry(screen, reason)));
    }

    @Override
    public int getRowWidth() {
        return this.width-10;
    }

    public class ExceptionEntry extends ThresherExceptionWidget.Entry {
        public ThresherExceptionScreen screen;
        public String[] reason;

        public ExceptionEntry(ThresherExceptionScreen screen, String[] reason) {
            this.screen = screen;
            this.reason = reason;
        }

        @Override
        public void render(int index, int y, int x, int width, int height, int mouseX, int mouseY, boolean hovering, float delta) {
            int i = 0;
            for (String string : reason) {
                ThresherExceptionWidget.this.minecraft.textRenderer.draw(string, x+5, y+i, 16777215);
                i += 10;
            }
        }
    }

    public abstract static class Entry extends EntryListWidget.Entry<ThresherExceptionWidget.Entry> {
    }
}
