public class WordSearchMain{
   public static void main(String[] args){
      String[] words = {"test1", "testLOL", "asdasdasd"};
      WordSearch testSearch = new WordSearch(words);
      testSearch.generate();
      System.out.println(testSearch);
      System.out.println(testSearch.solve());
   }
}