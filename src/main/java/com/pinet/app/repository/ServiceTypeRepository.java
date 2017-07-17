package com.pinet.app.repository;

import com.pinet.app.entities.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bijesh on 7/17/2017.
 */
public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Integer> {
}
