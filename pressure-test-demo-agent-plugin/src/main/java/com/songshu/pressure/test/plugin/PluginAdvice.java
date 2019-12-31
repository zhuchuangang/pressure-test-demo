package com.songshu.pressure.test.plugin;

import java.lang.reflect.Field;
import net.bytebuddy.asm.Advice;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
public class PluginAdvice {
    @Advice.OnMethodEnter()
    public static void enter(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName,
        @Advice.AllArguments Object[] allArguments) {
        System.out.println("enter链路追踪：" + className + "." + methodName);
        for (Object o : allArguments) {
            System.out.println(o);
            if (o.getClass().toString().contains("UserDTO")){
                try {
                    Field field = o.getClass().getDeclaredField("name");
                    field.setAccessible(true);
                    field.set(o, "张三");
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }

    }

    @Advice.OnMethodExit()
    public static void exit(@Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) {
        System.out.println("exit链路追踪：" + className + "." + methodName);
    }
}
