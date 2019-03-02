package p15;
//: c15:Queue.java
// Demonstration of Design by Contract (DBC) combined
// with white-box unit testing.
// {Depends: junit.jar}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import junit.framework.*;
import java.util.*;

public class Queue {
  private Object[] data;
  private int
    in = 0, // Next available storage space
    out = 0; // Next gettable object
  // Has it wrapped around the circular queue?
  private boolean wrapped = false;
  public static class
  QueueException extends RuntimeException {
    public QueueException(String why) { super(why); }
  }
  public Queue(int size) {
    data = new Object[size];
    assert invariant(); // Must be true after construction
  }
  public boolean empty() {
    return !wrapped && in == out;
  }
  public boolean full() {
    return wrapped && in == out;
  }
  public void put(Object item) {
    precondition(item != null, "put() null item");
    precondition(!full(), "put() into full Queue");
    assert invariant();
    data[in++] = item;
    if(in >= data.length) {
      in = 0;
      wrapped = true;
    }
    assert invariant();
  }
  public Object get() {
    precondition(!empty(), "get() from empty Queue");
    assert invariant();
    Object returnVal = data[out];
    data[out] = null;
    out++;
    if(out >= data.length) {
      out = 0;
      wrapped = false;
    }
    assert postcondition(
      returnVal != null, "Null item in Queue");
    assert invariant();
    return returnVal;
  }
  // Design-by-contract support methods:
  private static void
  precondition(boolean cond, String msg) {
    if(!cond) throw new QueueException(msg);
  }
  private static boolean
  postcondition(boolean cond, String msg) {
    if(!cond) throw new QueueException(msg);
    return true;
  }
  private boolean invariant() {
    // Guarantee that no null values are in the
    // region of 'data' that holds objects:
    for(int i = out; i != in; i = (i + 1) % data.length)
      if(data[i] == null)
        throw new QueueException("null in queue");
    // Guarantee that only null values are outside the
    // region of 'data' that holds objects:
    if(full()) return true;
    for(int i = in; i != out; i = (i + 1) % data.length)
      if(data[i] != null)
        throw new QueueException(
          "non-null outside of queue range: " + dump());
    return true;
  }
  private String dump() {
    return "in = " + in +
      ", out = " + out +
      ", full() = " + full() +
      ", empty() = " + empty() +
      ", queue = " + Arrays.asList(data);
  }
  // JUnit testing.
  // As an inner class, this has access to privates:
  public static class WhiteBoxTest extends TestCase {
    private Queue queue = new Queue(10);
    private int i = 0;
    public WhiteBoxTest(String name) {
      super(name);
      while(i < 5) // Preload with some data
        queue.put("" + i++);
    }
    // Support methods:
    private void showFullness() {
      assertTrue(queue.full());
      assertFalse(queue.empty());
      // Dump is private, white-box testing allows access:
      System.out.println(queue.dump());
    }
    private void showEmptiness() {
      assertFalse(queue.full());
      assertTrue(queue.empty());
      System.out.println(queue.dump());
    }
    public void testFull() {
      System.out.println("testFull");
      System.out.println(queue.dump());
      System.out.println(queue.get());
      System.out.println(queue.get());
      while(!queue.full())
        queue.put("" + i++);
      String msg = "";
      try {
        queue.put("");
      } catch(QueueException e) {
        msg = e.getMessage();
        System.out.println(msg);
      }
      assertEquals(msg, "put() into full Queue");
      showFullness();
    }
    public void testEmpty() {
      System.out.println("testEmpty");
      while(!queue.empty())
        System.out.println(queue.get());
      String msg = "";
      try {
        queue.get();
      } catch(QueueException e) {
        msg = e.getMessage();
        System.out.println(msg);
      }
      assertEquals(msg, "get() from empty Queue");
      showEmptiness();
    }
    public void testNullPut() {
      System.out.println("testNullPut");
      String msg = "";
      try {
        queue.put(null);
      } catch(QueueException e) {
        msg = e.getMessage();
        System.out.println(msg);
      }
      assertEquals(msg, "put() null item");
    }
    public void testCircularity() {
      System.out.println("testCircularity");
      while(!queue.full())
        queue.put("" + i++);
      showFullness();
      // White-box testing accesses private field:
      assertTrue(queue.wrapped);
      while(!queue.empty())
        System.out.println(queue.get());
      showEmptiness();
      while(!queue.full())
        queue.put("" + i++);
      showFullness();
      while(!queue.empty())
        System.out.println(queue.get());
      showEmptiness();
    }
  }
  public static void main(String[] args) {
    junit.textui.TestRunner.run(Queue.WhiteBoxTest.class);
  }
} ///:~
