import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final String sex;
    private final Feline feline;
    private final boolean expectedHasMane;

    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[] getDataHasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getHaveManeReturns() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }
}
