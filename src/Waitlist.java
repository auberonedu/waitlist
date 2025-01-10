import java.util.Arrays;
import java.util.Set;

public class Waitlist {
  private String[] studentIds;

  /**
   * Creates a waitlist with the given student IDs and capacity.
   * 
   * The `capacity` determines the maximum number of students that can be on the
   * waitlist.
   * If `capacity` is larger than the number of given student IDs, the additional
   * slots
   * in the waitlist will be initialized as `null`.
   * 
   * @param studentIds the initial student IDs to include on the waitlist
   * @param capacity   the total capacity of the waitlist
   * @throws IllegalArgumentException if `capacity` is smaller than the number of
   *                                  given student IDs
   */
  public Waitlist(String[] studentIds, int capacity) {
    if (capacity < studentIds.length) {
      throw new IllegalArgumentException(
          "Capacity (" + capacity + ") cannot be smaller than the number of student IDs given (" + studentIds.length
              + ").");
    }
    this.studentIds = Arrays.copyOf(studentIds, capacity);
  }

  /**
   * Removes students with the given studentIds from the waitlist.
   * 
   * If a studentId in the toRemove Set is not present in the waitlist,
   * that student is ignored. The remaining students on the waitlist
   * have their order preserved.
   * 
   * @param toRemove studentIds of the students to remove
   */
  public void removeStudents(Set<String> toRemove) {
    // TODO: Implement this!
    // The remaining students should be slid down to the front of the array, not
    // leaving any gaps. All the nulls should be at the end.
    // Example:
    // studentIds: ["x", "r", "q", "m", "v", null, null]
    // toRemove: {"r", "m"}
    //
    // expected studentIds after running: ["x", "q", "v", null, null, null, null]

    // Required complexity:
    // Time: O(n)
    // Space: O(1)
    // Where n is studentIds.length

    // Don't forget to write tests too!

    for (int i = 0; i < studentIds.length - 1; i++) {
      if (toRemove.contains(studentIds[i])) {
        studentIds[i] = null;
      }

      // pushing nulls to back
      // for(int i = 0; i < studentIds.length -1; i++){
      // if (studentIds[i] == null) {
      // placeholder = studentIds[i + 1];
      // studentIds[i + 1] = null;
      // studentIds[i] = placeholder;
      // }

      // removing all ids
      // if(toRemove.contains(studentIds[i])){
      // studentIds[i] = null;
      // placeholder = studentIds[i + 1];
      // studentIds[i + 1] = null;
      // studentIds[i] = placeholder;
      // }

      // The problem with the code above is that it was doing to many things at once
      // meaning that it would be checking to see if the current item was null and also checking if it needed to remove something
      // this didn't produce the desired array because the logic was out of sort. It workeed but not 

      // with the approach below it first puts items as null
      // then in the second for loop it would move the null items to the back 
      int goodSpot = 0;
      // this is the placeholder to where we will be moving eligible j into 
      for (int j = 0; j < studentIds.length; j++) {
        if (studentIds[j] != null) {
          studentIds[goodSpot] = studentIds[j];
          // if the current index is not null set studentIds at postion GOODSPOT to the j index of student ids

          if (goodSpot != j) {
            studentIds[j] = null;
            //once the above is completed (the above if statement)
            // if the goodSpot index is NOT THE SAME as the j index, meaning that the valid elemnt has been moved 
            // we need to clear the original position j to remove/prevent duplciates
          }
          goodSpot++;
        }

      }
    }
  }

  /**
   * Returns a copy of the waitlist.
   * 
   * Null values represent open spaces on the waitlist.
   * 
   * @return a copy of the current waitlist array, including `null` values for
   *         open slots
   */
  public String[] getWaitlist() {
    return Arrays.copyOf(studentIds, studentIds.length);
  }

  @Override
  public String toString() {
    return Arrays.toString(studentIds);
  }
}
