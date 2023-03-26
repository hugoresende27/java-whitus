package com.hr.whitus.services;


import com.hr.whitus.models.User;
import com.hr.whitus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        //can be if (user.isPresent())
        return user.orElseThrow(() -> new RuntimeException
                ("User not found ! id : "+ id +", Type : "+ User.class.getName()));
    }


    @Transactional  //to save in DB use always
    public User create(User obj){
        obj.setId(null);                            //to make sure ID is null
        obj = this.userRepository.save(obj);        //save the user
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());  // update password
        newObj.setUsername(obj.getUsername());  // update username
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("Cannot delete");
        }
    }


    public List<User> findAll() {

        return this.userRepository.findAll();
    }
}
