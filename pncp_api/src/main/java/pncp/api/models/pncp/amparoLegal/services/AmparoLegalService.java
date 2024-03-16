package pncp.api.models.pncp.amparoLegal.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pncp.api.models.pncp.amparoLegal.dto.DadosAmparoLegalDTO;
import pncp.api.models.pncp.amparoLegal.repository.AmparaLegalRepository;
import pncp.api.models.pncp.amparoLegal.repository.AmparoLegal;

@Service
public class AmparoLegalService {
    
    @Autowired
    private AmparaLegalRepository repository;


    private RestTemplate restTemplate;

    public AmparoLegalService(RestTemplate restTemplate){
        
        this.restTemplate = restTemplate;
    }

     public List<DadosAmparoLegalDTO> recuperarDadosPncpClassService(Boolean statusAtivo){
          
            String url = "https://treina.pncp.gov.br/api/pncp/v1/amparos-legais" + "?statusAtivo=" + statusAtivo;
            
            // Implementar DTO para resposta de sucesso depois, e passar para o arquivo services também
            ResponseEntity<DadosAmparoLegalDTO[]> resposta = restTemplate.getForEntity(url, DadosAmparoLegalDTO[].class);
           return Arrays.asList(resposta.getBody());
      
    }

    public void registrarAmparosLegaisClassService(DadosAmparoLegalDTO dados) {

         AmparoLegal newDados = new AmparoLegal(dados);
 
         this.repository.save(newDados);
 
     }

}
