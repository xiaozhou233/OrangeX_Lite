package cn.xiaozhou233.OrangeX.Hooker;

import cn.xiaozhou233.JuiceMixin.Transformer;

import java.util.ArrayList;
import java.util.List;

public class Hooker {
    private static List<HookInterface> hooks = new ArrayList<>();

    public Hooker() {
        // TODO: Auto add Hooks
        hooks.add(new RenderHUD());
        hooks.add(new KeyBind());
    }

    public void start() {
        hooks.forEach(hook -> {
            try {
                System.out.println("Transforming " + hook.getTargetClass() + "." + hook.getTargetMethod() + "");

                hook.init();

                Transformer.HookClass(
                        hook.getClass(),
                        hook.getTargetClass(),
                        hook.getTargetMethod()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
