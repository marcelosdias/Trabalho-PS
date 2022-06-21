package trabalho.ps.Montador;

public class Register extends Word {
	private int id;
	private String name;

	public Register (int registerLength, int id, String name) {
		super(registerLength);
		this.id = id;
		this.name = name;
		
		this.resetRegister();
	}
	
	public void showRegister() {
		System.out.println("Nome do Registrador: " + this.name);
		System.out.println("Identificador: " + this.id);
		System.out.print("Conteudo: ");
		super.listBits();
	}
	
	public void resetRegister() {
		for (int i = 0; i < super.getSize(); i++)
			super.setBitByIndex(i, '0');
	}
}