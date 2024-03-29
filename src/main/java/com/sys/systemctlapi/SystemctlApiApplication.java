package com.sys.systemctlapi;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.Transport;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SystemctlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemctlApiApplication.class, args);
    }

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(9001);
       // config.setTransports(Transport.POLLING, Transport.WEBSOCKET);
        config.setOrigin(":*:");
        /*config.setAuthorizationListener(new AuthorizationListener() {//类似过滤器
            @Override
            public boolean isAuthorized(HandshakeData data) {
                //http://localhost:8081?username=test&password=test
                //例如果使用上面的链接进行connect，可以使用如下代码获取用户密码信息，本文不做身份验证
                // String username = data.getSingleUrlParam("username");
                // String password = data.getSingleUrlParam("password");
                return true;
            }
        });*/
        final SocketIOServer server = new SocketIOServer(config);
        return server;
    }
    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }

}
