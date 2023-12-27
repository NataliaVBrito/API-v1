package com.demo.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.v1.entitys.CiudadEntity;
import com.demo.api.v1.entitys.ClienteEntity;
import com.demo.api.v1.repositorys.ICiudadRepository;
import com.demo.api.v1.repositorys.IClienteRepository;

@RestController
@RequestMapping("/api-v1")
public class ClienteController {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private ICiudadRepository ciudadRepository;

	@GetMapping("/clientes")
	public List<ClienteEntity> listaClientes() {
		return clienteRepository.findAll();
	}

	@GetMapping("/cliente/{idCliente}")
	public ClienteEntity buscarPorId(@PathVariable Integer idCliente) {
		ClienteEntity cliente = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		return cliente;
	}

	@GetMapping("/cliente/estado/{idCliente}")
	public boolean estadoCliente(@PathVariable Integer idCliente) {
		ClienteEntity cliente = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		return cliente.isHabilitado();
	}

	@PutMapping("/cliente/editar/{idCliente}")
	public void editarPorId(@RequestBody ClienteEntity cliente, @PathVariable Integer idCliente) {
		ClienteEntity existencia = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		existencia.setNombre(cliente.getNombre());
		existencia.setApellido(cliente.getApellido());
		existencia.setDomicilio(cliente.getDomicilio());

		clienteRepository.saveAndFlush(existencia);
	}

	@PutMapping("/cliente/editarCiudad/{idCLiente}/{idCiudad}")
	public void editarCiudadDelCliente(@PathVariable Integer idCliente, @PathVariable Integer idCiudad) {
		ClienteEntity clienteExistente = clienteRepository.findById(idCliente).get();
		CiudadEntity ciudadExistente = ciudadRepository.findById(idCiudad).get();

		if (!clienteRepository.existsById(idCliente) || ciudadExistente == null) {
			throw new RuntimeException("No existe el cliente Nro {idCliente} o la ciudad Nro {idCiudad}");
		}

		clienteExistente.setIdCiudad(ciudadExistente);
		clienteRepository.saveAndFlush(clienteExistente);
	}

	@PutMapping("/cliente/habilitar/{idCliente}")
	public void habilitarCliente(@PathVariable Integer idCliente) {
		ClienteEntity cliente = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		cliente.setHabilitado(true);

		clienteRepository.saveAndFlush(cliente);
	}

	@PutMapping("/cliente/inhabilitar/{idCliente}")
	public void inhabilitarCliente(@PathVariable Integer idCliente) {
		ClienteEntity cliente = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		cliente.setHabilitado(false);

		clienteRepository.saveAndFlush(cliente);
	}

	@DeleteMapping("/cliente/borrar/{idCliente}")
	public void borrarCliente(@PathVariable Integer idCliente) {
		ClienteEntity cliente = clienteRepository.findById(idCliente).get();

		if (!clienteRepository.existsById(idCliente)) {
			throw new RuntimeException("No existe el cliente Nro {idCliente}");
		}

		cliente.setIdCiudad(null);
		clienteRepository.delete(cliente);
	}
}
