package projetoPS;

import java.util.Arrays;
import java.util.List;

public class Memory {
	private static List<String> inst2Format = Arrays.asList("90", "4", "a0", "9c", "98", "ac", "a4", "a8", "94", "B8");
	private Word[] memory;
	private int size;
	
	public Memory (int memorySize) {
		this.memory = new Word[memorySize];
		this.size = memorySize;
		
		for (int i = 0; i < memorySize; i++)
			this.memory[i] = new Word(8);
		
		this.resetMemory();
	}
	
	// Retorna o objeto memória	
	public Word[] getMemory() {
		return this.memory;
	}
	
	public void memoryWrite(int address, int numberBytes, Word value) {
		int k = 0;
		for (int i = 0; i < numberBytes; i++) 
			for (int j = 0; j < 8; j++) 
				this.memory[address + i].setBitByIndex(j, value.getValueByIndex(k++));
	}

	// Listar toda a memória
	public void listMemory() { // Debug
		for (int i = 0; i < this.size; i++) {
			System.out.print("Address " + i + ": ");
			this.memory[i].listBits();
		}
	}
	
	public Word readMemory(int address) {
		Word selectedOpcode = new Word(8);
		
		int instructionFormat = 0;
		
		for (int i = 0; i < 8; i++)
			selectedOpcode.setBitByIndex(i, this.memory[address].getValueByIndex(i));
		
		if (isFormat2(selectedOpcode.convertBinaryToHex()))
			instructionFormat = 2;
		else 
			if (this.memory[address + 1].getValueByIndex(3) == 0)	
				instructionFormat = 3;
			else
				instructionFormat = 4;
		
		Word instruction = new Word(instructionFormat * 8);
				
		for (int i = 0, j = 0; i < instructionFormat; i++) 
			for (int k = 0; k < 8; k++)
				instruction.setBitByIndex(j++, this.memory[address + i].getValueByIndex(k));
		
		return instruction;
	}
	
	public void resetMemory() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < 8; j++)
				this.memory[i].setBitByIndex(j, '0');
		}
	}
	
	public static boolean isFormat2(String opcode) {
		return inst2Format.contains(opcode);
	}
}


