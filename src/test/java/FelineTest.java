import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Mock
    private Animal animalMock;

    @InjectMocks
    private Feline feline;

    @Test
    public void eatMeatShouldReturnThreeFoodItems() throws Exception {

        List<String> result = feline.eatMeat();

        assertEquals(3, result.size(), "Должно вернуть 3 вида еды для хищника");
    }

    @Test
    public void getFamilyShouldReturnFelidae() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithDefaultCountShouldReturn1() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithCustomCountShouldReturnSameValue() {
        int expectedCount = 5;
        assertEquals(expectedCount, feline.getKittens(expectedCount));
    }


}