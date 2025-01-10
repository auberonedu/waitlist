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
    String[] testArr = {"x", "y", "z", "a", "b", "c"};

    Waitlist testWaitlist = new Waitlist(testArr, 8);

    Set<String> toRemove = new HashSet<>();
    toRemove.add("x");
    toRemove.add("z");

    testWaitlist.removeStudents(toRemove);

    String[] expectedArr = {"y", "a", "b", "c", null, null, null, null};

    assertTrue(Arrays.equals(expectedArr, testWaitlist.getWaitlist()));
  }
}