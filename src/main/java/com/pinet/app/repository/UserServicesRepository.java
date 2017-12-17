package com.pinet.app.repository;

import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.entities.UserServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bpalikhe on 7/15/17.
 */
@Repository
public interface UserServicesRepository extends JpaRepository<UserServicesEntity,Integer > {


    UserServicesEntity findByClientID(ClientDataEntity clientId);

    List<UserServicesEntity> findByserviceTypeEntity(ServiceTypeEntity serviceTypeEntity);
}
