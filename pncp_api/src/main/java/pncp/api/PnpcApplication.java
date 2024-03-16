package pncp.api;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import pncp.api.controller.BuscarAmparosLegais;
import pncp.api.models.pncp.amparoLegal.dto.DadosAmparoLegalDTO;
import pncp.api.models.pncp.amparoLegal.repository.AmparaLegalRepository;
import pncp.api.models.pncp.amparoLegal.repository.AmparoLegal;
import pncp.api.models.pncp.amparoLegal.services.AmparoLegalService;


@SpringBootApplication
public class PnpcApplication implements CommandLineRunner {


	@Autowired
	private AmparoLegalService service;


	public static void main(String[] args) {
		SpringApplication.run(PnpcApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		
		/*

		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja Buscar pelos Ativos ou Inativo True ? False");
		boolean resp = sc.nextBoolean();

		 */

		List<DadosAmparoLegalDTO> dados = this.service.recuperarDadosPncpClassService(true);

		if(dados.isEmpty()){
			System.out.println("Nenhum dado encontrado");
		}
		else{
			System.out.println("Dados Recuperado");

			for (DadosAmparoLegalDTO dado : dados){
				
				this.service.registrarAmparosLegaisClassService(dado);
				System.out.println(dado);
			}
		}
		
	}

}
