import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WaitlistTest {

  String[] studentIds = {"x", "r", "q", "m", "v", null, null};
  String[] studentIdsFullList = {"a", "b", "c"};
  int capacity = 7;
  int capacityThree = 3;
  
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

  @Test
  void removeStudentsConsecutive() {
    Set<String> removeSet = new HashSet<>(Set.of("r","q"));
    Waitlist testWaitlist = new Waitlist(studentIds, capacity);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {"x", "m", "v", null, null, null, null};
    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  }

  @Test
  void removeStudentsFirst() {
    Set<String> removeSet = new HashSet<>(Set.of("x"));
    Waitlist testWaitlist = new Waitlist(studentIds, capacity);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {"r", "q", "m", "v", null, null, null};
    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  }

  @Test
  void removeStudentsLast() {
    Set<String> removeSet = new HashSet<>(Set.of("c"));
    Waitlist testWaitlist = new Waitlist(studentIdsFullList, capacityThree);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {"a", "b", null};
    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  }

  @Test
  void removeStudentsAll() {
    Set<String> removeSet = new HashSet<>(Set.of("x", "r", "q", "m", "v"));
    Waitlist testWaitlist = new Waitlist(studentIds, capacity);
    testWaitlist.removeStudents(removeSet);

    String[] expectedArray = {null, null, null, null, null, null, null};
    assertTrue(Arrays.equals(expectedArray, testWaitlist.getWaitlist()));
  }

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
}