package zup.orangetalents.loterrychallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zup.orangetalents.loterrychallenge.dto.PlayerDTO;
import zup.orangetalents.loterrychallenge.services.PlayerService;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> findAll() {
		List<PlayerDTO> list = playerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlayerDTO> findById(@PathVariable Long id) {
		PlayerDTO dto = playerService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<PlayerDTO> findBetByEmail(@PathVariable String email) {
		PlayerDTO dto = playerService.findByEmail(email);
		return ResponseEntity.ok().body(dto);
	}
	
}
