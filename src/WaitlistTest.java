import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
  
  @Test
  public void testRemoveStudents_typicalCase() {
    String[] initialStudents = {"x", "r", "q", "m", "v", null, null};
    int capacity = 7;
    Waitlist myWaitlist = new Waitlist(initialStudents, capacity);

    Set<String> toRemove = new HashSet<>(Arrays.asList("r", "m"));

    myWaitlist.removeStudents(toRemove);

    String[] expectedWaitlist = {"x", "q", "v", null, null, null, null};
    assertArrayEquals(expectedWaitlist, myWaitlist.getWaitlist());
  }

  @Test
  public void testRemoveStudents_emptySet() {
    String[] initialStudents = {"a", "b", "c", null, null};
    int capacity = 5;
    Waitlist waitlist = new Waitlist(initialStudents, capacity);

    Set<String> toRemove = new HashSet<>();

    waitlist.removeStudents(toRemove);

    String[] expectedWaitlist = {"a", "b", "c", null, null};
    assertArrayEquals(expectedWaitlist, waitlist.getWaitlist());
  }
}