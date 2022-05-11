package projetoPS;

public class Memory {
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
	
	// Retornar uma palavra
	public void getWord(int address) {
		int i;
		for (i = address; i < (address + 3); i++) {
			System.out.print("Address " + i + ": ");
			this.memory[i].listBits();
		}
	}
	
	public void resetMemory() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < 8; j++)
				this.memory[i].setBitByIndex(j, '0');
		}
	}
}


