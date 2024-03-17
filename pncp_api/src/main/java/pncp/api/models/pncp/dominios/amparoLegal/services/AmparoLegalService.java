package pncp.api.models.pncp.dominios.amparoLegal.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import pncp.api.models.pncp.dominios.amparoLegal.dto.DadosAmparoLegalDTO;
import pncp.api.models.pncp.dominios.amparoLegal.repository.AmparaLegalRepository;
import pncp.api.models.pncp.dominios.amparoLegal.repository.AmparoLegal;

@Service
public class AmparoLegalService {
    
    @Autowired
    private AmparaLegalRepository repository;

    @Autowired
    private AppConfig restTamplate;

    //@Value("")
    String apiUrl = "https://treina.pncp.gov.br/api/pncp/v1/amparos-legais";




     public List<DadosAmparoLegalDTO> recuperarDadosPncpClassService(Boolean statusAtivo){
          
            String url = apiUrl + "?statusAtivo=" + statusAtivo;
            
            // Implementar DTO para resposta de sucesso depois, e passar para o arquivo services também
            ResponseEntity<DadosAmparoLegalDTO[]> resposta = restTamplate.restTemplate().getForEntity(url, DadosAmparoLegalDTO[].class);
           return Arrays.asList(resposta.getBody());
      
    }

    public void registrarAmparosLegaisClassService(DadosAmparoLegalDTO dados) {

         AmparoLegal newDados = new AmparoLegal(dados);
 
         this.repository.save(newDados);
 
     }

}
