
public class Teste {

	public static void main(String[] args) {
		AlunoDAO alunoDAO = new AlunoDAO();
		//alunoDAO.insert(new Aluno("1234-X","Jose","jose@gmail.com", "(11)9999-8888", 5.5, 8));
		//alunoDAO.insert(new Aluno("0987-Y","Ana","ana@gmail.com", "(11)7777-8888", 6, 8.5));
		//alunoDAO.insert(new Aluno("0111-K","Pedro","pedro@gmail.com", "(11)6666-8888", 6, 8.5));

		//System.out.println(alunoDAO.find("1234-X"));
		//System.out.println(alunoDAO.find("0987-Y"));
		//System.out.println(alunoDAO.find("0111-K"));
		
		alunoDAO.delete("0111-K");
		alunoDAO.update(new Aluno("1234-X","Jose da Silva JR","jose.silva@gmail.com", "(11)9999-7799", 5.6, 8.2));
		alunoDAO.updateQuery(new Aluno("0987-Y","Ana Maria Braga","ana.maria@gmail.com", "(11)7777-8888", 7.2, 7.5));

		for (Aluno aluno: alunoDAO.getAlunos()) {
			System.out.println(aluno);
		}
	}
}
