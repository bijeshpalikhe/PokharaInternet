package com.pinet.app.repository;

import com.pinet.app.entities.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bijesh on 7/12/2017.
 */
public interface UserDetailRepository extends JpaRepository<UserDetailEntity,Integer > {
}
