// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: medical.proto

package medicalservice;

public final class medical2ServiceImpl {
  private medical2ServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_medical_contactMedical_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_medical_contactMedical_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_medical_medicalResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_medical_medicalResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_medical_medicalEmergency_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_medical_medicalEmergency_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_medical_emergencyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_medical_emergencyResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmedical.proto\022\007medical\"\036\n\016contactMedic" +
      "al\022\014\n\004text\030\001 \001(\t\" \n\017medicalResponse\022\r\n\005v" +
      "alue\030\001 \001(\t\" \n\020medicalEmergency\022\014\n\004text\030\001" +
      " \001(\t\"T\n\021emergencyResponse\022\014\n\004name\030\001 \001(\t\022" +
      "\016\n\006injury\030\002 \001(\t\022\017\n\007address\030\003 \001(\t\022\020\n\010prio" +
      "rity\030\004 \001(\t2\226\001\n\007medical\022?\n\ncontactMed\022\027.m" +
      "edical.contactMedical\032\030.medical.medicalR" +
      "esponse\022J\n\017emergencyDetail\022\031.medical.med" +
      "icalEmergency\032\032.medical.emergencyRespons" +
      "e(\001B\'\n\016medicalserviceB\023medical2ServiceIm" +
      "plP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_medical_contactMedical_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_medical_contactMedical_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_medical_contactMedical_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_medical_medicalResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_medical_medicalResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_medical_medicalResponse_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_medical_medicalEmergency_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_medical_medicalEmergency_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_medical_medicalEmergency_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_medical_emergencyResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_medical_emergencyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_medical_emergencyResponse_descriptor,
        new java.lang.String[] { "Name", "Injury", "Address", "Priority", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
