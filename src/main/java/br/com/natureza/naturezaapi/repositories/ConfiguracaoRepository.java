package br.com.natureza.naturezaapi.repositories;

import br.com.natureza.naturezaapi.models.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Integer> {

}
