package org.example.dslist.service;

import org.example.dslist.dto.GameListDTO;
import org.example.dslist.dto.GameMinDTO;
import org.example.dslist.entities.Game;
import org.example.dslist.entities.GameList;
import org.example.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        var result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

         GameMinProjection obj = list.remove(sourceIndex);
         list.add(destinationIndex, obj);

         int min = Math.min(sourceIndex, destinationIndex);
         int max = Math.max(sourceIndex, destinationIndex);

         for(int i = min; i <= max; i++){
             gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
         }
    }
}
