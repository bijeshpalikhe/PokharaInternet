package com.pinet.app.repository;

import com.pinet.app.entities.UserServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bpalikhe on 7/15/17.
 */
@Repository
public interface UserServicesRepository extends JpaRepository<UserServicesEntity,Integer > {
}
