/*
@author adamc x18392911 Emergency Service
 */
package gardaservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: police.proto")
public final class policeGrpc {

  private policeGrpc() {}

  public static final String SERVICE_NAME = "police.police";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gardaservice.contactPDRequest,
      gardaservice.PDResponse> getContactPDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "contactPD",
      requestType = gardaservice.contactPDRequest.class,
      responseType = gardaservice.PDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gardaservice.contactPDRequest,
      gardaservice.PDResponse> getContactPDMethod() {
    io.grpc.MethodDescriptor<gardaservice.contactPDRequest, gardaservice.PDResponse> getContactPDMethod;
    if ((getContactPDMethod = policeGrpc.getContactPDMethod) == null) {
      synchronized (policeGrpc.class) {
        if ((getContactPDMethod = policeGrpc.getContactPDMethod) == null) {
          policeGrpc.getContactPDMethod = getContactPDMethod = 
              io.grpc.MethodDescriptor.<gardaservice.contactPDRequest, gardaservice.PDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "police.police", "contactPD"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(gardaservice.contactPDRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(gardaservice.PDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new policeMethodDescriptorSupplier("contactPD"))
                  .build();
          }
        }
     }
     return getContactPDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gardaservice.PDEmergency,
      gardaservice.emergencyPDResponse> getEmergencyPDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "emergencyPD",
      requestType = gardaservice.PDEmergency.class,
      responseType = gardaservice.emergencyPDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<gardaservice.PDEmergency,
      gardaservice.emergencyPDResponse> getEmergencyPDMethod() {
    io.grpc.MethodDescriptor<gardaservice.PDEmergency, gardaservice.emergencyPDResponse> getEmergencyPDMethod;
    if ((getEmergencyPDMethod = policeGrpc.getEmergencyPDMethod) == null) {
      synchronized (policeGrpc.class) {
        if ((getEmergencyPDMethod = policeGrpc.getEmergencyPDMethod) == null) {
          policeGrpc.getEmergencyPDMethod = getEmergencyPDMethod = 
              io.grpc.MethodDescriptor.<gardaservice.PDEmergency, gardaservice.emergencyPDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "police.police", "emergencyPD"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(gardaservice.PDEmergency.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(gardaservice.emergencyPDResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new policeMethodDescriptorSupplier("emergencyPD"))
                  .build();
          }
        }
     }
     return getEmergencyPDMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static policeStub newStub(io.grpc.Channel channel) {
    return new policeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static policeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new policeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static policeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new policeFutureStub(channel);
  }

  /**
   */
  public static abstract class policeImplBase implements io.grpc.BindableService {

    /**
     */
    public void contactPD(gardaservice.contactPDRequest request,
        io.grpc.stub.StreamObserver<gardaservice.PDResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContactPDMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<gardaservice.PDEmergency> emergencyPD(
        io.grpc.stub.StreamObserver<gardaservice.emergencyPDResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getEmergencyPDMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(getContactPDMethod(),
            asyncUnaryCall(new MethodHandlers<
                gardaservice.contactPDRequest,
                gardaservice.PDResponse>(
                  this, METHODID_CONTACT_PD)))
          .addMethod(getEmergencyPDMethod(),
            asyncBidiStreamingCall(new MethodHandlers<
                gardaservice.PDEmergency,
                gardaservice.emergencyPDResponse>(
                  this, METHODID_EMERGENCY_PD)))
          .build();
    }
  }

  /**
   */
  public static final class policeStub extends io.grpc.stub.AbstractStub<policeStub> {
    private policeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private policeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected policeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new policeStub(channel, callOptions);
    }

    /**
     */
    public void contactPD(gardaservice.contactPDRequest request,
        io.grpc.stub.StreamObserver<gardaservice.PDResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContactPDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<gardaservice.PDEmergency> emergencyPD(
        io.grpc.stub.StreamObserver<gardaservice.emergencyPDResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getEmergencyPDMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class policeBlockingStub extends io.grpc.stub.AbstractStub<policeBlockingStub> {
    private policeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private policeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected policeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new policeBlockingStub(channel, callOptions);
    }

    /**
     */
    public gardaservice.PDResponse contactPD(gardaservice.contactPDRequest request) {
      return blockingUnaryCall(
          getChannel(), getContactPDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class policeFutureStub extends io.grpc.stub.AbstractStub<policeFutureStub> {
    private policeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private policeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected policeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new policeFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gardaservice.PDResponse> contactPD(
        gardaservice.contactPDRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getContactPDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTACT_PD = 0;
  private static final int METHODID_EMERGENCY_PD = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final policeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(policeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTACT_PD:
          serviceImpl.contactPD((gardaservice.contactPDRequest) request,
              (io.grpc.stub.StreamObserver<gardaservice.PDResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMERGENCY_PD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.emergencyPD((io.grpc.stub.StreamObserver<gardaservice.emergencyPDResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class policeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    policeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gardaservice.police2ServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("police");
    }
  }

  private static final class policeFileDescriptorSupplier
      extends policeBaseDescriptorSupplier {
    policeFileDescriptorSupplier() {}
  }

  private static final class policeMethodDescriptorSupplier
      extends policeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    policeMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (policeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new policeFileDescriptorSupplier())
              .addMethod(getContactPDMethod())
              .addMethod(getEmergencyPDMethod())
              .build();
        }
      }
    }
    return result;
  }
}
