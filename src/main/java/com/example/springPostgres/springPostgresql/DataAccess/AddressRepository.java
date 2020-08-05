package com.example.springPostgres.springPostgresql.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springPostgres.springPostgresql.Entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
