package com.pinet.app.repository;


import com.pinet.app.entities.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ashmeet on 7/15/17.
 */
@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity,Integer > {
    UserDataEntity findByName(String name);
}
