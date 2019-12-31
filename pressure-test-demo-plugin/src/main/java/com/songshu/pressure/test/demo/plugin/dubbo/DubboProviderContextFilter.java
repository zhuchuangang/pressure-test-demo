package com.songshu.pressure.test.demo.plugin.dubbo;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.util.StringUtils;

import com.songshu.pressure.test.demo.plugin.context.MarkContext;

/**
 * @author 鼠笑天
 * @date 2019/12/28
 */
@Activate
public class DubboProviderContextFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // 处理压测标示
        String mark = RpcContext.getContext().getAttachment(MarkContext.MARK);
        if (!StringUtils.isEmpty(mark)) {
            MarkContext.PRESSUER_TEST_MARK.set(true);
        }
        Result result = invoker.invoke(invocation);
        MarkContext.PRESSUER_TEST_MARK.set(null);
        return result;
    }

}