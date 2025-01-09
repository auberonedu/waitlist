import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WaitlistTest {
  
  // DONE: Implement tests for removeStudents

  // Test 1: Removing the specific students
  @Test
  void testRemoveSpecificStudents() {
    Waitlist waitlist = new Waitlist(new String[]{"x", "r", "q", "m", "v", null, null}, 7);
    waitlist.removeStudents(new HashSet<>(Set.of("r", "m")));
    assertArrayEquals(new String[]{"x", "q", "v", null, null, null, null}, waitlist.getWaitlist());
  }

  // Test 2: Not removing any students 
  @Test
  void testNotRemovingAnyStudents() {
    Waitlist waitlist = new Waitlist(new String[]{"a", "b", "c", "d", "e", null, null}, 7);
    waitlist.removeStudents(new HashSet<>());
    assertArrayEquals(new String[]{"a", "b", "c", "d", "e", null, null}, waitlist.getWaitlist());
  }

  // Test 3: Removing all the students
  @Test
  void testRemoveAllStudents() {
    Waitlist waitlist = new Waitlist(new String[]{"z", "b", "a", "w", "q", null, null}, 7);
    waitlist.removeStudents(new HashSet<>(Set.of("z", "b", "a", "w", "q")));
    assertArrayEquals(new String[]{null, null, null, null, null, null, null}, waitlist.getWaitlist());

  }

  // Test 4: Trying to remove elements from an Empty Students Array
  @Test 
  void testNoStudentsArray() {
    Waitlist waitlist = new Waitlist(new String[]{null, null, null, null, null}, 5);
    waitlist.removeStudents(new HashSet<>(Set.of("a", "b")));
    assertArrayEquals(new String[]{null, null, null, null, null}, waitlist.getWaitlist());
  }

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  // java.util.Arrays is imported for you at the top of this file. 
}