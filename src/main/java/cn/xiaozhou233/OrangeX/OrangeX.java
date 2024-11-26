package cn.xiaozhou233.OrangeX;

import cn.xiaozhou233.JuiceMixin.JuiceMixin;
import cn.xiaozhou233.OrangeX.Hooker.Hooker;

import java.lang.instrument.Instrumentation;

public class OrangeX {
    private static Instrumentation inst = null;
    private static JuiceMixin juiceMixin = null;
    public OrangeX(Instrumentation jvmInst){
        inst = jvmInst;
        System.out.println("Set jvmInst!");
        juiceMixin = new JuiceMixin(inst);
    }

    public void inject(){
        // Hook Class
        Hooker hooker = new Hooker();
        hooker.start();

        // set hook, start transform
        juiceMixin.run();

        System.out.println("Injected!");
    }



    public static Instrumentation getInst(){
        return inst;
    }

    public static JuiceMixin getJuiceMixin() {
        return juiceMixin;
    }
}