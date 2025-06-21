import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatParameterizedTest {

    @Mock
    Feline feline;

    @ParameterizedTest
    @ValueSource(strings = {"Мясо,Рыба", "Курица,Говядина"})
    public void testGetFood(String food) throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of(food.split(","));

        when(feline.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, cat.getFood());
    }
}