package cn.xiaozhou233.OrangeX.Hooker;

import cn.xiaozhou233.OrangeX.Manager.ClickGUI;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

public class KeyBind implements HookInterface{
    public static String targetClass = "net.minecraft.client.gui.GuiIngame";
    public static String targetMethod = "renderGameOverlay";

    private static HashMap<Integer, Method> keyMap = new HashMap<>();

    public void init() {
        // TODO: auto bind keys after complete system configuration
        try{
            keyMap.put(Keyboard.KEY_RSHIFT, ClickGUI.class.getMethod("renderClickGUI"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void tick() {
        if (Minecraft.getMinecraft().currentScreen == null) {
            keyMap.forEach((KeyboardKey, method) -> {
                if (Keyboard.isKeyDown(KeyboardKey)) {
                    try {
                        method.invoke(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
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
