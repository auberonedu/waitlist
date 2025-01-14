import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents
@Test
void testWaitlist(){
  //copy paste 
  // Test 1
  String[] StudentIds = {"x", "r", "q", "m", "v", null, null};
  Waitlist testing = new Waitlist(StudentIds, 7);

  Set<String> toRemove = new HashSet<>();
  toRemove.add("r");
  toRemove.add("m");
  toRemove.add("q");
  
  testing.removeStudents(toRemove);
  
  String[] expected = {"x", "v", null , null, null, null, null};
  testing.removeStudents(toRemove);
  System.out.println(testing.toString());
  assertArrayEquals(expected, testing.getWaitlist());

  }

  @Test
  void testWaitlist2(){
    // Test 2
    String[] StudentIds = {"x", "r", "q", "m", "v", null, null};
    Waitlist testing = new Waitlist(StudentIds, 7);
  
    Set<String> toRemove = new HashSet<>();
    
    toRemove.add("x");
    toRemove.add("r");
    toRemove.add("q");
    toRemove.add("m");
    toRemove.add("v");

    testing.removeStudents(toRemove);
  
    String[] expected = {null, null, null, null, null, null, null};
  
    assertArrayEquals(expected, testing.getWaitlist());
  
    }
  
  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
}

