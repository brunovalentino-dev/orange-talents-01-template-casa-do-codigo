package br.com.zup.casadocodigo.validation.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.controller.request.NovaCompraRequest;
import br.com.zup.casadocodigo.model.Estado;

@Component
public class EstadoPaisValidator implements Validator {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		NovaCompraRequest novoClienteRequest = (NovaCompraRequest) target;
		
		Long paisId = novoClienteRequest.getPaisId();
		Long estadoId = novoClienteRequest.getEstadoId();
		
		List<Estado> estados = entityManager.createQuery("SELECT e FROM Estado e WHERE e.pais.id =:paisId", Estado.class)
							 				.setParameter("paisId", paisId)
							 				.getResultList();
		
		boolean estadoPertenceAoPais = true;

		if (!estados.isEmpty() && estadoId == null) { 
			errors.rejectValue("estadoId", null, "O país informado possui estados relacionados.");
		}
		
		if (estadoId != null) {
			estadoPertenceAoPais = estados.stream().anyMatch(e -> estadoId.equals(e.getId()));
		}

		if (!estadoPertenceAoPais) {
			errors.rejectValue("estadoId", null, "O estado informado não pertence ao país.");
		}
	}
	
}
