package org.example.atelier2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME", unique = true,length = 20)//cad que usernname unique
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)// rager a chaque fois va charger un user va le charger avec son role

    @ToString.Exclude

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//pour régler le prblm de la boucle dans http/localhost/8003/users/user1
    private List<Role> roles = new ArrayList<>();

}
