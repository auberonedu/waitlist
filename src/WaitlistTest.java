import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents
@Test
void testWaitlist(){
  String[] StudentIds = {"String1", "String 2", "String 3", "string4"};
  Waitlist testing = new Waitlist(StudentIds, 7);

  Set<String> toRemove = new HashSet<>();
  toRemove.add("String3");
  toRemove.add("String1");
  testing.removeStudents(toRemove);
  
  
  String[] expected = {"String5", "String4", null, null, null, null, null};

  testing.getWaitlist();
  Arrays.equals(expected , testing.getWaitlist());
}
  

  
  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 
}