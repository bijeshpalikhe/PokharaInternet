package com.pinet.app.repository;


import com.pinet.app.entities.ClientDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bpalikhe on 7/15/17.
 */
@Repository
public interface ClientDataRepository extends JpaRepository<ClientDataEntity,Integer > {
    ClientDataEntity findByUserName(String username);
}
