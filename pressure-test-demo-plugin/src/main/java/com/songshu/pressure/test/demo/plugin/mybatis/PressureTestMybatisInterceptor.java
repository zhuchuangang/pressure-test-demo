package com.songshu.pressure.test.demo.plugin.mybatis;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.songshu.pressure.test.demo.plugin.context.MarkContext;

/**
 * @author 鼠笑天
 * @date 2019/12/26
 */
/**
 * @Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
 */
@Intercepts({@Signature(type = StatementHandler.class, // 对象类型，只能是四大对象类型
    method = "prepare", // 拦截方法
    args = {Connection.class, Integer.class/*方法中用到的参数类型*/})}) // 可以点击拦截对象查看拦截方法的参数，
public class PressureTestMybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        // 获取目标对象
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        // 获取要执行的sql命令
        String sql = statementHandler.getBoundSql().getSql();
        // 为sql语句添加分页
        Object mark = MarkContext.PRESSUER_TEST_MARK.get();

        if (mark != null) {
            sql = sql.replace("t_user", "t_user_test");
        }
        System.out.println("要执行的sql命令为：" + sql);
        // 元数据对象，可以对原始数据进行操作
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        // 重新绑定修改后的sql语句
        metaObject.setValue("boundSql.sql", sql);
        // 执行目标方法
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return target instanceof StatementHandler ? Plugin.wrap(target, this) : target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
