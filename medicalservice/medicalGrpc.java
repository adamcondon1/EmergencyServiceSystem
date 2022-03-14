package medicalservice;

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
    comments = "Source: medical.proto")
public final class medicalGrpc {

  private medicalGrpc() {}

  public static final String SERVICE_NAME = "medical.medical";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<medicalservice.contactMedical,
      medicalservice.medicalResponse> getContactMedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "contactMed",
      requestType = medicalservice.contactMedical.class,
      responseType = medicalservice.medicalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<medicalservice.contactMedical,
      medicalservice.medicalResponse> getContactMedMethod() {
    io.grpc.MethodDescriptor<medicalservice.contactMedical, medicalservice.medicalResponse> getContactMedMethod;
    if ((getContactMedMethod = medicalGrpc.getContactMedMethod) == null) {
      synchronized (medicalGrpc.class) {
        if ((getContactMedMethod = medicalGrpc.getContactMedMethod) == null) {
          medicalGrpc.getContactMedMethod = getContactMedMethod = 
              io.grpc.MethodDescriptor.<medicalservice.contactMedical, medicalservice.medicalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "medical.medical", "contactMed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  medicalservice.contactMedical.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  medicalservice.medicalResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new medicalMethodDescriptorSupplier("contactMed"))
                  .build();
          }
        }
     }
     return getContactMedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<medicalservice.medicalEmergency,
      medicalservice.emergencyResponse> getEmergencyDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "emergencyDetail",
      requestType = medicalservice.medicalEmergency.class,
      responseType = medicalservice.emergencyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<medicalservice.medicalEmergency,
      medicalservice.emergencyResponse> getEmergencyDetailMethod() {
    io.grpc.MethodDescriptor<medicalservice.medicalEmergency, medicalservice.emergencyResponse> getEmergencyDetailMethod;
    if ((getEmergencyDetailMethod = medicalGrpc.getEmergencyDetailMethod) == null) {
      synchronized (medicalGrpc.class) {
        if ((getEmergencyDetailMethod = medicalGrpc.getEmergencyDetailMethod) == null) {
          medicalGrpc.getEmergencyDetailMethod = getEmergencyDetailMethod = 
              io.grpc.MethodDescriptor.<medicalservice.medicalEmergency, medicalservice.emergencyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "medical.medical", "emergencyDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  medicalservice.medicalEmergency.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  medicalservice.emergencyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new medicalMethodDescriptorSupplier("emergencyDetail"))
                  .build();
          }
        }
     }
     return getEmergencyDetailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static medicalStub newStub(io.grpc.Channel channel) {
    return new medicalStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static medicalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new medicalBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static medicalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new medicalFutureStub(channel);
  }

  /**
   */
  public static abstract class medicalImplBase implements io.grpc.BindableService {

    /**
     */
    public void contactMed(medicalservice.contactMedical request,
        io.grpc.stub.StreamObserver<medicalservice.medicalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getContactMedMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<medicalservice.medicalEmergency> emergencyDetail(
        io.grpc.stub.StreamObserver<medicalservice.emergencyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getEmergencyDetailMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getContactMedMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                medicalservice.contactMedical,
                medicalservice.medicalResponse>(
                  this, METHODID_CONTACT_MED)))
          .addMethod(
            getEmergencyDetailMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                medicalservice.medicalEmergency,
                medicalservice.emergencyResponse>(
                  this, METHODID_EMERGENCY_DETAIL)))
          .build();
    }
  }

  /**
   */
  public static final class medicalStub extends io.grpc.stub.AbstractStub<medicalStub> {
    private medicalStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalStub(channel, callOptions);
    }

    /**
     */
    public void contactMed(medicalservice.contactMedical request,
        io.grpc.stub.StreamObserver<medicalservice.medicalResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getContactMedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<medicalservice.medicalEmergency> emergencyDetail(
        io.grpc.stub.StreamObserver<medicalservice.emergencyResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getEmergencyDetailMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class medicalBlockingStub extends io.grpc.stub.AbstractStub<medicalBlockingStub> {
    private medicalBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalBlockingStub(channel, callOptions);
    }

    /**
     */
    public medicalservice.medicalResponse contactMed(medicalservice.contactMedical request) {
      return blockingUnaryCall(
          getChannel(), getContactMedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class medicalFutureStub extends io.grpc.stub.AbstractStub<medicalFutureStub> {
    private medicalFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private medicalFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected medicalFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new medicalFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<medicalservice.medicalResponse> contactMed(
        medicalservice.contactMedical request) {
      return futureUnaryCall(
          getChannel().newCall(getContactMedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTACT_MED = 0;
  private static final int METHODID_EMERGENCY_DETAIL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final medicalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(medicalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTACT_MED:
          serviceImpl.contactMed((medicalservice.contactMedical) request,
              (io.grpc.stub.StreamObserver<medicalservice.medicalResponse>) responseObserver);
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
        case METHODID_EMERGENCY_DETAIL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.emergencyDetail(
              (io.grpc.stub.StreamObserver<medicalservice.emergencyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class medicalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    medicalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return medicalservice.medical2ServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("medical");
    }
  }

  private static final class medicalFileDescriptorSupplier
      extends medicalBaseDescriptorSupplier {
    medicalFileDescriptorSupplier() {}
  }

  private static final class medicalMethodDescriptorSupplier
      extends medicalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    medicalMethodDescriptorSupplier(String methodName) {
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
      synchronized (medicalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new medicalFileDescriptorSupplier())
              .addMethod(getContactMedMethod())
              .addMethod(getEmergencyDetailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
