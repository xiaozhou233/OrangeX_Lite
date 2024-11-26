package cn.xiaozhou233.OrangeX.agent;

import cn.xiaozhou233.OrangeX.OrangeX;

import java.lang.instrument.Instrumentation;
import java.util.jar.JarFile;


public class Agent {
    public static Instrumentation inst = null;
    private static String CorePath = "D:\\OrangeX\\Lite\\out\\Core.jar";
    public static void premain(String agentArgs, Instrumentation inst) {
        Agent.inst = inst;
        System.out.println("[OrangeX] Agent Loaded!");
        System.out.println("Run Method: premain");
        System.out.println("Inject Core to Vm");
        injectJar2Vm(CorePath);
        System.out.println("Inject Core to Vm Success");
        OrangeX orangeX = new OrangeX(inst);
        orangeX.inject();
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        Agent.inst = inst;
        System.out.println("[OrangeX] Agent Loaded!");
        System.out.println("Run Method: agentmain");
    }

    public static void injectJar2Vm(String jarPath) {
        if (inst == null) {
            throw new IllegalStateException("Instrumentation is not initialized. Ensure the agent is attached.");
        }

        try {
            JarFile jarFile = new JarFile(jarPath);
            inst.appendToSystemClassLoaderSearch(jarFile);
            System.out.println("Successfully injected JAR: " + jarPath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject JAR file: " + jarPath, e);
        }
    }
}