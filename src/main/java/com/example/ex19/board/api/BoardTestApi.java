package com.example.ex19.board.api;

import com.example.ex19.board.BoardService;
import com.example.ex19.board.dto.BoardViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BoardTestApi {

    private final BoardService boardService;

    @GetMapping("/board/test/api")
    @ResponseBody
    public Result boardTestApi() {

        BoardViewDto board = boardService.testFindById(1L);

        return new Result(board, "SUCCESS", HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private String msg;
        private HttpStatus code;
    }
}
