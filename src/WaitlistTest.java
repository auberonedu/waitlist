import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Set;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 

  @Test
  public void testRemoveStudents() {
    String[] ids = {"s", "a", "k", "c", "r"};
    Waitlist waitlist = new Waitlist(ids, 10);
    Set<String> removeIds = Set.of("a", "v", "c", "r", "s");
    waitlist.removeStudents(removeIds);

    String[] results = {"k", null, null, null, null, null, null, null, null, null};

  assertTrue(Arrays.equals(waitlist.getWaitlist(), results));
  }

  @Test
  public void testRemoveStudents2() {
    String[] ids = {"s", "a", "k", "c", "r"};
    Waitlist waitlist = new Waitlist(ids, 5);
    Set<String> removeIds = Set.of("k");
    waitlist.removeStudents(removeIds);

    String[] results = {"s", "a", "c", "r", null};

  assertTrue(Arrays.equals(waitlist.getWaitlist(), results));
  }

  @Test
  public void testRemoveStudents3() {
    String[] ids = {"s", "a", "k", "c", "r"};
    Waitlist waitlist = new Waitlist(ids, 6);
    Set<String> removeIds = Set.of("v");
    waitlist.removeStudents(removeIds);

    String[] results = {"s", "a", "k", "c", "r", null};

  assertTrue(Arrays.equals(waitlist.getWaitlist(), results));
  }
}