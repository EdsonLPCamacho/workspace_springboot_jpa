package com.webdevelopment.development.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdevelopment.development.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
