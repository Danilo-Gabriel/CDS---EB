package pncp.api.controller.dominios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pncp.api.models.pncp.dominios.amparoLegal.dto.ListarAmparoLegalDTO;
import pncp.api.models.pncp.dominios.amparoLegal.services.AmparoLegalService;

@RestController
@RequestMapping("/api/dominio")
public class AmparoLegalController {



    @Autowired
    private AmparoLegalService service;


    @GetMapping("listarAmparoLegal")
    public ResponseEntity<List<ListarAmparoLegalDTO>> listarAmparoLegalClassController(){
    try {

      List<ListarAmparoLegalDTO> listaAmparoLegal = this.service.listarAmparoLegaisClassService(); 

        return ResponseEntity.ok().body(listaAmparoLegal);

    } catch (Exception e) {
      
        return ResponseEntity.badRequest().build();
    }
    
    }
}
