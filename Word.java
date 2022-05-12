package projetoPS;

public class Word {
	private char[] bits;
	private int size;
	
	public Word(int memoryLength) {
		this.bits = new char[memoryLength];
		this.size = memoryLength;
	}

	public void listBits() { // Debug
		for (int i = 0; i < this.size; i++)
			System.out.print(this.bits[i]);

		System.out.println();
	}
	
	public void setBits(char[] bits) {
		this.bits = bits;
	}
	
    public void setBits(int b){
        this.bits = Integer.toBinaryString(b).toCharArray();
    }
	
	public void setBitByIndex(int index, char value) {
		this.bits[index] = value;
	}
	
	public char[] getBits() {
		return this.bits;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public char getValueByIndex(int index) {
		return this.bits[index];
	} 
	
	public int convertBinaryToDecimal() {
		String convertedArray = new String(this.bits);
		
		return Integer.parseInt(convertedArray, 2);
	}
	
	public String convertBinaryToHex() {
		String convertedArray = new String(this.bits);
		
		return Integer.toString(Integer.parseInt(convertedArray, 2), 16);
	}
	
	public int getFormat() {
		return this.size / 8;
	}
}


