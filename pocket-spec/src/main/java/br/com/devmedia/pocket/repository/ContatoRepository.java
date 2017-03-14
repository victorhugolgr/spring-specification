package br.com.devmedia.pocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.devmedia.pocket.entity.Contato;

import java.util.List;

/**
 * Created by Ballem on 25/02/2016.
 */
public interface ContatoRepository 
				extends JpaRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {

    @Query("select c from Contato c where c.nome like ?1")
    List<Contato> findByNome(String nome);

    @Query("select c from Contato c where c.sobrenome like ?1")
    List<Contato> findBySobrenome(String sobrenome);

    @Query("select c from Contato c where c.idade >= 18")
    List<Contato> findByMaioridade();

    @Query("select c from Contato c where c.sexo like ?1")
    List<Contato> findBySexo(String sexo);

    @Query("select c from Contato c where c.sexo like ?1 and c.idade >= 18")
    List<Contato> findBySexoMaioridade(String sexo);
}
