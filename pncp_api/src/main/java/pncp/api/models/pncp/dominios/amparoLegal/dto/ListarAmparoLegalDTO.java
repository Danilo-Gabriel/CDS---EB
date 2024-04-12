package pncp.api.models.pncp.dominios.amparoLegal.dto;

import pncp.api.models.pncp.dominios.amparoLegal.repository.AmparoLegal;

public record ListarAmparoLegalDTO(

        Long id,

        String nome,

        String descricao,

        String dataInclusao,

        String dataAtualizacao,

        Boolean status

) {
    public ListarAmparoLegalDTO(AmparoLegal dados){
        
        this(dados.getId(), dados.getNome(), dados.getDescricao(), dados.getDataAtualizacao(), dados.getDataAtualizacao(), dados.getStatus());
    }
} 