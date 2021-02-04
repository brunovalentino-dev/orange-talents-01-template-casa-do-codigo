package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.request.NovaCompraRequest;
import br.com.zup.casadocodigo.validation.validator.EstadoPaisValidator;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private EstadoPaisValidator estadoPaisValidator;
	
	@InitBinder
	public void iniciarWebDataBinder(WebDataBinder binder) {
		binder.addValidators(estadoPaisValidator);
	}
	
	@PostMapping
	public String cadastrarNovaCompra(@RequestBody @Valid NovaCompraRequest request) {
		return request.toString();
	}
	
}
