
package com.lavaka.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import java.awt.Color;

public class LavakaMainScreen extends Screen {

    public LavakaMainScreen() {
        super(Text.literal("Lavaka Main"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX,
                       int mouseY, float delta) {

        fill(matrices, 0, 0, width, height, 0xEE080810);

        int x = width / 2 - 180;
        int y = height / 2 - 110;

        fill(matrices, x, y, x + 360, y + 220, 0xFF151521);

        float time = (System.currentTimeMillis() % 6000L) / 6000f;
        int color = Color.HSBtoRGB(time, 0.8f, 1f);

        fill(matrices, x, y, x + 360, y + 3, color);

        drawCenteredText(
            matrices,
            textRenderer,
            "LAVAKA CLIENT",
            width / 2,
            y + 25,
            color
        );

        drawCenteredText(
            matrices,
            textRenderer,
            "Welcome to your client!",
            width / 2,
            y + 75,
            0xFFFFFFFF
        );

        drawCenteredText(
            matrices,
            textRenderer,
            "GUI VERSION 1.0",
            width / 2,
            y + 100,
            0xFF999999
        );

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
