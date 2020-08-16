package feature.tests;

import com.example.sudoku.Board;
import com.example.sudoku.SudokuSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SudokuFeatureTest {

    private SudokuSolver sudokuSolver;

    @BeforeEach
    void setUp() {
        sudokuSolver = new SudokuSolver();
    }

    @Test
    void solve_sudoku() {
        // given
        Board unsolvedBoard = new Board(
                " - - - | 2 6 - | 7 - 1 ",
                " 6 8 - | - 7 - | - 9 - ",
                " 1 9 - | - - 4 | 5 - - ",
                " --------------------- ",
                " 8 2 - | 1 - - | - 4 - ",
                " - - 4 | 6 - 2 | 9 - - ",
                " - 5 - | - - 3 | - 2 8 ",
                " --------------------- ",
                " - - 9 | 3 - - | - 7 4 ",
                " - 4 - | - 5 - | - 3 6 ",
                " 7 - 3 | - 1 8 | - - - "
        );

        // when
        Set<Board> solutions = sudokuSolver.solve(unsolvedBoard);

        // then
        assertThat(solutions).contains(new Board(
                " 4 3 5 | 2 6 9 | 7 8 1 ",
                " 6 8 2 | 5 7 1 | 4 9 3 ",
                " 1 9 7 | 8 3 4 | 5 6 2 ",
                " --------------------- ",
                " 8 2 6 | 1 9 5 | 3 4 7 ",
                " 3 7 4 | 6 8 2 | 9 1 5 ",
                " 9 5 1 | 7 4 3 | 6 2 8 ",
                " --------------------- ",
                " 5 1 9 | 3 2 6 | 8 7 4 ",
                " 2 4 8 | 9 5 7 | 1 3 6 ",
                " 7 6 3 | 4 1 8 | 2 5 9 "
        ));
    }

    @Test
    void solve_board_with_many_solutions() {
        // given
        Board unsolvedBoard = new Board(
                " - - | - - ",
                " - - | - - ",
                " --------- ",
                " - - | - - ",
                " - - | - - "
        );

        // when
        Set<Board> solutions = sudokuSolver.solve(unsolvedBoard);

        // then
        assertThat(solutions).hasSize(288);

        assertThat(solutions).contains(new Board(
                " 1 2 | 3 4 ",
                " 3 4 | 1 2 ",
                " --------- ",
                " 2 1 | 4 3 ",
                " 4 3 | 2 1 "
        ), new Board(
                " 3 4 | 1 2 ",
                " 1 2 | 3 4 ",
                " --------- ",
                " 2 1 | 4 3 ",
                " 4 3 | 2 1 "
        ));
    }
}
