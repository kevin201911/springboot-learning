package com.mscloudmesh.client;


import com.mscloudmesh.lib.GreeterGrpc;
import com.mscloudmesh.lib.GreeterOuterClass;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("grpc-server")
    private Channel serverChannel;

    String sendMessage(String name) {
        GreeterGrpc.GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(serverChannel);
        GreeterOuterClass.HelloReply response = stub.sayHello(GreeterOuterClass.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();


    }
}

