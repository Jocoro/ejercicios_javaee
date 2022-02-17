package com.whiteam.service;

import java.util.List;

import com.whiteam.model.Pais;

public interface PaisesService {
	public List<String> getContinentes();
	public List<Pais> getPaises(String continente);
	public Pais getPaisPoblado();
}
