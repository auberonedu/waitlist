import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 

  @Test
  void testRemoveStudents() {
      String[] initialIds = {"x", "y", "z", "a", "b"};
      Waitlist waitlist = new Waitlist(initialIds, 7);

      Set<String> toRemove = new HashSet<>(Set.of("y", "a"));

      waitlist.removeStudents(toRemove);

      assertArrayEquals(new String[]{"x", "z", "b", null, null, null, null}, waitlist.getWaitlist());
  }

  @Test
    void testRemoveStudentsNoMatch() {
        String[] initialIds = {"p", "q", "r"};
        Waitlist waitlist = new Waitlist(initialIds, 5);

        Set<String> toRemove = new HashSet<>(Set.of("x", "y", "z"));

        waitlist.removeStudents(toRemove);

        assertArrayEquals(new String[]{"p", "q", "r", null, null}, waitlist.getWaitlist());
    }
}