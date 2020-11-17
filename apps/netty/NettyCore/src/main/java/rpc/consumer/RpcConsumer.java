package rpc.consumer;

import rpc.api.IRpcHelloService;
import rpc.api.IRpcService;

public class RpcConsumer {

    public static void main(String[] args) {
        IRpcHelloService rpcHelloService = RpcProxy.create(IRpcHelloService.class);
        System.out.println(rpcHelloService.hello("Mi An"));

        IRpcService rpcService = RpcProxy.create(IRpcService.class);
        System.out.println(rpcService.add(1, 1));
        System.out.println(rpcService.sub(1, 1));
        System.out.println(rpcService.mul(1, 1));
        System.out.println(rpcService.div(1, 1));
    }

}
