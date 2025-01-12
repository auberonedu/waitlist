import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file.
  
  @Test
  public void testRemoveAllStudents() {
    String[] initialIds = {"x", "r", "q", "m", "v"};
    Waitlist waitlist = new Waitlist(initialIds, 7);

    // Case 1: Remove some students
    waitlist.removeStudents(new HashSet<>(Arrays.asList("r", "m")));
    String[] expected = {"x", "q", "v", null, null, null, null};
    assertArrayEquals(expected, waitlist.getWaitlist());

    // Case 2: Remove a student not in the list
    waitlist.removeStudents(new HashSet<>(Arrays.asList("z")));
    assertArrayEquals(expected, waitlist.getWaitlist());

    // Case 3: Remove all students
    waitlist.removeStudents(new HashSet<>(Arrays.asList("x", "q", "v")));
    String[] expectedEmpty = {null, null, null, null, null, null, null};
    assertArrayEquals(expectedEmpty, waitlist.getWaitlist());

    // Case 4: Remove from all already empty waitlist
  }

  // Testing to see if the program doesn't have to remove any students.
  @Test
  public void testToRemoveNoStudent() {
    String[] initialIds = {"x", "r", "q", "m", "v"};
    Waitlist waitlist = new Waitlist(initialIds, 7);

    waitlist.removeStudents(new HashSet<>());
    String[] expected = {"x", "r", "q", "m", "v", null, null};
    assertArrayEquals(expected, waitlist.getWaitlist());
  }

  // Testing to see if there are duplicate studentId's
  @Test
  public void testDuplicateStudentIds() {
    String[] initialIds = {"x", "r", "q", "m", "v"};
    Waitlist waitlist = new Waitlist(initialIds, 7);

    waitlist.removeStudents(new HashSet<>(Arrays.asList("r", "r")));
    String[] expected = {"x", "q", "m", "v", null, null, null};
    assertArrayEquals(expected, waitlist.getWaitlist());
  }

}