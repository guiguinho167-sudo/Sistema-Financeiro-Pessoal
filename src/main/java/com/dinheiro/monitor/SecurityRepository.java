package com.dinheiro.monitor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<SecurityDados, Long> {
    Optional<SecurityDados> findByGmail(String gmail);

}
