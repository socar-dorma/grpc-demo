package kr.socar.demo.rpc.server

import io.grpc.stub.StreamObserver
import kr.socar.demo.rpc.GreeterGrpc
import kr.socar.demo.rpc.HelloReply
import kr.socar.demo.rpc.HelloRequest

class GreeterImpl : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(req: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        val reply = HelloReply.newBuilder().setMessage("Hello ${req.name}").build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
