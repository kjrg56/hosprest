package com.kraytech.restdemo.resources;

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

import com.kraytech.restdemo.repositories.MedicoRepository;
import com.kraytech.restdemo.repositories.domain.Medico;

@RestController
@RequestMapping("/medicos")
public class MedicoResource {

	@Autowired
	private MedicoRepository medicoRepo;

	@GetMapping
	public List<Medico> findAll() {
		return medicoRepo.findAll();
	}
	
	@PostMapping
	public Medico save(@RequestBody Medico medico) {
		return medicoRepo.save(medico);
	}

	@GetMapping("/{id}")
	public Medico findById(@PathVariable(name = "id") Long id) {
		return medicoRepo.findById(id).orElse(new Medico());
	}
	
	@PutMapping("/{id}")
	public Medico update(@RequestBody Medico newMedico, @PathVariable(name = "id") Long id) {
		return medicoRepo.findById(id)
			.map(m -> {
				m.setNombres(newMedico.getNombres());
				m.setApellidos(newMedico.getApellidos());
				m.setTelefono(newMedico.getTelefono());
				return medicoRepo.save(m);
			}).orElseGet(() -> {
				newMedico.setId(id);
				return medicoRepo.save(newMedico);
			});
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		medicoRepo.deleteById(id);
	}
	
}
