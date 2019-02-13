package helloworld;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: Helloworld.proto")
public final class InformationGrpc {

  private InformationGrpc() {}

  public static final String SERVICE_NAME = "Information";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.moji.helloworld.HelloRequest,
      com.moji.helloworld.HelloResponse> getGetInformationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInformation",
      requestType = com.moji.helloworld.HelloRequest.class,
      responseType = com.moji.helloworld.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.moji.helloworld.HelloRequest,
      com.moji.helloworld.HelloResponse> getGetInformationMethod() {
    io.grpc.MethodDescriptor<com.moji.helloworld.HelloRequest, com.moji.helloworld.HelloResponse> getGetInformationMethod;
    if ((getGetInformationMethod = InformationGrpc.getGetInformationMethod) == null) {
      synchronized (InformationGrpc.class) {
        if ((getGetInformationMethod = InformationGrpc.getGetInformationMethod) == null) {
          InformationGrpc.getGetInformationMethod = getGetInformationMethod =
              io.grpc.MethodDescriptor.<com.moji.helloworld.HelloRequest, com.moji.helloworld.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Information", "GetInformation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moji.helloworld.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moji.helloworld.HelloResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new InformationMethodDescriptorSupplier("GetInformation"))
                  .build();
          }
        }
     }
     return getGetInformationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InformationStub newStub(io.grpc.Channel channel) {
    return new InformationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InformationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InformationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InformationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InformationFutureStub(channel);
  }

  /**
   */
  public static abstract class InformationImplBase implements io.grpc.BindableService {

    /**
     */
    public void getInformation(com.moji.helloworld.HelloRequest request,
        io.grpc.stub.StreamObserver<com.moji.helloworld.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInformationMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetInformationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.moji.helloworld.HelloRequest,
                com.moji.helloworld.HelloResponse>(
                  this, METHODID_GET_INFORMATION)))
          .build();
    }
  }

  /**
   */
  public static final class InformationStub extends io.grpc.stub.AbstractStub<InformationStub> {
    private InformationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected InformationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationStub(channel, callOptions);
    }

    /**
     */
    public void getInformation(com.moji.helloworld.HelloRequest request,
        io.grpc.stub.StreamObserver<com.moji.helloworld.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInformationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InformationBlockingStub extends io.grpc.stub.AbstractStub<InformationBlockingStub> {
    private InformationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected InformationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.moji.helloworld.HelloResponse getInformation(com.moji.helloworld.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInformationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InformationFutureStub extends io.grpc.stub.AbstractStub<InformationFutureStub> {
    private InformationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InformationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected InformationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InformationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moji.helloworld.HelloResponse> getInformation(
        com.moji.helloworld.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInformationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_INFORMATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InformationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InformationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_INFORMATION:
          serviceImpl.getInformation((com.moji.helloworld.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.moji.helloworld.HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InformationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InformationBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.moji.helloworld.HelloWorldProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Information");
    }
  }

  private static final class InformationFileDescriptorSupplier
      extends InformationBaseDescriptorSupplier {
    InformationFileDescriptorSupplier() {}
  }

  private static final class InformationMethodDescriptorSupplier
      extends InformationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InformationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InformationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InformationFileDescriptorSupplier())
              .addMethod(getGetInformationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
