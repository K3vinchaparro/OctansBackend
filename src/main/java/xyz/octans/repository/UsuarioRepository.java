package xyz.octans.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.octans.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//@Query(value = "SELECT u FROM usuario u WHERE u.nombre_usuario = ?1", nativeQuery = true)
	public Usuario findByNombreUsuario(String nombreUsuario);
}
