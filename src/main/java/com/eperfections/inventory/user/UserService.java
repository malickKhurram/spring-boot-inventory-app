package com.eperfections.inventory.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        Optional<User> userOptional = userRepository.findUserByName(user.getName());
        if(userOptional.isPresent()){
            throw new IllegalStateException("User Name already exists");
        }
        this.userRepository.save(user);
    }
    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Product with id "+id+" does not exists!"
            );
        }
        this.userRepository.deleteById(id);
    }
    @Transactional
    public void updateUser(Long userId, String name, String location){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User does not exist"));
        if(name != null &&
            name.length()>0 &&
                !Objects.equals(user.getName(),name)){
            user.setName(name);
        }
        if(location != null &&
                location.length()>0 &&
                !Objects.equals(user.getLocation(),location)){
            user.setLocation(location);
        }
    }
}
