import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.transform.OutputKeys;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Assembler {
  private static ArrayList<String> file_content = new ArrayList<>();


  //private static String filename = new String("teste");
  private static ArrayList<String> machineInstructions = new ArrayList<>(Arrays.asList("ADDR", "CLEAR", "COMPR", "DIVR", "MULR", "RMO", "SHIFTL", "SHIFTR", "SUBR", "TIXR", "ADD", "AND", "COMP", "DIV", "J", "JEQ", "JGT", "JLT", "JSUB", "LDA", "LDB", "LDCH", "LDL", "LDS", "LDT", "LDX", "MUL", "OR", "RSUB", "STA", "STB", "STCH", "STL", "STS", "STT", "STX", "SUB", "TIX", "STOP"));
  //private static ArrayList<String> instOpcode = new ArrayList<>(Arrays.asList("90", "4", "A0", "9C", "98", "AC", "A4", "A8", "94", "B8", "18", "40", "28", "24", "3C", "30", "34", "38", "48", "0", "68", "50", "8", "6C", "74", "4", "20", "44", "4C", "0C", "78", "54", "14", "7C", "84", "10", "1C", "2C", "0B"));
  private static ArrayList<String> instOpcode = new ArrayList<>(Arrays.asList("144", "4", "160", "156", "152", "172", "164", "168", "148", "184", "24", "64", "40", "36", "60", "48", "52", "56", "72", "0", "104", "80", "8", "108", "116", "4", "32", "68", "76", "12", "120", "84", "20", "124", "132", "16", "28", "44", "72"));
  private static ArrayList<String> outputSecondStep = new ArrayList<>();
  private static ArrayList<String> output = new ArrayList<>();
  private static HashMap<String, Integer> symbolList = new HashMap<>();
  private static HashMap<String, String> registerList = new HashMap<>();

  private static Word address;
  private static Word opcode;

  private static int addressCounter = 0;
  private static boolean isLabel=false;

  private static boolean isExtended = false;

  private static int stopPosition = 0;


  public static void main(String[] args) throws FileNotFoundException, IOException {
    FileWriter assemblerWrite = new FileWriter("./assembler.txt");

    readFile();

    initializeRegister();

    //Primeira etapa
    for(String line: file_content) {
      processFirstStep(line);
    }

    addressCounter = 0;

    //Segunda etapa
    for(String line: file_content) {
      processSecondStep(line);
    }

    formatFile();

    output.add("01001000"); // STOP

    posStop();

    System.out.println(symbolList);

    for(int i = 0; i < output.size(); i++) {
      assemblerWrite.write(output.get(i));

      if (i != output.size() - 1) {
        assemblerWrite.write("\n");
      }
    }
    assemblerWrite.close();
  }

  public static void posStop() {
    for (int index = stopPosition; index < outputSecondStep.size(); index++) {

      if (!outputSecondStep.get(index).equals("72 ")) {
        if (!outputSecondStep.get(index).equals("xx")) {
          String auxLine = toBinary(Integer.parseInt(outputSecondStep.get(index)));
          output.add(auxLine);
        } else {
          output.add("00000000");
        }
      }
    }
  }

  public static void processFirstStep(String line) {
    
    String[] lines;
    lines = cleanString(line);

    if(!machineInstructions.contains(lines[0])) { // É label
      if(!symbolList.containsKey(lines[0])) { // Adiciona o label na lista de simbolos
        symbolList.put(lines[0], addressCounter);
      }
      else {
        symbolList.replace(lines[0], addressCounter);
      }
      isLabel = true;
    }

    if(isLabel) {
      for(int i = 1; i < lines.length; i++) {
          if(!machineInstructions.contains(lines[i]) && !symbolList.containsKey(lines[i])) {
            if(!lines[i].equals("CONST") && !lines[i].equals("SPACE")) {
              if(!lines[i-1].equals("CONST")) {
                symbolList.put(lines[i], -1);
              }
            }
          }
        }
        if(lines[1].equals("CONST") || lines[1].equals("SPACE")) {
          symbolList.replace(lines[0], addressCounter);
        }
      
    }
    else {
      for(int i = 0; i < lines.length; i++) {
        if(!machineInstructions.contains(lines[i]) && !symbolList.containsKey(lines[i])) {
          if(!lines[i].equals("CONST") && !lines[i].equals("SPACE")){
              symbolList.put(lines[i], -1);
          }
        }
      }
    }

    if(isLabel) { // iterador de endereços
      if(!line.contains("CONST")) {
        addressCounter = addressCounter + (lines.length - 1); // -label
      }
      else {
        addressCounter = addressCounter + (lines.length - 2); // -label e constante
      }
    }
    else {
      int indexOpertaion = machineInstructions.indexOf(lines[0]);

      if (lines[0].equals("STOP"))
        addressCounter = addressCounter + 1;
      else if (indexOpertaion < 10) {
        addressCounter = addressCounter + 2;
      } else if (lines[0].charAt(0) == '+') 
          addressCounter = addressCounter + 4;
          else
          addressCounter = addressCounter + 3;
    }

    isLabel = false;

  }

  public static void processSecondStep (String line) {
    String[] lines;
    lines = cleanString(line);
    String auxOutput = "";
    String aux;
  

    /*
     * INDEX DO OPERADOR < 10 - 2 BYTES
     * OPERADOR COMEÇA COM + - 4 BYTES
     * 3 BYTES
     * 
     */

    // Retira os labels
    //currentLine = !machineInstructions.contains(formattedLine[0].replace("+", "")) ? Arrays.copyOfRange(formattedLine, 1, formattedLine.length) : formattedLine; 

    // Teste se tem 4 bytes
    //isExtended = currentLine[0].charAt(0) == '+' ? true : false;

    //indexOperation = machineInstructions.indexOf(currentLine[0].replace("+", ""));
  
    // Substituições
    for(String operation : lines) {
      int index;
      index = machineInstructions.indexOf(operation.replace("+", ""));

      if(machineInstructions.contains(operation.replace("+", ""))){ // achou a operação
        if (operation.charAt(0) == '+') {
          aux = instOpcode.get(index);
          auxOutput = auxOutput + "+" + aux + " ";
        } else {
          aux = instOpcode.get(index);
          auxOutput = auxOutput + aux + " ";
        }
      }
      else if(symbolList.containsKey(operation)) { // achou um simbolo conhecido
        if (!registerList.containsKey(operation)) {
          if(!line.contains("CONST") && !line.contains("SPACE")) {
            aux = Integer.toString(symbolList.get(operation));

            if (operation.charAt(0) == '@') {
              auxOutput = auxOutput + operation;
            }
            else if (operation.charAt(0) == '#')
              auxOutput = auxOutput + operation;
            else
              auxOutput = auxOutput + aux + " ";
          }
          else if(line.contains("CONST")){
            aux = (lines[2]);
            auxOutput = auxOutput + aux;
          }
          else if (line.contains("SPACE")) {
            auxOutput = auxOutput + "xx";
          }
        } else {
          auxOutput = auxOutput + operation + " ";
        }
      }
    }
    outputSecondStep.add(auxOutput);
  }

  public static void formatFile() {
    for (int i = 0; i < outputSecondStep.size(); i++) 
      System.out.println(outputSecondStep.get(i));

    String selectedOperationOpcode;
    String auxLine = "";

    Word auxOpcode = new Word(8);

    int indexOperation = 0, instructionSize;

    char[] nixbpe = { '0',  '0',  '0',  '0',  '0',  '0'};

    String[] formattedLine;

    for (int index = 0; index < outputSecondStep.size(); index++) {
      if (file_content.get(index).equals("STOP")) break;
      
      auxLine = "";

      formattedLine = cleanString(outputSecondStep.get(index));

      isExtended = file_content.get(index).charAt(0) == '+' ? true : false;

      indexOperation = instOpcode.indexOf(formattedLine[0].replace("+", ""));

      if (indexOperation != -1) {

        if (isExtended) { // Instrução 4 Bytes
          instructionSize = 4;
          nixbpe[5] = '1';
        } else if (indexOperation <= 9) 
          instructionSize = 2;
          else
            instructionSize = 3;

        if (instructionSize == 2) {
          opcode = new Word(8);
          address = new Word(8);
        } else if (instructionSize == 3) {
          opcode = new Word(6);
          address = new Word(12);
        } else {
          opcode = new Word(6);
          address = new Word(20);
        }
    
        selectedOperationOpcode = instOpcode.get(indexOperation);

        if (instructionSize == 2) {
          opcode.setBits(Integer.parseInt(selectedOperationOpcode));
          auxLine = auxLine + String.valueOf(opcode.getBits()); // Escreve opcode
          if (formattedLine.length == 2) { // Utiliza um único registrador
            auxLine = auxLine + registerList.get(formattedLine[1]);
            auxLine = auxLine + "0000";
          } else {
            auxLine = auxLine + registerList.get(formattedLine[1]);
            auxLine = auxLine + registerList.get(formattedLine[2]);
          }
        } else if (instructionSize == 3 || instructionSize == 4) {
          char[] convertedValue = (toBinary(Integer.parseInt(selectedOperationOpcode))).toCharArray();

         for (int i = 0; i < 6; i++)
          opcode.setBitByIndex(i, convertedValue[i]);

          if (formattedLine[1].charAt(0) == '@') { // Indireto
            nixbpe[0] = '1';
            formattedLine[1] = formattedLine[1].replace("@", "");
  
          } else if (formattedLine[1].charAt(0) == '#') { // Imediato
            nixbpe[0] = '0';
            nixbpe[1] = '1';
            formattedLine[1] = formattedLine[1].replace("#", "");
          } else {
            nixbpe[0] = '1';
            nixbpe[1] = '1';
          }

          auxLine = auxLine + String.valueOf(opcode.getBits());
          auxLine = auxLine + String.valueOf(nixbpe);
  
          address.setBits(Integer.valueOf(formattedLine[1]));
          auxLine = auxLine + String.copyValueOf(address.getBits());
        } 

        output.add(auxLine);
      }
      stopPosition++;
    }
  }

  public static String toBinary(int value) {
    String stringValue = Integer.toBinaryString(value);
    String valueAux = String.format("%" + 8 + "s", stringValue).replace(" ", "0");
    return valueAux;
  }

  public static String[] cleanString (String line) {

    String[] lines;
    lines = line.split(" ");

    for(int i = 0; i < lines.length; i++) {
      lines[i] = lines[i].replace(" ","");
      lines[i] = lines[i].replace(",","");
    }

    return lines;
  }

  public static void readFile() throws FileNotFoundException {
    File file = new File("./test/exemplo1.txt");
    Scanner scan = new Scanner(file);

    while(scan.hasNextLine()) {
      file_content.add(scan.nextLine());
    }
    scan.close();
  }

  public static void initializeRegister() {
    registerList.put("A", "0000");
    registerList.put("X", "0001");
    registerList.put("L", "0010");
    registerList.put("B", "0011");
    registerList.put("S", "0100");
    registerList.put("T", "0101");
    registerList.put("F", "0110");
  }
}