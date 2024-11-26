package cn.xiaozhou233.OrangeX.Hooker;

public interface HookInterface {
    public static String targetClass = "";
    public static String targetMethod = "";

    public void init();
    public String getTargetClass();
    public String getTargetMethod();
}
