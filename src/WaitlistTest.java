import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WaitlistTest {

  String[] studentIds = {"x", "r", "q", "m", "v", null, null};
  int capacity = 7;
  
  @Test
  void removeStudentsBasic() {
    Set<String> removeSet = new HashSet<>(Set.of("r", "m"));
    Waitlist testWaitlist = new Waitlist(studentIds, capacity);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {"x", "q", "v", null, null, null, null};

    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  } 

  @Test
  void removeStudentsNoneToRemove() {
    Set<String> removeSet = new HashSet<>(Set.of());
    Waitlist testWaitlist = new Waitlist(studentIds, capacity);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {"x", "r", "q", "m", "v", null, null};
    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  }

  // TODO: test for id to remove next to each other 
  // toRemove = {"r", "q"}

  // TODO: test for removing first id
  // toRemove = {"x"}

  // TODO: test for removing last id
  // studentIds = {a, b, c} toRemove = {c}

  // TODO: test for removing all ids
  // toRemove = {"x", "r", "q", "m", "v"}

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
}