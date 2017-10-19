import java.util.*;
import java.io.*;

/**
   Brandon Dixon
   10/19/2017
   CS145
   WordSearchMain.java
   
   A client class that allows the user to interact with the word search generator.
*/

public class WordSearchMain{
   public static void main(String[] args) throws FileNotFoundException{
      boolean generated = false;
      Scanner console = new Scanner(System.in);
      String choice;
      WordSearch search = new WordSearch();
      do{
         printIntro();
         choice = console.next();
         if(choice.equals("g")){
            System.out.println("Enter words line by line until you are finished at which point type a single \"q\"");
            String tok = console.next();
            ArrayList<String> wordsAR = new ArrayList<String>();
            do{
               wordsAR.add(tok);
               tok = console.next();
            }while(!tok.equals("q"));
            String[] words = new String[wordsAR.size()];
            wordsAR.toArray(words);
            search.generate(words);
            generated = true;
         }else if(choice.equals("p")){
            if(generated){
               print(search);
            }
         }else if(choice.equals("s")){
            if(generated){
               showSolution(search);
            }
         }else if(choice.equals("fo")){
            if(generated){
               System.out.println("Please enter the path to the file you would like to output to.");
               String path = console.next();
               search.toFile(new File(path));
            }
         }else if(choice.equals("fi")){
            System.out.println("Please enter the path to the file you would like to input from.");
            String path = console.next();
            Scanner fin = new Scanner(new File(path));
            ArrayList<String> wordsAR = new ArrayList<String>();
            while(fin.hasNext()){
               wordsAR.add(fin.next());
            }
            if(wordsAR.size() > 0){
               String[] words = new String[wordsAR.size()];
               wordsAR.toArray(words);
               search.generate(words);
               generated = true;
            }else{
               System.out.println("Your selected file has no tokens.");
            }
         }
      }while(!choice.equals("q"));      
   }
   
   //Prints an intro to the program which explains and lists options.
   public static void printIntro(){
      System.out.println("Welcome to my word search generator!");
      System.out.println("This programs will allow you to generate your own word search puzzle");
      System.out.println("Please select and option:");
      System.out.println("Generate a new word search (g)");
      System.out.println("Print out your word search (p)");
      System.out.println("Show the solution to your word search(s)");
      System.out.println("Print the puzzle and solution to a file of your choice (fo)");
      System.out.println("Generate a puzzle from a file of your choice instead of user input (fi)");
      System.out.println("Quit the prograrm (q)");
   }
   
   //Prints out the word search.
   public static void print(WordSearch ws){
      System.out.println(ws);
   }
   
   //Prints out the solution to the word search.
   public static void showSolution(WordSearch ws){
      System.out.println(ws.toSolution());
   }
}