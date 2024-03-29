package ch.epfl.sweng.defensive.neutral.returned.value.goolge;

import java.util.Iterator;
import java.util.Optional;

import ch.epfl.sweng.defensive.neutral.returned.value.internet.Internet;
import ch.epfl.sweng.defensive.neutral.returned.value.model.Result;

public class Goolge {

  public static Result search(String[] keywords) {
    Iterator<String> iterator = Internet.find(keywords);
    if (iterator.hasNext()) {
      return new Result(iterator);
    }
    Optional<Result> result = Optional.ofNullable(null); 
    return result.get();
  }
}