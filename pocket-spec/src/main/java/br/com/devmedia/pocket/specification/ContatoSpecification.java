package br.com.devmedia.pocket.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.devmedia.pocket.entity.Contato;

/**
 * Created by Ballem on 25/02/2016.
 */
public class ContatoSpecification {

	public static Specification<Contato> maioridade() {
		return new Specification<Contato>() {

			@Override
			public Predicate toPredicate(Root<Contato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.greaterThanOrEqualTo(root.get("idade"), 18);
			}

		};
	}

	public static Specification<Contato> sexo(String sexo) {

		return new Specification<Contato>() {

			@Override
			public Predicate toPredicate(Root<Contato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get("sexo"), sexo);
			}

		};
	}

	public static Specification<Contato> nome(String nome) {
		return new Specification<Contato>() {

			@Override
			public Predicate toPredicate(Root<Contato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get("nome"), nome);
			}

		};
	}

	public static Specification<Contato> sobrenome(String sobrenome) {
		return new Specification<Contato>() {

			@Override
			public Predicate toPredicate(Root<Contato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get("sobrenome"), sobrenome);
			}

		};
	}

	public static Specification<Contato> idade(Integer idade) {
		return new Specification<Contato>() {

			@Override
			public Predicate toPredicate(Root<Contato> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				query.orderBy(cb.asc(root.get("nome")), cb.asc(root.get("sobrenome")));

				return cb.equal(root.get("idade"), idade);
			}

		};
	}
}
