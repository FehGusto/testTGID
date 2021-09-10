package com.tgid.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgid.teste.model.Usuario;

@Repository
public interface usuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmailUsuario(String emailUsuario);

}
