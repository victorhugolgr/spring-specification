package br.com.devmedia.pocket.service;

import br.com.devmedia.pocket.entity.Contato;
import br.com.devmedia.pocket.repository.ContatoRepository;
import br.com.devmedia.pocket.specification.ContatoSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ballem on 25/02/2016.
 */
@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public List<Contato> findBySexoMaioridade(String sexo) {

        return repository.findAll(
        		Specifications
        			.where(ContatoSpecification.sexo(sexo))
        			.and(ContatoSpecification.maioridade())
        );
    }

    public long findByGenero(String sexo) {
    	
        return repository.count(ContatoSpecification.sexo(sexo));
    }

    public Contato findByNomeCompleto(String nome, String sobrenome) {
    	
        return repository.findOne(
        		Specifications
        			.where(ContatoSpecification.nome(nome))
        			.and(ContatoSpecification.sobrenome(sobrenome))
        );
    }

    public List<Contato> findByMenoridadeAndGenero(String sexo) {
    	
        return repository.findAll(
        		Specifications
        			.not(ContatoSpecification.maioridade())
        			.and(ContatoSpecification.sexo(sexo))
        );
    }

    public List<Contato> findByIdade(int idade) {
    	
        return repository.findAll(ContatoSpecification.idade(idade));
    }
}
