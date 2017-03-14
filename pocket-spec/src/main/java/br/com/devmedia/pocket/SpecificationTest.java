package br.com.devmedia.pocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.devmedia.pocket.repository.ContatoRepository;
import br.com.devmedia.pocket.service.ContatoService;

/**
 * Created by Ballem on 25/02/2016.
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories()
public class SpecificationTest implements CommandLineRunner {

	@Autowired
	private ContatoRepository repository;
    @Autowired
    private ContatoService service;

    public static void main(String[] args) {
        SpringApplication.run(SpecificationTest.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //System.out.println("|-- Lista todos por nome --|");
        //repository.findByNome("Bruna").forEach(System.out::println);

        //System.out.println("|-- Lista todos por sobrenome --|");
        //repository.findBySobrenome("Silva").forEach(System.out::println);

        //System.out.println("|-- Lista todos de maioridade --|");
        //repository.findByMaioridade().forEach(System.out::println);

        //System.out.println("|-- Lista todos por genero --|");
        //repository.findBySexo("F").forEach(System.out::println);

        //System.out.println("|-- Lista todos por genero e maioridade --|");
    	//repository.findBySexoMaioridade("F").forEach(System.out::println);
        //service.findBySexoMaioridade("F").forEach(System.out::println);

        System.out.println("|-- Total de genero masculino --|");
        System.out.printf("%s contatos s�o do sexo masculino\n", service.findByGenero("M"));
    	System.out.printf("%s contatos s�o do sexo feminino\n", service.findByGenero("F"));

        //System.out.println("|-- Lista por nome completo --|");
        //System.out.println(service.findByNomeCompleto("Bruna", "Ribeiro"));

        //System.out.println("|-- Lista todos de menoridade --|");
        //service.findByMenoridadeAndGenero("M").forEach(System.out::println);

        System.out.println("|-- Lista por idades de forma ascendente --|");
        service.findByIdade(34).forEach(System.out::println);
    }
}
