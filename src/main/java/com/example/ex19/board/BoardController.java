package com.example.ex19.board;

import com.example.ex19.board.dto.BoardListDto;
import com.example.ex19.board.dto.BoardSaveDto;
import com.example.ex19.board.dto.BoardSearchDto;
import com.example.ex19.member.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/boardCreate")
    public String boardCreate(Model model, BoardSaveDto boardSaveDto) {

        model.addAttribute("boardSaveDto", boardSaveDto);

        return "boardCreate";
    }


    @PostMapping("/boardCreate")
    public String boardCreateProc(@Validated @ModelAttribute BoardSaveDto boardSaveDto,
                                  BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "boardCreate";
        }

        boardService.saveBoardV1(boardSaveDto);

        return "redirect:/boardList";
    }


    @GetMapping("/boardList")
    public String boardList(BoardSearchDto boardSearchDto,
                            @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size,
                            Model model) throws Exception {

        PageRequest pageable = PageRequest.of(page.isPresent() ? page.get() : 0, size.isPresent() ? size.get() : 10);
        Page<BoardListDto> boards = boardService.searchFindAllV1(boardSearchDto, pageable);

        // 총페이지 보다 많은 페이지를 요청한 경우
        if(pageable.getPageNumber() > boards.getTotalPages()) {
            model.addAttribute("alertMsg", "요청하신 페이지번호는 없습니다.");
            model.addAttribute("redirectUrl", "/board/notice/list");
            return "error/alert";
        }

        // 게시물 카운터
        long TotalElements = boards.getTotalElements();
        // 게시물 순번, ID 번호 아님
        long TotalNum = TotalElements - (long) boards.getNumber() * boards.getSize();

        model.addAttribute("lists", boards);
        model.addAttribute("TotalNum", TotalNum);
        model.addAttribute("TotalElements", TotalElements);

        // sql where 절을 보통 condition 이라고 통일하는것 같음
        model.addAttribute("BoardSearchDto", boardSearchDto);
        model.addAttribute("maxPage", 10);

        return "boardlist";


    }
}
