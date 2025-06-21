import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlexLionTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetFriends() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertEquals(0, alex.getKittens());
        verify(feline, never()).getKittens();
    }

    @Test
    public void testAlexIsMale() throws Exception {
        AlexLion alex = new AlexLion(feline);
        assertTrue(alex.doesHaveMane());
    }
}