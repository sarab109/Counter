package com.example.Counter;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dto.CounterNumber;

@Repository
public interface NumberRepository extends JpaRepository<CounterNumber, Long> {
   
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select n from Number n where n.id=:id")
	Optional<CounterNumber> findNumberForWrite(@Param("id") Long id);
}
