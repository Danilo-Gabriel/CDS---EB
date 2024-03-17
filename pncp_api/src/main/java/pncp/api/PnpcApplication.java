package pncp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import pncp.api.models.pncp.dominios.amparoLegal.dto.DadosAmparoLegalDTO;
import pncp.api.models.pncp.dominios.amparoLegal.services.AmparoLegalService;


@SpringBootApplication
public class PnpcApplication implements CommandLineRunner {


	@Autowired
	private AmparoLegalService service;


	public static void main(String[] args) {
		SpringApplication.run(PnpcApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		

		// boolean status = true ? false 

		List<DadosAmparoLegalDTO> dados = this.service.recuperarDadosPncpClassService(true);

		if(dados.isEmpty()){
			System.out.println("Nenhum dado encontrado");
		}
		else{

			for (DadosAmparoLegalDTO dado : dados){
				
				this.service.registrarAmparosLegaisClassService(dado);
			
			}
			
			System.out.println("Dados Recuperado");

			
		}
		
	}

}
