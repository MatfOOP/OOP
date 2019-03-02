//: c10:FamilyVsExactType.java
// The difference between instanceof and class
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p10;
import com.bruceeckel.simpletest.*;

class Base {}
class Derived extends Base {}

public class FamilyVsExactType {
  private static Test monitor = new Test();
  static void test(Object x) {
    System.out.println("Testing x of type " +
      x.getClass());
    System.out.println("x instanceof Base " +
      (x instanceof Base));
    System.out.println("x instanceof Derived " +
      (x instanceof Derived));
    System.out.println("Base.isInstance(x) " +
      Base.class.isInstance(x));
    System.out.println("Derived.isInstance(x) " +
      Derived.class.isInstance(x));
    System.out.println("x.getClass() == Base.class " +
      (x.getClass() == Base.class));
    System.out.println("x.getClass() == Derived.class " +
      (x.getClass() == Derived.class));
    System.out.println("x.getClass().equals(Base.class)) "+
      (x.getClass().equals(Base.class)));
    System.out.println(
      "x.getClass().equals(Derived.class)) " +
      (x.getClass().equals(Derived.class)));
  }
  public static void main(String[] args) {
    test(new Base());
    test(new Derived());
    monitor.expect(new String[] {
      "Testing x of type class c10.Base",
      "x instanceof Base true",
      "x instanceof Derived false",
      "Base.isInstance(x) true",
      "Derived.isInstance(x) false",
      "x.getClass() == Base.class true",
      "x.getClass() == Derived.class false",
      "x.getClass().equals(Base.class)) true",
      "x.getClass().equals(Derived.class)) false",
      "Testing x of type class c10.Derived",
      "x instanceof Base true",
      "x instanceof Derived true",
      "Base.isInstance(x) true",
      "Derived.isInstance(x) true",
      "x.getClass() == Base.class false",
      "x.getClass() == Derived.class true",
      "x.getClass().equals(Base.class)) false",
      "x.getClass().equals(Derived.class)) true"
    });
  }
} ///:~
