package com.pooja.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.dev.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
