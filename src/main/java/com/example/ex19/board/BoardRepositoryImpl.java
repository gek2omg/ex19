package com.example.ex19.board;

import com.example.ex19.board.dto.BoardListDto;
import com.example.ex19.board.dto.BoardSearchDto;
import com.example.ex19.board.dto.QBoardListDto;
import com.example.ex19.board.entity.Board;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.ex19.board.entity.QBoard.board;
import static com.example.ex19.member.entity.QMember.member;
import static org.springframework.util.StringUtils.hasText;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(EntityManager em) {

        this.jpaQueryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<BoardListDto> searchFindAllV1(BoardSearchDto boardSearchDto, Pageable pageable) {

        List<BoardListDto> content = jpaQueryFactory
                .select(new QBoardListDto(
                        board.id,
                        board.title,
                        member.name
                ))
                .from(board)
                .leftJoin(board.member, member)
                .where(
                        searchFindAllV1Predicate(boardSearchDto)
                )
                .orderBy(board.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = jpaQueryFactory
                .select(board.count())
                .from(board)
                .leftJoin(board.member, member)
                .where(
                        searchFindAllV1Predicate(boardSearchDto)
                )
                .fetch().get(0);

        return new PageImpl<>(content, pageable, total);
    }


    private BooleanBuilder searchFindAllV1Predicate(BoardSearchDto boardSearchDto) {

        return new BooleanBuilder()
                .and(condTitle(boardSearchDto.getTitle()))
                .and(condContent(boardSearchDto.getContent()));
    }


    private Predicate condTitle(String title) {
        BooleanBuilder builder = new BooleanBuilder();
        if (hasText(title)) {
            builder.and(board.title.like("%" + title + "%"));
        }

        return builder;
    }

    private Predicate condContent(String content) {
        BooleanBuilder builder = new BooleanBuilder();
        if (hasText(content)) {
            builder.or(board.content.like("%" + content + "%"));
        }

        return builder;
    }




}
