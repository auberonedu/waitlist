import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WaitlistTest {

    @Test
    public void removeTest() {
        String[] studentIds = {"s1", "s2", "s3", "s4"};
        Waitlist list = new Waitlist(studentIds, 4);

        Set<String> removeId = new HashSet<>();
        removeId.add("s2");

        list.removeStudents(removeId);
        String[] result = {"s1", "s3", "s4", null};

        assertArrayEquals(result, list.getWaitlist());
    }
}
