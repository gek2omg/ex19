package com.example.ex19.board;

import com.example.ex19.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends
        JpaRepository<Board, Long>,
        JpaSpecificationExecutor<Board>,
        QuerydslPredicateExecutor<Board>,
        BoardRepositoryCustom {


}
