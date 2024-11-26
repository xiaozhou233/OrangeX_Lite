package cn.xiaozhou233.OrangeX.Hooker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;


public class RenderHUD implements HookInterface {
    public static String targetClass = "net.minecraft.client.gui.GuiIngame";
    public static String targetMethod = "renderGameOverlay";

    public static void tick(){
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
            fontRenderer.drawStringWithShadow("OrangeX", 0, 0, 0xFFFFFF);
    }

    @Override
    public void init() {

    }

    @Override
    public String getTargetClass() {
        return targetClass;
    }

    @Override
    public String getTargetMethod() {
        return targetMethod;
    }
}
