package p03;
//: c03:LabeledFor.java
// Java's "labeled for" loop.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class LabeledFor {
  static Test monitor = new Test();
  public static void main(String[] args) {
    int i = 0;
    outer: // Can't have statements here
    for(; true ;) { // infinite loop
      inner: // Can't have statements here
      for(; i < 10; i++) {
        System.out.println("i = " + i);
        if(i == 2) {
          System.out.println("continue");
          continue;
        }
        if(i == 3) {
          System.out.println("break");
          i++; // Otherwise i never
               // gets incremented.
          break;
        }
        if(i == 7) {
          System.out.println("continue outer");
          i++; // Otherwise i never
               // gets incremented.
          continue outer;
        }
        if(i == 8) {
          System.out.println("break outer");
          break outer;
        }
        for(int k = 0; k < 5; k++) {
          if(k == 3) {
            System.out.println("continue inner");
            continue inner;
          }
        }
      }
    }
    // Can't break or continue to labels here
    monitor.expect(new String[] {
      "i = 0",
      "continue inner",
      "i = 1",
      "continue inner",
      "i = 2",
      "continue",
      "i = 3",
      "break",
      "i = 4",
      "continue inner",
      "i = 5",
      "continue inner",
      "i = 6",
      "continue inner",
      "i = 7",
      "continue outer",
      "i = 8",
      "break outer"
    });
  }
} ///:~
