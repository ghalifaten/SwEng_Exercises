package ch.epfl.sweng.defensive.param.check;

import ch.epfl.sweng.defensive.param.check.tinyc.type.cstring;
import ch.epfl.sweng.defensive.param.check.tinyc.libc.string;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello");
    cstring s1 = new cstring(5);
    cstring s2 = new cstring(4);

    s2.set(0, 'S'); s2.set(1, 'W'); s2.set(2, 'E'); s2.set(3, 'N');
    for(int i=4; i<10; i++){
      s2.set(i, '\0');
    }

    s1.set(0, 's'); s1.set(1, 'w'); s1.set(2, 'e'); s1.set(3, 'n'); s1.set(4, 'g');
    string.strcat(s2, s1);
 
    for(int i=0; i<5; i++){
      System.out.print(string.strcat(s2, s1).get(i));
    }
    System.out.println("end");
  }
}