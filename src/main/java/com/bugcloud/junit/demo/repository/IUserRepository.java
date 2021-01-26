package com.bugcloud.junit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugcloud.junit.demo.model.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
