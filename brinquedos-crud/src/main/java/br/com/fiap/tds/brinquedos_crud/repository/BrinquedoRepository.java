package br.com.fiap.tds.brinquedos_crud.repository;

import br.com.fiap.tds.brinquedos_crud.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}
