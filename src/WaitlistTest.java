import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WaitlistTest {

  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create
  // an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals
  // instance method or ==
  // java.util.Arrays is imported for you at the top of this file.
  @Test
  void testRemoveStudents() {
    String[] testArr = { "x", "y", "z", "a", "b", "c" };

    Waitlist testWaitlist = new Waitlist(testArr, 8);

    Set<String> toRemove = new HashSet<>();
    toRemove.add("x");
    toRemove.add("z");

    testWaitlist.removeStudents(toRemove);

    String[] expectedArr = { "y", "a", "b", "c", null, null, null, null };

    assertTrue(Arrays.equals(expectedArr, testWaitlist.getWaitlist()));
  }

  @Test
  void testRemoveStudentsWithNumbers() {
    Waitlist list = new Waitlist(new String[] { "m", "2", "x", "z", "67", "a", "25", "2" }, 8);
    Set<String> set = new HashSet<>();
    set.add("25");
    set.add("67");
    list.removeStudents(set);

    assertArrayEquals(new String[] { "m", "2", "x", "z", "a", "2", null, null }, list.getWaitlist());
  }

  @Test
  void testRemoveAllStudents() {
    Waitlist list = new Waitlist(new String[] { "a", "b", "c", "d" }, 4);
    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("b");
    set.add("c");
    set.add("d");
    list.removeStudents(set);

    assertArrayEquals(new String[] { null, null, null, null }, list.getWaitlist());
  }

  @Test
  void testRemoveStudentsWithEmptySet() {
    Waitlist list = new Waitlist(new String[] {"z", "x", "y"}, 3);
    Set<String> set = new HashSet<>();

    assertThrows(IllegalArgumentException.class, () -> list.removeStudents(set));
  }

  @Test
  void testRemoveStudentsWithNullSet() {
    Waitlist list = new Waitlist(new String[] {"z", "x", "y"}, 3);

    assertThrows(NullPointerException.class, () -> list.removeStudents(null));
  }

  @Test
  void testRemoveStudentsWithEmptyArray() {
    Waitlist list = new Waitlist(new String[] {}, 0);
    Set<String> set = new HashSet<>();
    set.add("a");

    assertThrows(IllegalArgumentException.class, () -> list.removeStudents(set));
  }

  @Test
  void testRemoveStudentsWithNullArray() {
    assertThrows(NullPointerException.class, () -> new Waitlist(null, 0));
  }
}