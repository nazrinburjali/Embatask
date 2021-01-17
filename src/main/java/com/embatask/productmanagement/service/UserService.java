package com.embatask.productmanagement.service;
import com.embatask.productmanagement.controller.AdminController;
import com.embatask.productmanagement.domain.User;
import com.embatask.productmanagement.repository.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


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
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + " id-li user yoxdur");
        }
        return user;
    }


    public User getUserByEmail(String email){
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUserEmail(email));
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, email + " emailine malik user yoxdur");
        }
        return user;
    }
    public String getEmail(String email){
        Optional<String> optionalS = userRepository.getUserByUserEmail(email);
        if(optionalS.isPresent()){
          return optionalS.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, email + " emailine malik user yoxdur");
        }

    }
    public User checkUserLogin(String email){
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUserEmail(email));
        User user = null;
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, email + " bazada tapilmadi");
        }
        return user;
    }

    public User updateUser(User user){
        Optional<User>optionalUser = userRepository.findById(user.getUserID());
        if (optionalUser.isPresent()){
            return userRepository.save(user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, user.getUserID() + " id-li user yoxdur");
        }
    }

    public  void deleteUser(int id){
        Optional<User>optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + " id-li user yoxdur");
        }
    }

}
