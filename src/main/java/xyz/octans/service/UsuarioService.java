package xyz.octans.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.octans.model.Usuario;
import xyz.octans.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}


	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
		
	}
	
	public <S extends Usuario> S save(S entity) {
		return usuarioRepository.save(entity);
	}
	
	public Usuario findByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

}