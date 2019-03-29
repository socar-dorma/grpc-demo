package kr.socar.demo.rpc.server

fun main() {
    val server = HelloWorldServer()
    server.start()
    server.blockUntilShutdown()
}
