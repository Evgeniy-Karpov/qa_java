import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;


    @Test
    public void getKittensShouldCallFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeShouldReturnTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeShouldReturnFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFoodShouldCallEatMeat() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);

        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(feline).getFood("Хищник");
    }

    @Test
    public void ShouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Неизвестный", feline));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }


}