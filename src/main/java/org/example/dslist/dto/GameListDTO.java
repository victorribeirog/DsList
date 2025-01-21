package org.example.dslist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.dslist.entities.GameList;

@NoArgsConstructor
@Getter
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }
}
