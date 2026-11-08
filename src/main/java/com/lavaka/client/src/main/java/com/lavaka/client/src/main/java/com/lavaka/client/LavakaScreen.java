
package com.lavaka.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import java.awt.Color;

public class LavakaScreen extends Screen {

    public LavakaScreen() {
        super(Text.literal("Lavaka Client"));
    }

    private int gradient(float offset) {
        float time = (System.currentTimeMillis() % 6000L) / 6000f;
        return Color.HSBtoRGB((time + offset) % 1f, 0.7f, 1f);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX,
                       int mouseY, float delta) {

        fill(matrices, 0, 0, width, height, 0xDD080812);

        int x = width / 2 - 110;
        int y = height / 2 - 70;

        fill(matrices, x, y, x + 220, y + 150, 0xFF151521);

        fill(matrices, x, y, x + 220, y + 3,
             gradient(0.2f));

        drawCenteredText(
            matrices,
            textRenderer,
            "LAVAKA CLIENT",
            width / 2,
            y + 30,
            gradient(0.3f)
        );

        drawCenteredText(
            matrices,
            textRenderer,
            "WELCOME BACK",
            width / 2,
            y + 55,
            0xFFFFFFFF
        );

        int bx = width / 2 - 65;
        int by = y + 90;

        boolean hovered =
            mouseX >= bx && mouseX <= bx + 130 &&
            mouseY >= by && mouseY <= by + 35;

        fill(
            matrices,
            bx, by,
            bx + 130, by + 35,
            hovered ? gradient(0.4f) : 0xFF292938
        );

        drawCenteredText(
            matrices,
            textRenderer,
            "START",
            width / 2,
            by + 13,
            0xFFFFFFFF
        );

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY,
                                int button) {
        if (button == 0) {
            int x = width / 2 - 65;
            int y = height / 2 + 20;

            if (mouseX >= x && mouseX <= x + 130 &&
                mouseY >= y && mouseY <= y + 35) {

                MinecraftClient.getInstance().setScreen(
                    new LavakaMainScreen()
                );

                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
