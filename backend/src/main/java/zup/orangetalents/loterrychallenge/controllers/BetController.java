package zup.orangetalents.loterrychallenge.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import zup.orangetalents.loterrychallenge.dto.BetDTO;
import zup.orangetalents.loterrychallenge.dto.BetInsertEmailDTO;
import zup.orangetalents.loterrychallenge.services.BetService;

@RestController
@RequestMapping(value = "/bets")
public class BetController {

	@Autowired
	private BetService betService;
	
	@GetMapping
	public ResponseEntity<List<BetDTO>> findAll() {
		List<BetDTO> list = betService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BetDTO> findById(@PathVariable Long id) {
		BetDTO dto = betService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	 @PostMapping
	 public ResponseEntity<BetDTO> insert(@Valid @RequestBody BetInsertEmailDTO obj) {
		 BetDTO dto = betService.insert(obj);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(dto.getId()).toUri();
	     return ResponseEntity.created(uri).body(dto);
	 }
	 
}
