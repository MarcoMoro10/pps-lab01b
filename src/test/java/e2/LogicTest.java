package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
  private Logics logics;
  private final int SIZE = 8;

  @BeforeEach
  void setUp() {
    logics = new LogicsImpl(SIZE);
  }
  @Test
  void testInitialPositions(){
    boolean validKnight = false;
    boolean validPawn = false;
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (logics.hasKnight(row, col)) validKnight = true;
        if (logics.hasPawn(row, col)) validPawn = true;
      }
    }
    assertTrue(validKnight, "The horse must be on the correct position");
    assertTrue(validPawn, "The pawn must be on the correct position");
  }

}
