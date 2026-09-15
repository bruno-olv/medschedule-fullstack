package com.medschedule.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medschedule.backend.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	//O Spring já injeta aqui métodos como save(), findById(), findAll(), deleteById().
}
