package com.example.ex19.member.entity;

import com.example.ex19.board.entity.Board;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = true, length = 13)
    private String jumin;

    private String address;

    @OneToMany(mappedBy = "member")
    @Column(nullable = true)
    @JsonManagedReference
    private List<Board> boards = new ArrayList<>();
}
