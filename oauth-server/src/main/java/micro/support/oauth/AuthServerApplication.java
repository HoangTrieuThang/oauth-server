package micro.support.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
@RequestMapping("/user/hello")
public class AuthServerApplication {
    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class,args);
    }
}
