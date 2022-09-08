package com.example.ex19.board;

import com.example.ex19.board.dto.BoardSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String boardHome() {

        return "redirect:/boardCreate";
    }


    @GetMapping("/boardCreate")
    public String boardCreate(Model model, BoardSaveDto boardSaveDto) {

        model.addAttribute("boardSaveDto", boardSaveDto);

        return "boardCreate";
    }


    @PostMapping("/boardCreate")
    public String boardCreateProc(@ModelAttribute BoardSaveDto boardSaveDto) {

        boardService.saveBoardV1(boardSaveDto);

        return "redirect:/boardCreate";
    }
}
