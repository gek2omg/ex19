package com.example.ex19.board;

import com.example.ex19.board.api.BoardListApiDto;
import com.example.ex19.board.dto.*;
import com.example.ex19.board.entity.Board;
import com.example.ex19.member.MemberRepository;
import com.example.ex19.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public void saveBoardV1(BoardSaveDto boardSaveDto) {

        Long memberId = 1L; // 회원 시퀀스 임시 적용(세션, 쿠키, OAuth2.0 키로 대응)

        Member member = null;

        try {
            member = memberRepository.findById(memberId).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Board board = Board.saveBoard(member, boardSaveDto);

        // 순수 JPA 사용
        boardRepository.save(board);
    }


    @Transactional(readOnly = true)
    public Page<BoardListDto> searchFindAllV1(BoardSearchDto boardSearchDto, Pageable pageable) {


        return boardRepository.searchFindAllV1(boardSearchDto, pageable);
    }


    @Transactional(readOnly = true)
    public List<BoardListApiDto> searchFindAllApiV1(BoardSearchDto boardSearchDto, Pageable pageable) {

        return boardRepository.searchFindAllApiV1(boardSearchDto, pageable);
    }


    public BoardViewDto searchFindOne(Long id) {

        return boardRepository.searchFindOne(id);
    }


    public Board searchFindId(Long id) {

        // 순수 JPA 사용
        Board board = boardRepository.findById(id).get();

        return board;
    }


    @Transactional
    public void updateBoardV1(BoardUpdateDto boardUpdateDto) {

        Long memberId = 1L; // 회원 시퀀스 임시 적용(세션, 쿠키, OAuth2.0 키로 대응)

        Member member = null;

        try {
            member = memberRepository.findById(memberId).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // board id 가 있는 경우 JPA 에서 자동으로 업데이트 진행
        Board board = new Board();

        board.setId(boardUpdateDto.getId());
        board.setTitle(boardUpdateDto.getTitle());
        board.setContent(boardUpdateDto.getContent());
//        board.setMember(member);

        // 순수 JPA 사용
        boardRepository.save(board);
    }


    @Transactional
    public String updateBoardV2(BoardUpdateDto boardUpdateDto) {

        Long memberId = 1L;

        Member member = null;
        Board board = null;

        try {
            member = memberRepository.findById(memberId).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            board = boardRepository.findById(boardUpdateDto.getId()).orElse(null);

            board.setTitle(boardUpdateDto.getTitle());
            board.setContent(boardUpdateDto.getContent());

            return "SUCCESS";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Board findById(long id) {

        Board board = boardRepository.findById(id).get();

        return board;
    }

    public BoardViewDto testFindById(long id) {

        BoardViewDto board = null;

        board = boardRepository.searchFindOne(id);

        return board;
    }
}
