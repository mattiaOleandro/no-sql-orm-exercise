package co.develhope.nosqlormexercise.controllers;

import co.develhope.nosqlormexercise.entities.User;
import co.develhope.nosqlormexercise.repositories.I_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private I_UserRepository i_userRepository;

    @PostMapping("/postUser")
    public User postUser(@Validated @RequestBody User user){
        return i_userRepository.save(user);
    }

    @GetMapping("/countUsers")
    public long countUsers(){
        return i_userRepository.count();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id) throws Exception{
        Optional<User> user = i_userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        else
            throw new Exception("User not found!");

    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return i_userRepository.findAll();
    }

    @PutMapping("/putUser/{id}")
    public User putUser(@PathVariable String id, @RequestBody User user) throws Exception{
        if (!i_userRepository.existsById(id)) throw new Exception("User not found!");
        user.setId(id);
        return i_userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@Validated @PathVariable String id){
        i_userRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers(){
        i_userRepository.deleteAll();
    }
}
