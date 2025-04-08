package org.example.atelier2;

import org.example.atelier2.entities.Role;
import org.example.atelier2.entities.User;
import org.example.atelier2.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Atelier2Application {

    public static void main(String[] args) {
        SpringApplication.run(Atelier2Application.class, args);
    }
@Bean//chaque methode est bean et chaque methode s'execute dans le démarre
    CommandLineRunner start(UserService userService) {
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("123");
            userService.addNewUser(u2);

            Stream.of("STUDENT","USER","ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);
            });

             userService.addRoleToUser("user1","STUDENT");
             userService.addRoleToUser("user1","USER");
             userService.addRoleToUser("admin","ADMIN");
             userService.addRoleToUser("admin","USER");


             try {
                 User user=userService.authenticate("user1","123456");
                 System.out.println(user.getUserId());
                 System.out.println(user.getPassword());
                    System.out.println("Roles=");
                    user.getRoles().forEach(r -> {
                        System.out.println("RoleName="+r.toString());
                    });

             }catch (Exception e) {
                 e.printStackTrace();
             }

        };
    }

}
