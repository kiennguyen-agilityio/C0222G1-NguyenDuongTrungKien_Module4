package com.codegym.repository;

import com.codegym.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    Page<Ticket> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM ticket WHERE start_position LIKE :startPosition AND end_position LIKE :endPosition", nativeQuery = true)
    Page<Ticket> search(@Param("startPosition") String startPosition, @Param("endPosition") String endPosition , Pageable pageble);
}
