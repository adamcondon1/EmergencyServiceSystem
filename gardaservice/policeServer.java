/*
@author adamc x18392911 Emergency Service
 */
//Add the class to the policeservice package
package gardaservice;
//imports
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import gardaservice.policeGrpc.policeImplBase;

//create policeServer class that extends the medicalImplBase class
public class policeServer extends policeImplBase {
	//Create main method
	public static void main(String[] args) {
		//Create a new policeServer object called test
		policeServer test = new policeServer();
		//Create a properties object called prop
		Properties prop = test.getProperties();
		//use the registerService method to allow the service to be discovered
		test.registerService(prop);
		//Create an int variable that holds the port of the service from the properties file
		int port = Integer.valueOf(prop.getProperty("service_port"));
		//Try/catch to start the servers services
		try {
			Server server = ServerBuilder.forPort(port).addService(test).build().start();
			System.out.println("Server started, awaiting RPC calls...");
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Create registerService method
	private void registerService(Properties prop) {
		//Begin try/catch to register the service using the properties from the properties file
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			String service_type = prop.getProperty("service_type");
			String service_name = prop.getProperty("service_name");
			String service_description_properties = prop.getProperty("service_description");
			int service_port = Integer.valueOf(prop.getProperty("service_port"));
			//Registering the service via JmDNS
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
					service_description_properties);
			jmdns.registerService(serviceInfo);
			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
			Thread.sleep(1000);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        }

	//Begin the getProperties method 
	private Properties getProperties() {
		//Create a new empty properties object
		Properties prop = null;
		//Begin try/catch to obtain the properties of the service
		try (InputStream input = new FileInputStream("src/main/resources/properties/police.properties")) {
			prop = new Properties();
			prop.load(input);
			System.out.println("Service properties...");
			System.out.println("\t service_description: " + prop.getProperty("service_description"));
			System.out.println("\t service_type: " + prop.getProperty("service_type"));
			System.out.println("\t service_name: " + prop.getProperty("service_name"));
			System.out.println("\t service_port: " + prop.getProperty("service_port"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	//Create contactPD method
	public void contactPD(contactPDRequest request,StreamObserver<PDResponse> responseObserver) {
		String newStr = request.getText().toString();
		PDResponse reply = PDResponse.newBuilder().setValue("Server received emergency: "+newStr).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}

	//Create emergencyPD method
	public StreamObserver<PDEmergency> emergencyPD(StreamObserver<emergencyPDResponse> responseObserver) {
		//Return a new StreamObserver
		return new StreamObserver<PDEmergency>() {
			//Create onNext method
			@Override
			public void onNext(PDEmergency value) {
				// TODO Auto-generated method stub
				emergencyPDResponse reply = emergencyPDResponse.newBuilder().setName(value.getName()).setSituation(value.getSituation()).setAddress(value.getAddress()).setPriority(value.getPriority()).build();
				responseObserver.onNext(reply);
			}
			//Create onError method
			@Override
			public void onError(Throwable t) {
			}
			//Create onCompleted method
			@Override
			public void onCompleted() {
			}
		};
	}
}