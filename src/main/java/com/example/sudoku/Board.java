package com.example.sudoku;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Board {

    private final String[] boardLines;

    public Board(String... boardLines) {
        this.boardLines = boardLines;
    }
}
