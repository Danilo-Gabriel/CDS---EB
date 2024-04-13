package pncp.api.models.pncp.dominios.amparoLegal.dto;

public record DadosAmparoLegalDTO(

    Long id,

    String nome,

    String descricao,

    String dataInclusao,

    String dataAtualizacao,

    Boolean status

) {
    
    
}
