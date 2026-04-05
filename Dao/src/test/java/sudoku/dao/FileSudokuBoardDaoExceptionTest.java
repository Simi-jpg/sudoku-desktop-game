package sudoku.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import sudoku.dao.exceptions.SudokuReadException;
import sudoku.dao.models.FileSudokuBoardDao;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoExceptionTest {

    @TempDir
    Path tempDir;

    @Test
    void shouldThrowSudokuReadExceptionWhenFileDoesNotExist() {
        FileSudokuBoardDao dao = new FileSudokuBoardDao(tempDir.toString());

        SudokuReadException ex = assertThrows(
                SudokuReadException.class,
                () -> dao.read("missing-board.ser")
        );

        assertTrue(ex.getMessage().contains("missing-board.ser"));
        assertNotNull(ex.getCause());
    }
}