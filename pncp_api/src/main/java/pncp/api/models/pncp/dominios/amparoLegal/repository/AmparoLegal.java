package pncp.api.models.pncp.dominios.amparoLegal.repository;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pncp.api.models.pncp.dominios.amparoLegal.dto.DadosAmparoLegalDTO;


@Entity(name = "amparoLegal")
@Table(name = "amparo_legal")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AmparoLegal {

    private static final String CAMPO_ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CAMPO_ID)
    private Long id;


    private String nome;

    private String descricao;

    @Column(name = "data_inclusao")
    private String dataInclusao;

    @Column(name = "data_atualizacao")
    private String dataAtualizacao;

    private Boolean status;

    public AmparoLegal(DadosAmparoLegalDTO dados){
        this.id = dados.id();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataInclusao = dados.dataInclusao();
        this.dataAtualizacao = dados.dataAtualizacao();
        this.status = dados.statusAtivo();

    }

    public AmparoLegal(){
        
    }


    
}
