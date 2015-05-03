import java.util.*;
/**
 * Write a description of class ComparadorPorTamanho here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorPorTamanho implements Comparator<String>{

  public int compare(String s1, String s2) {
    return Integer.compare(s1.length(), s2.length());
  }
}
