package com.dinheiro.monitor;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface DinheiroRepository extends JpaRepository<DinheiroDado, Long> {
    @Transactional
    Optional<DinheiroDado> findBySalario(BigDecimal salario);
}
