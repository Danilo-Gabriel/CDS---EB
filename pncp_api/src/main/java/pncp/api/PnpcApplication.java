package pncp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
		
		this.service.recuperarDadosPncpClassService(true);
		
	}

}
