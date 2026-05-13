package raihan.pelanggan.pelanggan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raihan.pelanggan.pelanggan.model.pelanggan;

@Repository
public interface pelangganRepository extends JpaRepository<pelanggan, Long> {
}