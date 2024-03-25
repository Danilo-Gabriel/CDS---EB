package pncp.api.controller.dominios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pncp.api.models.pncp.dominios.amparoLegal.dto.listarAmparoLegalDTO;
import pncp.api.models.pncp.dominios.amparoLegal.services.AmparoLegalService;

@RestController
@RequestMapping("/api/buscarJson")
public class AmparoLegais {



    @Autowired
    private AmparoLegalService service;


    @GetMapping
    public ResponseEntity<List<listarAmparoLegalDTO>> listarAmparoLegalClassController(){
    try {




        return ResponseEntity.ok().build();

    } catch (Exception e) {
      

        return ResponseEntity.badRequest().build();
    }
    
    }
}
