package com.hr.whitus.repositories;


import com.hr.whitus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


// to create a repository, extend JpaRepository or CrudRepository class
// with the model and the model identifier type
// contains all methods, i can overwrite
// Jpa as paginator
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.username = ?1")
    User findByUsername(String email);

}
