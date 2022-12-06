package com.javaricci.FolhaSpringBootSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaricci.FolhaSpringBootSecurity.Entity.User;

public interface UserRepos extends JpaRepository < User, Integer > {

}