package com.songshu.pressure.test.demo.plugin.dubbo;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

import com.songshu.pressure.test.demo.plugin.context.MarkContext;

/**
 * @author 鼠笑天
 * @date 2019/12/28
 */
@Activate
public class DubboConsumerContextFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Boolean mark = MarkContext.PRESSUER_TEST_MARK.get();
        if (mark != null) {
            Map<String, String> context = new HashMap<>();
            context.put(MarkContext.MARK, "true");
            RpcContext.getContext().setAttachments(context);
        }
        Result result = invoker.invoke(invocation);
        MarkContext.PRESSUER_TEST_MARK.set(null);
        return result;
    }

}