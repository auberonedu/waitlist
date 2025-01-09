import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.*;


public class WaitlistTest {
  String[] students = {"k", "h", "b", "r", "l"};
  Waitlist test = new Waitlist(students, 6);

  
  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
  @Test
  void removeOneStudent(){
    Waitlist test = new Waitlist(students, 6);
    String[] expectedStudents = {"k", "h", "r", "l", "null"};
    Set<String> set = new HashSet<>();
    set.add("b");
    test.removeStudents(set);
    assertArrayEquals(expectedStudents, test.getWaitlist());
  }
}