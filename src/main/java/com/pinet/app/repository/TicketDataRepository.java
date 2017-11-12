package com.pinet.app.repository;

import com.pinet.app.entities.TicketDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDataRepository extends JpaRepository<TicketDataEntity, Integer> {
}
