package lib;
import java.util.Random;

public class StringArray{


  /**
    pick a random element of a list of Strings
    @param list the array of Strings
    @return a randomly selected member of the list
  */
  public static String pickRandom(String[] list){
    Random random = new Random();
    int k = random.nextInt(list.length);
    return list[k];
  }



  /**
  finds the first keyword to appear in the words,
  returns the empty string "" if keywords appear in the words

  @param words the words to be checked
  @param keywords the words to look familyWords
  @return first keyword appearing in words or "" in no keywords appear in words
  */
  public static String intersection(String[] words,String[] keywords){
    for(String w:words){  // for each word w in words
      for(String k:keywords){ // for each string k in keywords
        if (w.equals(k)){  // test if they are equal
          return k;   // if so, return true!
        }
      }
    }
    return "";  // if we got here then no words matched any keywords
  }


  /**
  checks to see if any of the keywords appear in the array of familyWords

  @param words the words to be checked
  @param keywords the words to look familyWords
  @return true if one of the keywords appears in words ...
  */
  public static boolean intersects(String[] words,String[] keywords){
    String result = intersection(words,keywords);
    return !(result.equals(""));
  }
}
