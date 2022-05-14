import java.util.*;


public class Machine {
	private static Memory memory = new Memory(2048);
	
	protected static Register register1 = new Register(4, 10, "R1");
	protected static Register register2 = new Register(4, 11, "R2");     
	
	protected static Register A = new Register(24, 0, "A");
	protected static Register X = new Register(24, 1, "X");
	protected static Register L = new Register(24, 2, "L");
	protected static Register B = new Register(24, 3, "B");
	protected static Register S = new Register(24, 4, "S");
	protected static Register T = new Register(24, 5, "T");
	protected static Register F = new Register(48, 6, "F");
	protected static Register PC = new Register(24, 8, "PC");
	protected static Register SW = new Register(24, 9, "SW");	
	
	private static Word address = new Word(20);
	private static Word opcode = new Word(8);
	private static Word nixbpe = new Word(6);
	
	public static void main(String[] args) {
		Word inst;
		
		String str1 = new String("1001000000010000"); // Instrução

		String str2 = new String("000000000000000000000011"); // Conteudo do Registrador A
		String str3 = new String("000000000000000000000011"); // Conteudo do Registrador L
		
        char[] auxInt = str1.toCharArray();
        char[] auxR1 = str2.toCharArray();
        char[] auxR2 = str3.toCharArray();

    	Word aux = new Word(16);
    	
    	aux.setBits(auxInt);
    	
    	A.setBits(auxR1);
    	X.setBits(auxR2);
    	      
        memory.memoryWrite(PC.convertBinaryToDecimal(), 2, aux);

        inst = nextInstruction();
        
        runOperations(inst.getFormat());
        
		System.out.println(A.convertBinaryToDecimal());
	}

	public static Word nextInstruction() {
		Word instruction = memory.readMemory(PC.convertBinaryToDecimal());
		
		if (instruction.getFormat() == 2) {
			for (int i = 0; i < 8; i++)
				opcode.setBitByIndex(i, instruction.getValueByIndex(i));
			
			getRegisters(instruction);
		}
		else {
			for (int i = 0; i < 6; i++)
				opcode.setBitByIndex(i, instruction.getValueByIndex(i));
			
			for (int i = 6, j = 0; i < 12; i++) 
				nixbpe.setBitByIndex(j++, instruction.getValueByIndex(i));
		}
		
		PC.setBits(PC.convertBinaryToDecimal() + instruction.getFormat());

		return instruction;
	}
	
	public static void getAddress(Word instruction) {
		Word formattedAddress = new Word(instruction.getFormat() == 3 ? 12 : 20);
		
		if (instruction.getFormat() == 3)
			for (int i = 12, j = 0; i < 24; i++) 
				formattedAddress.setBitByIndex(j++, instruction.getValueByIndex(i));
		else
			for (int i = 12, j = 0; i < 32; i++) 
				formattedAddress.setBitByIndex(j++, instruction.getValueByIndex(i));
		
		address.setBits(addressMode(formattedAddress.convertBinaryToDecimal()));
	}
	
