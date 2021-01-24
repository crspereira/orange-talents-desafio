package zup.orangetalents.loterrychallenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zup.orangetalents.loterrychallenge.dto.PlayerDTO;
import zup.orangetalents.loterrychallenge.dto.PlayerUpdateDTO;
import zup.orangetalents.loterrychallenge.entities.Player;
import zup.orangetalents.loterrychallenge.repositories.PlayerRepository;
import zup.orangetalents.loterrychallenge.services.exceptions.ControllerNotFoundException;

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
		Player entity = obj.orElseThrow(() -> new ControllerNotFoundException("Entity Not Found!"));
		return new PlayerDTO(entity);
	}
	
	@Transactional
	public PlayerUpdateDTO update(Long id, PlayerUpdateDTO dto) {
		try {
			Player entity = playerRepository.getOne(id); //instance just doesn't touch the database
			entity.setEmail(dto.getEmail()); //datas update only into memory
			entity = playerRepository.save(entity);
			return new PlayerUpdateDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Id Not Found " + id);
		}
	}
}
