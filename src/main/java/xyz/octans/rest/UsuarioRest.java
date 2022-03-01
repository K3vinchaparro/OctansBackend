package xyz.octans.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.octans.model.Usuario;
import xyz.octans.service.UsuarioService;


@RestController 
@RequestMapping("/usuario/")
public class UsuarioRest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsuarios(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	
	@PostMapping
	private boolean saveUsuario(@RequestBody Usuario usuario){
				try {
					if(usuarioService.findByNombreUsuario(usuario.getNombreUsuario())!=null) {
						return false;
					}else {
						Usuario usuarioGuardado = usuarioService.save(usuario);
						ResponseEntity.created(new URI("/Usuario/"+usuarioGuardado.getId())).body(usuarioGuardado);
						return true;
					}
				} catch (Exception e) {
					ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
					return false;
				}
			}
	
	
	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<Boolean> deleteUsuario (@PathVariable ("id") Long id){
		usuarioService.deleteById(id);
		return ResponseEntity.ok(!(usuarioService.findById(id)!=null));
	}	

}
