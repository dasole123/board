package com.myboard.board.repository;

import com.myboard.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
  List<Board> findAllByOrderByModifiedAtDesc();

}
