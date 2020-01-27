package com.kraytech.restdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kraytech.restdemo.repositories.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
