package org.example.atelier2.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.atelier2.entities.Role;
import org.example.atelier2.entities.User;
import org.example.atelier2.repository.RoleRepository;
import org.example.atelier2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//dans la couche metier o utilise service au lieu de component car est generale les 2 indisue une classe doit etre instansier au demarage bien que component est generale on peut l'utilisé dans n'importe quel couche
@Service//component de la couche metier
//dans la couche service en gere les transaction
@Transactional
@AllArgsConstructor // utilise au lieu de cree le constructeur
public class UserServiceImpl implements UserService {
    //@Autowired //injection des dependence
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    /**public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }**/


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());//generer un userid aléatoirement sous forme de chaine de caractére
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        Role existingRole = roleRepository.findByRoleName(role.getRoleName());
        if (existingRole == null) {
            return roleRepository.save(role);
        } else {
            throw new RuntimeException("Ce rôle existe déjà !");
        }
    }


    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);//chercher dans la base le user
        Role role = findRoleByRoleName(roleName);//chercher dans la base le role
        if(user.getRoles()!=null) {
            user.getRoles().add(role);//ajouter le role au user
            role.getUsers().add(user);//bidirectionnel
            //userRepository.save(user);//on a pas beson de fair ca car on utulise @transactional toute les modif sont fais atomatiquement dans la base
        }


    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("Bad credentials");}
            if (user.getPassword().equals(password)) {
                return user;
            }
            throw new RuntimeException("Bad credentials");
        }

    }