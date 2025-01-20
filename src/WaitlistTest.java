import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WaitlistTest {
  String[] studentId = {"x", "r", "q", "m", "v", null, null};

     private Waitlist waitlist;

    @BeforeEach
    public void setUp() {
     
        waitlist = new Waitlist(new String[]{"x", "r", "q", "m", "v", null, null}, 7);
    }

    @Test
    public void testRemoveSomeStudents() {
        Set<String> remove = new HashSet<>();
        remove.add("r");
        remove.add("m");

        waitlist.removeStudents(remove);

        // After removal, the array should contain ["a", "c", "e", null, null]
        assertArrayEquals(new String[]{"x", "q", "v", null, null, null, null}, waitlist.getWaitlist());
    }

  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
}