package com.inovafac.repository;

import com.inovafac.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {
    List<Precio> findByActivoTrue();
}
