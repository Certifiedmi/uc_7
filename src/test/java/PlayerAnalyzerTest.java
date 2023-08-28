import org.junit.Test;
import org.uc_7.model.Player;
import org.uc_7.service.PlayerAnalyzer;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PlayerAnalyzerTest {

    double score;

    private static final Player JUNIOR_PLAYER = new Player("Sam", 15, 3, List.of(3, 3, 3));
    private static final Player SENIOR_PLAYER = new Player("Lua", 35, 15, List.of(4, 4, 4));

    @Test
    public void testNormalScore() {
        score = new PlayerAnalyzer().calculateScore(List.of(new Player("Dan", 25, 5, List.of(2, 2, 2))));
        assertEquals(250.0, score);
    }

    @Test
    public void testJuniorPlayer() {
        score = new PlayerAnalyzer().calculateScore(List.of(JUNIOR_PLAYER));
        assertEquals(67.5, score);
    }

    @Test
    public void testSeniorPlayer() {
        score = new PlayerAnalyzer().calculateScore(List.of(SENIOR_PLAYER));
        assertEquals(2520.0, score);
    }

    @Test
    public void testMultiplePlayers() {
        score = new PlayerAnalyzer().calculateScore(List.of(SENIOR_PLAYER, JUNIOR_PLAYER));
        assertEquals(2520.0 + 67.5, score);
    }

    @Test(expected = Exception.class)
    public void testSkillsIsNullValue() {
        new PlayerAnalyzer().calculateScore(List.of(new Player("Dan", 13, 0, null)));
    }

    @Test()
    public void testSkillsIsZeroValue() {
        score = new PlayerAnalyzer().calculateScore(List.of(new Player("Dan", 13, 0, List.of(0, 0, 0))));
        assertEquals(0.0, score);
    }
}
