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
		
		NovaCompraRequest novoCompraRequest = (NovaCompraRequest) target;
		
		Long paisId = novoCompraRequest.getPaisId();
		Long estadoId = novoCompraRequest.getEstadoId();
				
		List<Estado> estados = entityManager.createQuery("SELECT e FROM Estado e JOIN FETCH e.pais WHERE e.id =:paisId", Estado.class)
							 				.setParameter("paisId", paisId)
							 				.getResultList();
		
		boolean estadoPertenceAoPais = true;

		if (estadoId != null) {
			estadoPertenceAoPais = estados.stream().anyMatch(e -> estadoId.equals(e.getId()));
		}
		else if (!estados.isEmpty()) {		
			errors.rejectValue("estadoId", null, "O país informado possui estados relacionados.");
		}
		
		if (!estadoPertenceAoPais) {
			errors.rejectValue("estadoId", null, "O estado informado não pertence ao país.");
		}
	}
	
}
