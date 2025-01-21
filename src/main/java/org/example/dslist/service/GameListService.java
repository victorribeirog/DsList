package org.example.dslist.service;

import org.example.dslist.dto.GameListDTO;
import org.example.dslist.dto.GameMinDTO;
import org.example.dslist.entities.Game;
import org.example.dslist.entities.GameList;
import org.example.dslist.repository.GameListRepository;
import org.example.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
