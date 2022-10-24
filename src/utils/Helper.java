package utils;

import java.util.Random;

public class Helper {
  public static String getRandom() {
    Random rand = new Random();
    int number = rand.nextInt(999999);
    return String.format("%06d", number);
  }
}
