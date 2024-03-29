package com.michellima.springbootmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.michellima.springbootmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
