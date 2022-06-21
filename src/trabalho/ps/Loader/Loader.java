/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho.ps.Loader;
        
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import trabalho.ps.Memory;
import trabalho.ps.Word;
import trabalho.ps.Register;

import java.util.ArrayList;

/**
 *
 * @author Marcelo
 */
public class Loader {
  private static Memory memory = new Memory(2048);
  
  private static ArrayList<String> file_content = new ArrayList<>();
  private static int start = 0;

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int index = 0;
    
    readFile();
    
    for (String line : file_content) {
        Word value = new Word(line);

        if (line.length() == 8)  // 1 Bytes 
            memory.memoryWrite(start + index, 1, value);
        else if (line.length() == 16)  // 2 Bytes
            memory.memoryWrite(start + index, 2, value);
        else if (line.length() == 24) // 3 Bytes
            memory.memoryWrite(start + index, 3, value);
        else // 4 Bytes
            memory.memoryWrite(start + index, 4, value);
      
      index = index + (line.length() / 8);
    }
    
    memory.listMemory();
  }

  public static void readFile() throws FileNotFoundException {
    File file = new File("C:\\Users\\Marce\\Desktop\\teste\\Carregador\\test\\deus.txt");
    Scanner scan = new Scanner(file);

    while(scan.hasNextLine()) {
      file_content.add(scan.nextLine());
    }
    scan.close();
  }
}
