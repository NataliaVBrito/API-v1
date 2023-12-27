package com.demo.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.v1.entitys.CiudadEntity;
import com.demo.api.v1.repositorys.ICiudadRepository;

@RestController
@RequestMapping("/api-v1")
public class CiudadController {

	@Autowired
	private ICiudadRepository ciudadRepository;

	@GetMapping("/ciudades")
	public List<CiudadEntity> listaCiudades() {
		return ciudadRepository.findAll();
	}

	@GetMapping("/ciudad/{idCiudad}")
	public CiudadEntity buscarCiudad(@PathVariable Integer idCiudad) {
		CiudadEntity ciudad = ciudadRepository.findById(idCiudad).get();

		if (!ciudadRepository.existsById(idCiudad)) {
			throw new RuntimeException("La ciudad Nro {idCiudad} no existe");
		}

		return ciudad;
	}

	@PostMapping("/ciudad/crear")
	public void crearCiudad(@RequestBody CiudadEntity ciudad) {
		ciudad.setIdCiudad(0);
		ciudadRepository.save(ciudad);
	}

	@PutMapping("/ciudad/editar/{idCiudad}")
	public void editarCiudad(@RequestBody CiudadEntity ciudad, @PathVariable Integer idCiudad) {
		CiudadEntity existencia = ciudadRepository.findById(idCiudad).get();

		if (!ciudadRepository.existsById(idCiudad)) {
			throw new RuntimeException("La ciudad Nro {idCiudad} no existe");
		}

		existencia.setNombre(ciudad.getNombre());

		ciudadRepository.saveAndFlush(existencia);
	}

	@DeleteMapping("/ciudad/borrar/{idCiudad}")
	public void borrarCiudad(@PathVariable Integer idCiudad) {
		if (!ciudadRepository.existsById(idCiudad)) {
			throw new RuntimeException("La ciudad que buscas no existe");
		}

		ciudadRepository.deleteById(idCiudad);
	}

}
