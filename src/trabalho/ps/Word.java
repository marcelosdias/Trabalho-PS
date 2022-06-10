package trabalho.ps;

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

    public void setBits(int value) { 
            String stringValue = Integer.toBinaryString(value);

            int valueLength = stringValue.length();

            if (valueLength < this.getSize()) {
                    String valueAux = String.format("%" + this.getSize() + "s", stringValue).replace(" ", "0");

                    this.bits = valueAux.toCharArray();
            }
            else 
                            this.bits = Integer.toBinaryString(value).toCharArray();
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
            int decimal = 0;

    for(int index = 0; index < bits.length; index++)
        if (bits[index] == '1') decimal += Math.pow(2, (bits.length - index - 1));

            return decimal;
    }

    public String convertBinaryToHex() {
            int decimal = convertBinaryToDecimal();

            return Integer.toHexString(decimal).toLowerCase();
    }

    public int getFormat() {
            return this.size / 8;
    }
}