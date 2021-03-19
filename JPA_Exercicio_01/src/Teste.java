import javax.swing.JOptionPane;

public class Teste {
	
	static Aluno aluno;
	
	public static void main(String[] args) {
		aluno = new Aluno();
		AlunoDAO alunoDAO = new AlunoDAO();
		String menu = "0 - Sair\n"
					+ "1 - Incluir\n"
					+ "2 - Alterar\n"
					+ "3 - Excluir\n"
					+ "4 - Pesquisar por RA\n";
		int opcao = 0;
		do {
			opcao = Integer.valueOf(JOptionPane.showInputDialog(menu));
			switch (opcao) {
			case 1:
				entradaDados();
				alunoDAO.insert(aluno);
				break;
			case 2:
				entradaRA();
				aluno = alunoDAO.find(aluno.getRa());
				alunoDAO.update(aluno);
				break;
			case 3:
				entradaRA();
				alunoDAO.delete(aluno.getRa());
				break;
			case 4:
				entradaRA();
				aluno = alunoDAO.find(aluno.getRa());
				JOptionPane.showMessageDialog(null, aluno);
				break;	
			}
		} while (opcao!=0);

	}
	
	public static void entradaDados() {
		entradaRA();
		aluno.setNome(JOptionPane.showInputDialog("Nome"));
		aluno.setEmail(JOptionPane.showInputDialog("Email"));
		aluno.setCelular(JOptionPane.showInputDialog("Celular"));
		aluno.setNota1(Double.valueOf(JOptionPane.showInputDialog("Nota 1")));
		aluno.setNota2(Double.valueOf(JOptionPane.showInputDialog("Nota 2")));
	}
	
	public static void entradaRA() {
		aluno.setRa(JOptionPane.showInputDialog("RA"));
	}
}
