#add required imports
from concurrent import futures
from zeroconf import IPVersion, ServiceInfo, Zeroconf

import logging
import grpc
import rescue_pb2
import rescue_pb2_grpc
import socket
import queue
import jpysocket

#create the rescue class
class rescue (rescue_pb2_grpc.rescueServicer):
    #create empty array called temp
    temp = []
    #create contactRescue function
    def contactRescue(self, request, context):
        temp = request.text
        return Rescue_pb2.rescueResponse(value="Received -%s"%temp+"- from client")
    #Create emergencyRescue function
    def emergencyRescue(self, request, context):
        self.temp
        temp = request.name
        temp1 = request.injury
        temp2 = request.address
        temp3 = request.priority
        self.temp.append(temp)
        for t in self.temp:
            yield rescue_pb2.rescueResponseStream(text="Received name - %s"%temp+" Received injury - %s"%temp1+" Received address - %s"%temp2+" Received priority - %s"%temp3)

         
#create serve function  to start the server 
def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    rescue_pb2_grpc.add_rescueServicer_to_server(rescue(), server)
    server.add_insecure_port('[::]:50054')
    server.start()
    print('Server started...')
    server.wait_for_termination()

#create register function to register the server using the properties
def register():
    global zeroconf
    desc = {'path': 'rescue.properties'}
    
    info = ServiceInfo(
        "_http._tcp.local.",
        "rescue._http._tcp.local.",
        addresses=[socket.inet_aton("127.0.0.1")],
        port=50054,
        properties=desc,
        server="rescue.local.",
    )
    zeroconf = Zeroconf()
    zeroconf.register_service(info)
    print('registered...')

#create getProp function to get the properties of the server
def getProp():
    configs = Properties()
    with open('rescue.properties', 'rb') as config_file:
        configs.load(config_file)
    print('Service properties')
    print(configs.get("service_type"))
    print(configs.get("service_name"))
    print(configs.get("service_description"))
    print(configs.get("service_port"))

#Main method use to call the other functions on the python script
if __name__ == "__main__":
    logging.basicConfig()
    getProp()
    register()
    serve()
