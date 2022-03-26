#add required inputs for the client application
import logging
import grpc
import rescue_pb2_grpc
import rescue_pb2
#Create new function for sending a request to the first service on the server
def contact():
    with grpc.insecure_channel('localhost:50052') as channel:
        stub = rescue_pb2_grpc.rescueStub(channel)
        response = stub.contactRescue(rescue_pb2.contactRescueRequest(text = 'Rescue emergency service required'))
    print("Server responded: "+response.value)
    
#Create new function to send a request to the second service
def emergency():
    with grpc.insecure_channel('localhost:50052') as channel:
        stub = rescue_pb2_grpc.rescueStub(channel)
        response = stub.emergencyRescue(rescue_pb2.rescueEmergency(name = 'Adam', injury = 'Broken Foot', address = '14 crescent', priority = 'Low'))
        for resp in response:
            print('Server responded: %s' %resp)
#Main method calls the other two functions
if __name__ == "__main__":
    logging.basicConfig()
    contact()
    emergency()