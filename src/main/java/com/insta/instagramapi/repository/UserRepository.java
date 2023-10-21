package com.insta.instagramapi.repository;
import com.insta.instagramapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{

    public Optional<User> findByEmail(String email);
    public Optional<User> findByUserName(String email);
    @Query("SELECT a FROM User a WHERE a.id IN :users ")
    public List<User> findAllUserByUserIds(@Param("users") List<Integer> userIds);
    @Query("SELECT DISTINCT u FROM User u WHERE u.username LIKE %:query% OR u.email LIKE %:query%")
    public List<User> findByQuery(@Param("query") String query);

}
