package com.dinheiro.monitor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DinheiroRepository extends JpaRepository<DinheiroDado, Long> {
}
