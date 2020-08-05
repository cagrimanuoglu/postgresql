package com.example.springPostgres.springPostgresql.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springPostgres.springPostgresql.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
