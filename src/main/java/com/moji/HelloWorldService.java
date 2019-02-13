package com.moji;

import com.moji.service.InfomationImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class HelloWorldService
{

    private int port = 10010;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port).addService(new InfomationImpl()).build().start();
        System.out.println("service start >>>>");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldService.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    // 等待主线程终止，因为GRPC库使用守护进程线程
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        final HelloWorldService app = new HelloWorldService();
        app.start();
        app.blockUntilShutdown();
        System.out.println( "Hello World!" );
    }
}
