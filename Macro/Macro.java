import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;

public class Macro {
  private static ArrayList<String> file_content = new ArrayList<>(); // Array contendo todas as linhas do codigo
  private static ArrayList<NamTab> nam_tab_list = new ArrayList<>();
  private static ArrayList<String> def_tab = new ArrayList<>();
  private static ArrayList<String> args_tab = new ArrayList<>();
  private static ArrayList<String> output = new ArrayList<>();

  private static String opcode = new String("");
  private static int file_pointer = 0;
  private static int maxLevel = 0;
  private static int countExpand = 0;
  private static String filename = new String("example1");

  public static void main(String[] args) throws FileNotFoundException, IOException {
    FileWriter macroWrite = new FileWriter("./tests/macro.txt");
    
    int count = 0;
    readFile();

    do {
      runProgram();
    } while (count++ < maxLevel);

    for (int i = 0; i < file_content.size(); i++) {
      macroWrite.write(file_content.get(i));

      if (i != file_content.size() - 1) 
        macroWrite.write("\n");
    }

    macroWrite.close();
  }

  public static void runProgram() {
    String current_line;

    while (!opcode.contains("STOP")) {
      current_line = getLine();
      processLine(current_line);
    }

    file_content.clear();
    args_tab.clear();

    file_content.addAll(output);
    output.clear();
    file_pointer = 0;

    opcode = "";
  }

  public static String getLine() {
    String current_line = file_content.get(file_pointer++);

    getOpcode(current_line);

    return current_line;
  }

  public static void processLine(String current_line) {
    NamTab selected_macro = findMacroName();

    char[] aux_line = current_line.toCharArray();

    if(aux_line[0] == '#') return;

    if (selected_macro != null) {
      expand(current_line, selected_macro);
    } else if (current_line.contains("MCDEFN")) {
      define(current_line);
    } else {
      output.add(current_line);
    }
  }

  public static void define(String line) {
    String current_line;

    String macro_name = String.copyValueOf(opcode.toCharArray());
    String prototype = getPrototype(line);

    int start_definition = def_tab.size();

    def_tab.add(prototype);

    int end_definition;

    int level = 1;

    while(level > 0) {
      current_line = getLine();

      def_tab.add(current_line);

      if (current_line.contains("MCDEFN")) {
        level++;

        if (maxLevel < level) {
          maxLevel = level;
        }
      }
      else if (current_line.contains("MCEND"))
        level--;
    }

    end_definition = def_tab.size()-1;

    nam_tab_list.add(new NamTab(macro_name, start_definition, end_definition));
  }

  public static void listDefTab() {
    for (int i = 0; i < def_tab.size(); i++)
      System.out.println(def_tab.get(i));

    System.out.println();
  }

  public static void expand(String current_line, NamTab selected_macro) {
    int start_macro = selected_macro.getStartDefinition();
    int end_macro = selected_macro.getEndDefinition();

    String begining_def_tab = def_tab.get(start_macro);

    String aux_def_tab;

    String[] args = getArgs(current_line);
    String[] prototype_args = getArgs(begining_def_tab);

    for (int i = 0; i < args.length; i++) 
      args_tab.add(args[i]);

    for (int line = start_macro+1; line < end_macro; line++) {
      aux_def_tab = def_tab.get(line);

      if (aux_def_tab.contains(".SER")) 
        aux_def_tab = aux_def_tab.replace("SER", Integer.toString(countExpand));
      
      for (int i = 0; i < args_tab.size(); i++) {
        aux_def_tab = aux_def_tab.replace(prototype_args[i], args_tab.get(i));
      }

      output.add(aux_def_tab);
    }

    args_tab.clear();

    countExpand++;
  }

  public static NamTab findMacroName() {
    for (NamTab current_name_macro : nam_tab_list)
      if (opcode.equals(current_name_macro.getMacroName()))
        return current_name_macro;

    return null;
  }

  public static void readFile() throws FileNotFoundException { // Lê txt com o código
    File file = new File("./tests/" + filename + ".txt");
    Scanner scan = new Scanner(file);

    while(scan.hasNextLine()) {
      file_content.add(scan.nextLine());
    }
    scan.close();
  }

  public static void getOpcode(String current_line) {
      String line_label;
      line_label = current_line.split(" ")[0];
      line_label.replace(" ","");

      opcode = String.copyValueOf(line_label.toCharArray());
  }

  public static String[] getArgs(String current_line) {
    String[] line_args;

    line_args = current_line.split(",");

    line_args[0] = line_args[0].split(" ")[1];

    for (int i = 0; i < line_args.length; i++) {
      line_args[i] = line_args[i].replace(" ", "");
    }

    return line_args;
  }

  public static String getPrototype(String current_line) {
    String[] line_arg;
    String value = new String();

    line_arg = current_line.split(" "); // Salvo 

    for (int i = 0; i < line_arg.length; i++) {
      if (i != 1) 
        value = value + line_arg[i] + " ";
      
    }

    value = value.trim();

    return value;
  }
}