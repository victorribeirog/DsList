package org.example.dslist.service;

import org.example.dslist.dto.GameMinDTO;
import org.example.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