	public static int addressMode(int selectedAddress) {
		if (nixbpe.getValueByIndex(0) == '1' && nixbpe.getValueByIndex(1) == '1') { // Direto
			if (nixbpe.getValueByIndex(2) == '1') {
				if (nixbpe.getValueByIndex(3) == '1') 
					return X.convertBinaryToDecimal() + B.convertBinaryToDecimal() + selectedAddress;
				 else if (nixbpe.getValueByIndex(4) == '1') 
					return X.convertBinaryToDecimal() + PC.convertBinaryToDecimal() + selectedAddress;
				 else 
					return X.convertBinaryToDecimal() + selectedAddress;
				
			} else if (nixbpe.getValueByIndex(3) == '1') 
				return B.convertBinaryToDecimal() + selectedAddress;
			else if (nixbpe.getValueByIndex(4) == '1') 
				return PC.convertBinaryToDecimal() + selectedAddress;
			else 
				return selectedAddress;
		} else if (nixbpe.getValueByIndex(0) == '1' && nixbpe.getValueByIndex(1) == '0') { // Indireto
			return memory.readMemory(selectedAddress).convertBinaryToDecimal();
		} else if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') { // Imediato
			return selectedAddress;
		} // Olhar Instruções simples do SIC
		return 0;
	}
	
	public static void getRegisters(Word instruction) {
		for (int i = 8, j = 0; i < 12; i++) 
			register1.setBitByIndex(j++, instruction.getValueByIndex(i));

		for (int i = 12, j = 0; i < 16; i++) 
			register2.setBitByIndex(j++, instruction.getValueByIndex(i));
	}
	
	public static Register selectedRegister(Register selectedRegister) {
		switch (selectedRegister.convertBinaryToDecimal()) {
			 case 0:
	             return A;
	         case 1:
	             return X;
	         case 2:
	             return L;
	         case 3:
	             return B;
	         case 4:
	             return S;
	         case 5:
	             return T;
	         case 6:
	             return F;
	         default:
	             return null;
		}
	}
	
	public static void runOperations(int instructionFormat) {
		switch (instructionFormat) {
			case 2:
				switch (opcode.convertBinaryToHex()) {
					case "90":
						addr(selectedRegister(register1), selectedRegister(register2));
						break;
						
					case "4":
						clear(selectedRegister(register1));
						break;
					case "a0":
						compr(selectedRegister(register1), selectedRegister(register2));
						break;
						
					case "9c":
						divr(selectedRegister(register1), selectedRegister(register2));
						break;
					case "98":
						mulr(selectedRegister(register1), selectedRegister(register2));
						break;
					case "ac":
						rmo(selectedRegister(register1), selectedRegister(register2));
						break;
					case "a4":
						shiftl(selectedRegister(register1), selectedRegister(register2).convertBinaryToDecimal());
						break;
					case "a8":
						shiftr(selectedRegister(register1), selectedRegister(register2).convertBinaryToDecimal());
						break;
					case "94":
						subr(selectedRegister(register1), selectedRegister(register2));
						break;
					case "B8":
						tixr(selectedRegister(register1));
						break;
				}
			case 3: break;
			case 4: break;
		}
	}
	
	// Inicio das operações de 2 bytes
	public static void addr(Register selectedRegister1, Register selectedRegister2) {
		selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() + selectedRegister1.convertBinaryToDecimal());
	}
	
	public static void clear(Register register) {
		register.setBits(0);
	}
	
	public static void compr(Register selectedRegister1, Register selectedRegister2) {
		if (selectedRegister1.convertBinaryToDecimal() == selectedRegister2.convertBinaryToDecimal())
			SW.setBits(1);
		else if (selectedRegister1.convertBinaryToDecimal() > selectedRegister2.convertBinaryToDecimal())
			SW.setBits(2);
		else
			SW.setBits(3);
	}
	
	public static void divr(Register selectedRegister1, Register selectedRegister2) {
		selectedRegister2.setBits( selectedRegister2.convertBinaryToDecimal() / selectedRegister1.convertBinaryToDecimal());
	}
	
	public static void mulr(Register selectedRegister1, Register selectedRegister2) {
		selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() * selectedRegister1.convertBinaryToDecimal());
	}
	
	public static void rmo(Register selectedRegister1, Register selectedRegister2) {
		selectedRegister2.setBits(selectedRegister1.convertBinaryToDecimal());
	}
	
	public static void shiftl(Register selectedRegister1, int n) {
		selectedRegister1.setBits(selectedRegister1.convertBinaryToDecimal() << n);
	}
	
	public static void shiftr(Register selectedRegister1, int n) {
		selectedRegister1.setBits(selectedRegister1.convertBinaryToDecimal() >> n);
	}
	
	public static void subr(Register selectedRegister1, Register selectedRegister2) {
		selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() - selectedRegister1.convertBinaryToDecimal());
	}
	
	public static void tixr(Register selectedRegister1) {
		compr(selectedRegister(register1), selectedRegister(register2));
		
		X.setBits(X.convertBinaryToDecimal() + 1);
	}
	
	// Fim das operações de 2 bytes
	
	//inicio das operações de 3/4 bytes
	
	public static void add (int address) {		
		//verificar se é endereçamento indireto
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() + address);
		}		
		//caso não for indireto, lê da memória
		else {
			Word data = new Word(24);
			//lê da memória
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() + data_from_memory.convertBinaryToDecimal());											
		}				
	}
	
	public static void and (int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() & address );
		}		
		else {
			Word data = new Word(24);
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() & data_from_memory.convertBinaryToDecimal());											
		}				
	}
	
	public static void comp (int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			if (A.convertBinaryToDecimal() == address) {
				SW.setBits(1);
			}
			else if (A.convertBinaryToDecimal() > address) {
				SW.setBits(2);
			}
			else {
				SW.setBits(3);
			}			
		}
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			
			if (A.convertBinaryToDecimal() == address) {
				SW.setBits(1);
			}
			else if (A.convertBinaryToDecimal() > address) {
				SW.setBits(2);
			}
			else {
				SW.setBits(3);
			}	
		}		
	}	
	
	public static void div(int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() / address );
		}		
		//caso não for direto, lê da memória
		else {
			Word data = new Word(24);
			//lê da memória
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() / data_from_memory.convertBinaryToDecimal());											
		}		
		
	}
	
	public static void j(int address) {
		PC.setBits(address);
	}
	
	public static void jeq(int address) {
		if (SW.convertBinaryToDecimal() == 1) 
			PC.setBits(address);	
	}
	
	public static void jgt(int address) {
		if (SW.convertBinaryToDecimal() == 2) 
			PC.setBits(address);	
	}
	
	public static void jlt(int address) {
		if (SW.convertBinaryToDecimal() == 3) 
			PC.setBits(address);	
	}
	
	public static void jsub(int address) {
		L.setBits(PC.getBits());
		PC.setBits(address);		
	}
	
	public static void lda(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(address);
		}
		
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			A.setBits(data_from_memory.convertBinaryToDecimal());	
		}		
	}
	
	public static void ldb(int address) {
			
			if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
				B.setBits(address);
			}
			
			else {
				Word data_from_memory = memory.readMemory(address, 3);
				B.setBits(data_from_memory.convertBinaryToDecimal());	
			}		
	}
	
	public static void ldch(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(address);
		}
		else {
			Word data_from_memory = memory.readMemory(address +2, 1);
			A.setBits(data_from_memory.convertBinaryToDecimal());
		}		
	}
	
	public static void ldl(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			L.setBits(address);
		}
		
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			L.setBits(data_from_memory.convertBinaryToDecimal());	
		}		
	}
	
	public static void lds(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			S.setBits(address);
		}
		
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			S.setBits(data_from_memory.convertBinaryToDecimal());	
		}		
	}
	
	public static void ldt(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			T.setBits(address);
		}
		
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			T.setBits(data_from_memory.convertBinaryToDecimal());	
		}		
	}
	
	public static void ldx(int address) {
		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			X.setBits(address);
		}
		
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			X.setBits(data_from_memory.convertBinaryToDecimal());	
		}		
	}
	
	public static void mul(int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() * address );
		}		

		else {
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() * data_from_memory.convertBinaryToDecimal());											
		}		
		
	}
	
	public static void or (int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() | address );
		}		
		else {
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() | data_from_memory.convertBinaryToDecimal());											
		}				
	}
	
	public static void rsub() {
		PC.setBits(L.getBits());
	}
	
	public static void sta(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, A);
	}
	
	public static void stb(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, B);
	}
	
	public static void stch(int address, int instruc_size) {		
		//seria o byte mais à direita (address + 2)? 
		memory.memoryWrite(address + 2, instruc_size, A);
	}
	
	public static void stl(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, L);
	}
	
	public static void sts(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, S);
	}
	
	public static void stt(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, T);
	}
	
	public static void stx(int address, int instruc_size) {
		memory.memoryWrite(address, instruc_size, X);
	}
	
	public static void sub (int address) {		
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			A.setBits(A.convertBinaryToDecimal() - address);
		}		
		else { 
			//lê da memória
			Word data_from_memory = memory.readMemory(address, 3); 
			A.setBits(A.convertBinaryToDecimal() - data_from_memory.convertBinaryToDecimal());											
		}				
	}
	
	public static void tix(int address) {
		if(nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {			
			if (X.convertBinaryToDecimal() == address) {
				SW.setBits(1);
			}
			else if (X.convertBinaryToDecimal() > address) {
				SW.setBits(2);
			}
			else {
				SW.setBits(3);
			}			
		}
		else {
			Word data_from_memory = memory.readMemory(address, 3);
			if (X.convertBinaryToDecimal() == address) {
				SW.setBits(1);
			}
			else if (X.convertBinaryToDecimal() > address) {
				SW.setBits(2);
			}
			else {
				SW.setBits(3);
			}	
		}	
		//deve ser incrementado antes ou depois?
		X.setBits(X.convertBinaryToDecimal() + 1);
	}
	
	//Fim das operações do tipo 3/4	
}






