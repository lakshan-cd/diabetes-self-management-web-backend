package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    //get count of users according to catergory
    @Query("SELECT u.user_type, COUNT(u) FROM User u GROUP BY u.user_type")
    List<Object[]> countByUserType();
}
