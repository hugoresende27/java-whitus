package com.hr.whitus.controllers.api;


import com.hr.whitus.models.User;
import com.hr.whitus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        List <User> all = this.userService.findAll();
        return ResponseEntity.ok().body(all);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User obj = this.userService.findById(id);

        return ResponseEntity.ok().body(obj);  //.ok to return 200
    }

    @PostMapping
    @Validated(User.CreateUser.class)
    public ResponseEntity<User> create(@Valid @RequestBody User obj){

        this.userService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    @Validated(User.UpdateUser.class)
    public ResponseEntity<User> update(@Valid @RequestBody User obj, @PathVariable Long id){
        obj.setId(id);
        obj = this.userService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
