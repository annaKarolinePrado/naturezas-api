package br.com.natureza.naturezaapi.dto;

import br.com.natureza.naturezaapi.models.Configuracao;
import br.com.natureza.naturezaapi.models.Nivel;

import java.util.List;

public class ConfiguracaoDTO {

    private Integer id;
    private String descricao;
    private List<Nivel> niveis;

    public ConfiguracaoDTO() {
    }

    public ConfiguracaoDTO(Configuracao configuracao) {
        this.id = configuracao.getId();
        this.descricao = configuracao.getDescricao();
    }

    public List<Nivel> getNiveis() {
        return niveis;
    }
    public void setNiveis(List<Nivel> niveis) {
        this.niveis = niveis;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
