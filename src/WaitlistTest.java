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

   // Test removing multiple students from the waitlist
    @Test
    void testRemoveMultipleStudents() {
        Waitlist waitlist = new Waitlist(new String[]{"a", "b", "c", "d", "e"}, 7);
        Set<String> toRemove = new HashSet<>(Arrays.asList("b", "d"));
        waitlist.removeStudents(toRemove);
        // Remaining students should slide to the front, and nulls should fill the end
        assertArrayEquals(new String[]{"a", "c", "e", null, null, null, null}, waitlist.getWaitlist());
    }

    // Test removing a single student from the waitlist
    @Test
    void testRemoveSingleStudent() {
        Waitlist waitlist = new Waitlist(new String[]{"x", "y", "z"}, 5);
        Set<String> toRemove = Set.of("y");
        waitlist.removeStudents(toRemove);
        // Only "y" should be removed
        assertArrayEquals(new String[]{"x", "z", null, null, null}, waitlist.getWaitlist());
    }

    // Test when no students are removed from the waitlist
    @Test
    void testRemoveNoStudents() {
        Waitlist waitlist = new Waitlist(new String[]{"1", "2", "3"}, 5);
        Set<String> toRemove = new HashSet<>(); // Empty set
        waitlist.removeStudents(toRemove);
        // The waitlist should remain unchanged
        assertArrayEquals(new String[]{"1", "2", "3", null, null}, waitlist.getWaitlist());
    }

    // Test removing students when duplicates exist in the waitlist
    @Test
    void testRemoveStudentsWithDuplicates() {
        Waitlist waitlist = new Waitlist(new String[]{"a", "b", "a", "c"}, 6);
        Set<String> toRemove = Set.of("a");
        waitlist.removeStudents(toRemove);
        // All instances of "a" should be removed
        assertArrayEquals(new String[]{"b", "c", null, null, null, null}, waitlist.getWaitlist());
    }

    // Test removing all students from the waitlist
    @Test
    void testRemoveAllStudentsFromArray() {
        Waitlist waitlist = new Waitlist(new String[]{"w", "x", "y", "z"}, 4);
        Set<String> toRemove = Set.of("w", "x", "y", "z");
        waitlist.removeStudents(toRemove);
        // The waitlist should be completely empty (all nulls)
        assertArrayEquals(new String[]{null, null, null, null}, waitlist.getWaitlist());
    }

}