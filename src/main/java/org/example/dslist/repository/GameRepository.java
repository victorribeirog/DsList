package org.example.dslist.repository;

import org.example.dslist.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Games,Long> {

}
