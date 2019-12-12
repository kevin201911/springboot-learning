package com.mscloudmesh.springbootmongodb.repository;


import com.mscloudmesh.springbootmongodb.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserInfo,Long> {
}

