package ch.epfl.sweng.defensive.param.check.tinyc.libc;

import ch.epfl.sweng.defensive.param.check.tinyc.type.cstring;

public class string {

  public static cstring strcpy(cstring destination, cstring source) {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }
    int i = -1;
    do {
      i++;
      destination.set(i, source.get(i));
    } while(source.get(i) != '\0');
    return destination;
  }

  public static cstring strncpy(cstring destination, cstring source, int num) {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }
    if(num == 0){
      destination = null;
    }else{
      int i = -1;
      do {
        i++;
        destination.set(i, source.get(i));
      } while(i < num-1 && source.get(i) != '\0');
    }
    return destination;
  }

  public static cstring strcat(cstring destination, cstring source) {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }
    int i = 0, j = 0;
    while(destination.get(i) != '\0'){
      i++;
    }
    while(source.get(j) != '\0'){
      System.out.println("i = "+ i +" j = "+ j);
      destination.set(i, source.get(j));
      i++; j++;
    }
    destination.set(i, '\0');
    return destination;
  }

  public static cstring strncat(cstring destination, cstring source, int num) {
    if(destination == null){
      throw new IllegalArgumentException("destination null");
    }
    if(source == null){
      throw new IllegalArgumentException("source null");
    }
    int i = 0, j = 0;
    while(destination.get(i) != '\0'){
      i++;
    }
    while(source.get(j) != '\0' && j < num){
      // System.out.println("i = "+ i +" j = "+ j);
      destination.set(i, source.get(j));
      i++; j++;
    }
    destination.set(i, '\0');
    return destination;
  }

  public static int strlen(cstring str) {
    if(str == null){
      throw new IllegalArgumentException("null argument");
    }
    int len = 0;
    while (str.get(len) != '\0'){
      len ++;
    }
    return len;
  }

  public static int strcmp(cstring str1, cstring str2) {
    if(str1 == null){
      throw new IllegalArgumentException("null argument 1");
    }
    if(str2 == null){
      throw new IllegalArgumentException("null argument 2");
    }
    int i = 0;
    while(str1.get(i) != '\0' && str2.get(i) != '\0'){
      if(str1.get(i) == str2.get(i)) 
        i++;
      if(str1.get(i) < str2.get(i)) return -1;
      if(str1.get(i) > str2.get(i)) return 1;
    }
    if(str1.get(i) == '\0' && str2.get(i) != '\0') 
      return -1;
    else if(str1.get(i) != '\0' && str2.get(i) == '\0')
      return 1;

    return 0;
  }

  public static int strncmp(cstring str1, cstring str2, int num) {
    if(str1 == null){
      throw new IllegalArgumentException("null argument 1");
    }
    if(str2 == null){
      throw new IllegalArgumentException("null argument 2");
    }
    int i = 0;
    while(str1.get(i) != '\0' && str2.get(i) != '\0' && i < num){
      if(str1.get(i) == str2.get(i)) 
        i++;
      if(str1.get(i) < str2.get(i)) return -1;
      if(str1.get(i) > str2.get(i)) return 1;
    }
    if(str1.get(i) == '\0' && str2.get(i) != '\0') 
      return -1;
    else if(str1.get(i) != '\0' && str2.get(i) == '\0')
      return 1;
      
    return 0;
  }
}