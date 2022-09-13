package com.example.ex19.board;

import com.example.ex19.board.dto.BoardListDto;
import com.example.ex19.board.dto.BoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardRepositoryCustom {

    Page<BoardListDto> searchFindAllV1(BoardSearchDto boardSearchDto, Pageable pageable);


}
