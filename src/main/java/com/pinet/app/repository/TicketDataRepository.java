package com.pinet.app.repository;

import com.pinet.app.entities.TicketDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketDataRepository extends JpaRepository<TicketDataEntity, Integer> {

    List<TicketDataEntity> findByActive(boolean b);
}
