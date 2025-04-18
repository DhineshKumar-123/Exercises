package com.exercise.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.practice.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
