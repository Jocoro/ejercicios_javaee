package com.whiteam.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.whiteam.model.Pais;
@Service
public class PaisesServiceImpl implements PaisesService {
	String url="https://restcountries.com/v2/all";
	@Autowired
	RestTemplate template;

	@Override
	public List<String> getContinentes() {
		return List.of(template.getForObject(url, Pais[].class)).stream()
		.map(pais->pais.getContinente()).distinct()
		.collect(Collectors.toList());
	}

	@Override
	public List<Pais> getPaises(String continente) {
		return List.of(template.getForObject(url, Pais[].class)).stream()
				.filter(pais->pais.getContinente().equals(continente))
				.collect(Collectors.toList());
	}

	@Override
	public Pais getPaisPoblado() {
		// TODO Auto-generated method stub
		return List.of(template.getForObject(url, Pais[].class)).stream()
				.max(Comparator.comparing(pais->pais.getHabitantes()))
				.orElse(new Pais());
				
	}

}
