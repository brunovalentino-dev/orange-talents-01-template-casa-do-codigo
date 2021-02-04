package br.com.zup.casadocodigo.validation.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.casadocodigo.validation.annotation.RegistroExistente;

public class RegistroExistenteValidator implements ConstraintValidator<RegistroExistente, Object> {

	private String campo;
	private Class<?> dominio;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void initialize(RegistroExistente constraintAnnotation) {
		campo = constraintAnnotation.campo();
		dominio = constraintAnnotation.dominio();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String queryString = "SELECT 1 FROM " + dominio.getSimpleName() + " WHERE " + campo + "=:valor";
		
		Query query = entityManager.createQuery(queryString);
		query.setParameter("valor", value);
		
		List<?> listaDeRegistros = query.getResultList();
		
		return !listaDeRegistros.isEmpty();
	}

}
