package com.aytugakin.spider.repository;


import com.aytugakin.spider.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {
    Optional<Operation> findByOperationCode(String operationCode);
}
