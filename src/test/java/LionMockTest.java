import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionMockTest {

    @Mock
    Feline feline = new Feline();

    @Test
    public void getKittensReturnsForLion() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedEatMeat);
        List<String> actualEatMeat = lion.getFood();
        Assert.assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test
    public void doesHaveManeException() {
        String exceptionLion = "Оно";
        Exception exception = Assert.assertThrows("Исключение", Exception.class, () -> new Lion(exceptionLion, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}