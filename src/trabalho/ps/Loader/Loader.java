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

public class Loader {

    private static ArrayList<String> file_content = new ArrayList<>();

    public static void load(String filename, Memory memory, int address) throws FileNotFoundException, IOException {
        int index = 0;

        readFile(filename);

        for (String line : file_content) {
            Word value = new Word(line);

            if (line.length() == 8) // 1 Bytes 
            {
                memory.memoryWrite(address + index, 1, value);
            } else if (line.length() == 16) // 2 Bytes
            {
                memory.memoryWrite(address + index, 2, value);
            } else if (line.length() == 24) // 3 Bytes
            {
                memory.memoryWrite(address + index, 3, value);
            } else // 4 Bytes
            {
                memory.memoryWrite(address + index, 4, value);
            }

            index = index + (line.length() / 8);
        }
        reset();
    }

    public static void readFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            file_content.add(scan.nextLine());
        }
        scan.close();
    }

    public static void reset() {
        file_content.clear();
    }
}
