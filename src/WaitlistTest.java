import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
    String[] students = { "Huma", "Brian", "Smith", "John", "Elizabeth", null, null };
    Waitlist waitlist = new Waitlist(students, 7);

    Set<String> toRemove = new HashSet<>();
    toRemove.add("Smith");
    toRemove.add("John");

    waitlist.removeStudents(toRemove);

    String[] expectedWaitlist = { "Huma", "Brian", "Elizabeth", null, null, null, null };
    assertArrayEquals(expectedWaitlist, waitlist.getWaitlist());
  }

  @Test
  void testRemoveStudents2() {
    String[] students = { "Maxwell", null, "Joe", null, "Obama", "Barbara", "Elizabeth", "Truman", null, null };
    Waitlist waitlist = new Waitlist(students, 10);

    Set<String> toRemove = new HashSet<>();
    toRemove.add("Barbara");
    toRemove.add("Elizabeth");
    toRemove.add("Truman");

    waitlist.removeStudents(toRemove);

    String[] expectedWaitlist = { "Maxwell", "Joe", "Obama", null, null, null, null, null, null, null };
    assertArrayEquals(expectedWaitlist, waitlist.getWaitlist());
  }

  @Test
  void testRemoveStudents3() {
    String[] students = { null, null, "Joe"};
    Waitlist waitlist = new Waitlist(students, 4);

    Set<String> toRemove = new HashSet<>();
    toRemove.add(null);

    waitlist.removeStudents(toRemove);

    String[] expectedWaitlist = { "Joe", null, null, null };
    assertArrayEquals(expectedWaitlist, waitlist.getWaitlist());
  }
}