package com.embatask.productmanagement.service;
import com.embatask.productmanagement.domain.User;
import com.embatask.productmanagement.repository.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final static Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordRepository;

    public User addUser(User user){
        String hashedPassword= passwordRepository.hashPassword(user.getUserPassword());
         user.setUserPassword(hashedPassword);
        return userRepository.save(user);
    }

    public List<User> getAll(){
        List<User>users = new ArrayList<>();
        Iterable<User>userIterable = userRepository.findAll();
        userIterable.forEach(users::add);
        return users;
    }

    public User getUserById(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        return user;
    }


    public User getUserByEmail(String email){
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUserEmail(email));
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();

        }
        return user;
    }

    public boolean checkDuplicate(String email){
        Optional<Boolean>optionalBoolean = Optional.of(userRepository.existsByUserEmail(email));
        return true;

    }

    public User updateUser(User user){
        Optional<User>optionalUser = userRepository.findById(user.getUserID());
        User user1 = null;
        if (optionalUser.isPresent()){
             userRepository.save(user);
        }
        return user1;
    }

    public  void deleteUser(int id){
        Optional<User>optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
        }
    }

}
