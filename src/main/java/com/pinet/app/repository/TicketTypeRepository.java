package com.pinet.app.repository;

import com.pinet.app.entities.TicketTypeEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketTypeEntitiy, String> {

}
