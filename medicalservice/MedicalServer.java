//Add the class to the medicalservice package
package medicalservice;
//Add required import statements
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
import medicalservice.medicalGrpc.medicalImplBase;

//create MedicalServer class that extends the medicalImplBase class
public class MedicalServer extends medicalImplBase {
	//Create main method
	public static void main(String[] args) {
		//Create a new medicalServer object called test
		MedicalServer test = new MedicalServer();
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
		}//End try/catch
	}// End main method

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
		//begin try/catch to obtain the properties of the service & error handling
		try (InputStream input = new FileInputStream("src/main/resources/properties/medical.properties")) {
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
		//Return the properties object prop
		return prop;
	}

	//Create contactMed method
	public void contactMed(contactMedical request, StreamObserver<medicalResponse> responseObserver) {
		String tempStr = request.getText().toString();
		medicalResponse reply = medicalResponse.newBuilder().setValue("Server received emergency: "+tempStr).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	String name;
	String injury;
	String address;
	String priority;
	ArrayList<String> temp = new ArrayList<>();
	//Create emergencyDetail method
	public StreamObserver<medicalEmergency> emergencyDetail(StreamObserver<emergencyResponse> responseObserver) {
		//Return a new StreamObserver
		return new StreamObserver<medicalEmergency>() {
			//Create variable to store the inputed information
			//Create onNext method
			@Override
			public void onNext(medicalEmergency value) {
				temp.add(value.getText().toString());
				System.out.println(temp.size());
				if (temp.size() <= 4) {
					if (temp.size() == 1) {
						name = value.getText().toString();
					} else if (temp.size() == 2) {
						injury = value.getText().toString();
					} else if (temp.size() == 3) {
						address = value.getText().toString();
					} else if (temp.size() == 4) {
						priority = value.getText().toString();
						onCompleted();
					}
				} else {
					onCompleted();
				}
			}
			
			//Create onError method
			@Override
			public void onError(Throwable t) {}//End onError method
			//Create onCompleted method
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println(name + " " + injury + " " + address + " " + priority);
				emergencyResponse reply = emergencyResponse.newBuilder().setName(name).setInjury(injury)
						.setAddress(address).setPriority(priority).build();
				temp.clear();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
		};
	}
}
