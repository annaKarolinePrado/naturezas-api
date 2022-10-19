package br.com.natureza.naturezaapi.repositories;

import br.com.natureza.naturezaapi.models.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Integer> {

}
