package com.whiteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.whiteam.model.Pais;
import com.whiteam.service.PaisesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@CrossOrigin("*")
@RestController
@Api("api para sacar datos de paises")
public class PaisesController {
	@Autowired
	PaisesService service;
	@ApiOperation("Saca el listado de todos los continentes")
	@GetMapping(value="continentes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> getContinentes(){
		return service.getContinentes();
	}
	@ApiOperation("Saca el listado de paises de un continente")
	@GetMapping(value="paises/{continente}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> getPaises(@ApiParam("continente del que se quieren saber sus paises") @PathVariable String continente){
		return service.getPaises(continente);
	}
	@ApiOperation("Saca el pais con más población")
	@GetMapping(value="paispoblado",produces=MediaType.APPLICATION_JSON_VALUE)
	public Pais getPaisPoblado() {
		return service.getPaisPoblado();
	}
	
}
/*
Desarrollar un microservicio de paises. Expondará los siguientes recursos:

- Consulta de continentes: Ante una petición get, devuelve la lista de nombres de todos los continentes
- Consulta de paises. En una petición GET, recibe el nombre del continente en la URL, y deuelve los paises de ese continente
- Pais más poblado. Ante una petición GET, devuelve el pais más poblado

Un pais tendrá el sguiente formato:

{

}

Securización: Para utilizar estos recursos, los usuarios deben estar autenticados

Documentar el servicio
*/