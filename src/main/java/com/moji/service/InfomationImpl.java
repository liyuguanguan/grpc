package com.moji.service;


import com.moji.helloworld.HelloResponse;
import helloworld.InformationGrpc;


/**
 * @Author: liyu.guan
 * @Date: 2019/2/13 下午2:34
 */
public class InfomationImpl extends InformationGrpc.InformationImplBase {

    @Override
    public void getInformation(com.moji.helloworld.HelloRequest request,
                               io.grpc.stub.StreamObserver<com.moji.helloworld.HelloResponse> responseObserver) {

//        HelloRequest helloRequest = HelloRequest.newBuilder().setAge(1).setzzzz
        HelloResponse helloResponse = HelloResponse.newBuilder().setMsg("姓名:"+request.getName()+" 年龄:"+request.getAge()+" 性别:"+(request.getSex()==1?"男":"女")).setCode(1).build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
