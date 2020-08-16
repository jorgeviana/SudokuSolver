package com.example.sudoku;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuSolverTest {

    @Test
    void should_solve_solved_board() {
        Board board = new Board(
                " 1 2 | 3 4 ",
                " 3 4 | 1 2 ",
                " --------- ",
                " 2 1 | 4 3 ",
                " 4 3 | 2 1 "
        );

        Set<Board> solutions = new SudokuSolver().solve(board);

        assertThat(solutions).containsExactly(board);
    }
}