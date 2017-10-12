import java.util.*;
import java.io.*;

public class WordSearch{
   private char[][] grid;
   private boolean[][] sol;
   private String[] words;
   
   public WordSearch(String[] words){
      for(int i = 0 ; i < words.length ; i++){
         words[i] = words[i].toLowerCase();
      }
      this.words = words;
   }
   
   public void generate(){
      char[][] wordChars = new char[words.length][];
      int longest = 8;
      for(int i = 0 ; i < words.length ; i++){
         wordChars[i] = words[i].toCharArray();
         if(wordChars[i].length > longest){
            longest = wordChars[i].length;
         }
      }
      this.grid = new char[longest + 2][longest + 2];
      this.sol = new boolean[longest + 2][longest + 2];
      Random rand = new Random();
      for(int i = 0 ; i < wordChars.length ; i++){
         int direction = rand.nextInt(3);
         int posX = 0;
         int posY = 0;
         if(direction == 0){ //horizontal
            boolean placed = false;
            int attempts = 0;
            while(!placed && attempts < 100){
               posX = rand.nextInt((grid.length-1) - wordChars[i].length);
               posY = rand.nextInt((grid.length-1) - wordChars[i].length);
               placed = true;
               for(int u = 0 ; u < wordChars[i].length ; u++){
                  if(grid[posX + u][posY] != '\u0000' && grid[posX + u][posY] != wordChars[i][u]){
                     placed = false;
                     break;
                  }
               }
               attempts++;
            }
            if(placed){
               for(int x = 0 ; x < wordChars[i].length ; x++){
                  grid[posX][posY] = wordChars[i][x];
                  sol[posX][posY] = true;
                  posX++;
               }
            }
         }else if(direction == 1){ //vertical
            boolean placed = false;
            int attempts = 0;
            while(!placed && attempts < 100){
               posX = rand.nextInt((grid.length-1) - wordChars[i].length);
               posY = rand.nextInt((grid.length-1) - wordChars[i].length);
               placed = true;
               for(int u = 0 ; u < wordChars[i].length ; u++){
                  if(grid[posX][posY + u] != '\u0000' && grid[posX][posY + u] != wordChars[i][u]){
                     placed = false;
                     break;
                  }
               }
               attempts++;
            }
            if(placed){
               for(int x = 0 ; x < wordChars[i].length ; x++){
                  grid[posX][posY] = wordChars[i][x];
                  sol[posX][posY] = true;
                  posY++;
               }
            }
         }else if(direction == 2){ //diagonal
            boolean placed = false;
            int attempts = 0;
            while(!placed && attempts < 100){
               posX = rand.nextInt((grid.length-1) - wordChars[i].length);
               posY = rand.nextInt((grid.length-1) - wordChars[i].length);
               placed = true;
               for(int u = 0 ; u < wordChars[i].length ; u++){
                  if(grid[posX + u][posY + u] != '\u0000' && grid[posX + u][posY + u] != wordChars[i][u]){
                     placed = false;
                     break;
                  }
               }
               attempts++;
            }
            if(placed){
               for(int x = 0 ; x < wordChars[i].length ; x++){
                  grid[posX][posY] = wordChars[i][x];
                  sol[posX][posY] = true;
                  posY++;
                  posX++;
               }
            }
         }
      }
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            if(grid[i][x] == '\u0000'){
               grid[i][x] = (char)(rand.nextInt(26)+97);
            }
         } 
      }
   }
   
   public String toString(){
      String result = "";
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            result += " " + grid[i][x] + " ";
         }
         result += "\n";
      }
      return result;
   }
   
   public String solve(){
      String result = "";
      for(int i = 0 ; i < grid.length ; i++){
         for(int x = 0 ; x < grid[i].length ; x++){
            if(sol[i][x]){
               result += " " + grid[i][x] + " ";
            }else{
               result += " X ";
            }
         }
         result += "\n";
      }
      return result;
   }
}