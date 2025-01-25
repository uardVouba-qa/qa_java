import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParametrizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[] getDataKittensCount() {
        return new Object[][]{
                {1, 1},
                {3, 3},
                {5, 5},
        };
    }

    @Test
    public void getKittensCountReturns() {
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}