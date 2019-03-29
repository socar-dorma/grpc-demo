package kr.socar.grpc.demo

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.StatusRuntimeException
import kr.socar.demo.rpc.GreeterGrpc
import kr.socar.demo.rpc.HelloReply
import kr.socar.demo.rpc.HelloRequest
import java.util.concurrent.TimeUnit

/**
 * A simple client that requests a greeting from the [HelloWorldServer].
 */
class HelloWorldClient
/** Construct client for accessing RouteGuide server using the existing channel.  */
internal constructor(private val channel: ManagedChannel) {
    private val blockingStub: GreeterGrpc.GreeterBlockingStub
        = GreeterGrpc.newBlockingStub(channel)

    /** Construct client connecting to HelloWorld server at `host:port`.  */
    constructor(host: String, port: Int) : this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build()) {
    }


    @Throws(InterruptedException::class)
    fun shutdown() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }

    /** Say hello to server.  */
    fun greet(name: String) : String {
        val request = HelloRequest.newBuilder().setName(name).build()
        val response: HelloReply =  try {
            blockingStub.sayHello(request)
        } catch (e: StatusRuntimeException) {
            return ""
        }

        return response.message
    }
}
