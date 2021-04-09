import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.entidades.Pessoa;
import com.servicos.Dao;

public class Teste {

	public static void main(String[] args) {
		LocalDate data = LocalDate.of(2000, 1, 2);
		Pessoa pessoa1 = new Pessoa("Jos� da Silva","12343421-09", "211111-2",Date.valueOf(data), 1.75f, 73.2f);
		Pessoa pessoa2 = new Pessoa("Maria da Joaquina","55343421-07", "431111-2",Date.valueOf(data), 1.67f, 59.8f);
		Pessoa pessoa3 = new Pessoa("Ana Maria","8871421-05", "871111-2",Date.valueOf(data), 1.70f, 62.5f);

		JOptionPane.showMessageDialog(null,Dao.findPessoaId(1));
		pessoa1.setIdPessoa(1);
		pessoa1.setNome("Jos� da Silva Jr.");
		pessoa1.setPeso(74.1f);
		Dao.updatePessoa(pessoa1);
		JOptionPane.showMessageDialog(null,Dao.findPessoaId(1));
		
		List<Pessoa> pessoas;
		pessoas = Dao.allPessoas();
		String dadosPessoas ="";
		for(Pessoa p: pessoas) {
			dadosPessoas += "\n"+p; 
		}
		JOptionPane.showMessageDialog(null, dadosPessoas);
		

		pessoas = Dao.findPessoaNome("%m%");
		dadosPessoas ="";
		for(Pessoa p: pessoas) {
			dadosPessoas += "\n"+p; 
		}
		JOptionPane.showMessageDialog(null, dadosPessoas);
		//pessoa2.setIdPessoa(2);
		//pessoa3.setIdPessoa(3);
		
		
		/*
		Dao.insertPessoa(pessoa1);
		Dao.insertPessoa(pessoa2);	
		Dao.insertPessoa(pessoa3);
		JOptionPane.showMessageDialog(null,Dao.findPessoaId(1));
		JOptionPane.showMessageDialog(null,Dao.findPessoaId(2));
		JOptionPane.showMessageDialog(null,Dao.findPessoaCPF("12343421-09"));
		JOptionPane.showMessageDialog(null,Dao.findPessoaCPF("12343421-9"));
		JOptionPane.showMessageDialog(null,Dao.findPessoaRG("211111-2"));
		JOptionPane.showMessageDialog(null,Dao.findPessoaRG("21111-2"));
		JOptionPane.showMessageDialog(null,Dao.findPessoaRG("431111-2"));
		*/
	}

}
