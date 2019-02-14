package com.moji;

import com.moji.helloworld.HelloRequest;
import com.moji.helloworld.HelloResponse;
import helloworld.InformationGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Author: liyu.guan
 * @Date: 2019/2/13 下午3:50
 */
public class HelloWorldClient {
    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());

    private final ManagedChannel managedChannel;

    private final InformationGrpc.InformationBlockingStub blockingStub;

    public HelloWorldClient(ManagedChannel managedChannel) {
        this.managedChannel = managedChannel;
        blockingStub = InformationGrpc.newBlockingStub(managedChannel);
    }

//    public void Connection(String host, int port){
//        ManagedChannelBuilder.forAddress(host,port).usePlaintext().build();
//    }

    public HelloWorldClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    public void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
    }

    public void start(String name,int age,int sex){
//        logger.info("Will try to greet " + name + " ...");
        HelloRequest helloRequest = HelloRequest.newBuilder().setAge(age).setName(name).setSex(sex).build();
        //调用方法
        HelloResponse helloResponse = blockingStub.getInformation(helloRequest);
//        logger.info(helloResponse.getMsg());
    }

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClient helloWorldClient = new HelloWorldClient("localhost", 10010);
        try {

            int max = 100000;
            Long start = System.currentTimeMillis();
            for (int i = 0; i < max; i++) {
                helloWorldClient.start("小红",18,1);
            }
            Long end = System.currentTimeMillis();
            Long elapse = end - start;
            int perform = Double.valueOf(max / (elapse / 1000d)).intValue();
            System.out.print("rgpc " + max + " 次NettyServer调用，耗时：" + elapse + "毫秒，平均" + perform + "次/秒");

        } finally {
            helloWorldClient.shutdown();
        }

    }

}
