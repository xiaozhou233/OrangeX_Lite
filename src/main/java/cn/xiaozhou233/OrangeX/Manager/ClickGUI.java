package cn.xiaozhou233.OrangeX.Manager;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends GuiScreen {

    public static void renderClickGUI() {
        Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());
    }

    @Override
    public void initGui() {
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        // 获取屏幕中心的X和Y坐标
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        // 设置文本颜色
        this.drawString(Minecraft.getMinecraft().fontRendererObj, "ClickGUI尚未完善",
                centerX,
                centerY,
                0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
