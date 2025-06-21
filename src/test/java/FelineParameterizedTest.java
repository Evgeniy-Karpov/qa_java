import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class FelineParameterizedTest {

    private final Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
    public void getKittensShouldReturnSameValueAsInput(int kittensCount) {
        int result = feline.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }
}