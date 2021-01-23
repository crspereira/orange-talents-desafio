package zup.orangetalents.loterrychallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zup.orangetalents.loterrychallenge.dto.PlayerDTO;
import zup.orangetalents.loterrychallenge.entities.Player;
import zup.orangetalents.loterrychallenge.repositories.PlayerRepository;
import zup.orangetalents.loterrychallenge.services.exceptions.EntityNotFoundException;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Transactional(readOnly = true)
	public List<PlayerDTO> findAll() {
		List<Player> list = playerRepository.findPlayerWithBets();
		return list.stream().map(x -> new PlayerDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PlayerDTO findById(Long id) {
		Optional<Player> obj = playerRepository.findById(id);
		Player entity = obj.get();
		return new PlayerDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public PlayerDTO findByEmail(String email) {
		Optional<Player> obj = Optional.ofNullable(playerRepository.findByEmail(email));
		Player entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity Not Found!"));
		return new PlayerDTO(entity);
	}
	
	
	
}
