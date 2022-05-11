package projetoPS;

public class Main {


	public static void main(String[] args) {
		Memory memory = new Memory(2048);

		Register A = new Register(24, 0, "A");
		Register X = new Register(24, 1, "X");
		Register L = new Register(24, 2, "L");
		Register B = new Register(24, 3, "B");
		Register S = new Register(24, 4, "S");
		Register T = new Register(24, 5, "T");
		Register F = new Register(48, 6, "F");
		Register PC = new Register(24, 8, "PC");
		Register SW = new Register(24, 9, "SW");	
	}
}
