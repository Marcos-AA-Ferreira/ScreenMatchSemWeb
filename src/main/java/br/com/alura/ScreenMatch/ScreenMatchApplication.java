package br.com.alura.ScreenMatch;

import br.com.alura.ScreenMatch.Model.DadosSerie;
import br.com.alura.ScreenMatch.Service.ConsumoAPI;
import br.com.alura.ScreenMatch.Service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	String nomeDaSerie = "gilmore+girls&Season";
	String buscaSerie = "https://www.omdbapi.com/?t=" + nomeDaSerie + /*busca.replace(" ", "+")Serve para subtituir um termo + */"&apikey=SuaChave";
	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados(buscaSerie);
		System.out.println("\n" + json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDado(json,  DadosSerie.class);
		System.out.println(dados);
	}
}
