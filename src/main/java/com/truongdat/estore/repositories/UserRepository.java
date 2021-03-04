package com.truongdat.estore.repositories;

import com.truongdat.estore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPasswordAndIsAdminTrue(String username, String password);
}
