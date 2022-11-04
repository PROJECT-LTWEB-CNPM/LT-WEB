package utils;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Helper {
  public static String getRandom() {
    Random rand = new Random();
    int number = rand.nextInt(999999);
    return String.format("%06d", number);
  }

  public static String intToVND(int price) {
    Locale vnd = new Locale("vi", "VN");
    // Create a Currency instance for the Locale
    Currency vnds = Currency.getInstance(vnd);
    // Create a formatter given the Locale
    NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vnd);
    return vndFormat.format(price).replace('.', ',');
  }
  
  public static LocalDate dateWithoutTime (Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
}
