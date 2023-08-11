package pandhuta.aws.learning.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pandhuta.aws.learning.crud.entity.User;
import pandhuta.aws.learning.crud.exception.ResousceNotFoundException;
import pandhuta.aws.learning.crud.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // get all api
    @GetMapping
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResousceNotFoundException("User not found with id :" + userId));
    }

    // create user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResousceNotFoundException("User not found with id :" + userId));
        existingUser.setFirtsName(user.getFirtsName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }

    // delete user by id
    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResousceNotFoundException("User not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}
