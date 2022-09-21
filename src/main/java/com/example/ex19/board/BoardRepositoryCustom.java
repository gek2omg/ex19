package com.example.ex19.board;

import com.example.ex19.board.api.BoardListApiDto;
import com.example.ex19.board.dto.BoardListDto;
import com.example.ex19.board.dto.BoardSearchDto;
import com.example.ex19.board.dto.BoardViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BoardRepositoryCustom {

    Page<BoardListDto> searchFindAllV1(BoardSearchDto boardSearchDto, Pageable pageable);

    BoardViewDto searchFindOne(Long id);

    List<BoardListApiDto> searchFindAllApiV1(BoardSearchDto boardSearchDto, Pageable pageable);
}
