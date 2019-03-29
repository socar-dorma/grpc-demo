package kr.socar.grpc.demo

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
@ConfigurationProperties(prefix = "grpc.helloworld")
class AppConfig {
    var host: String = "localhost"
    var port: Int = 50001
    @Bean(destroyMethod = "shutdown")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    fun helloWorldClient() : HelloWorldClient {
        System.out.println("host - $host, port - $port")
        return HelloWorldClient(host, port)
    }
}
