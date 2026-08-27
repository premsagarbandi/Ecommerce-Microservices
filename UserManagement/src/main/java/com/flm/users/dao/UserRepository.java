package com.flm.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
