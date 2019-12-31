package com.songshu.pressure.test.demo.plugin.context;

/**
 * @author 鼠笑天
 * @date 2019/12/27
 */
public class MarkContext {

    public static final String MARK = "_mark";

    public static InheritableThreadLocal<Boolean> PRESSUER_TEST_MARK = new InheritableThreadLocal<Boolean>();

}
