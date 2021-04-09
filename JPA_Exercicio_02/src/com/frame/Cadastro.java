package com.frame;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entidades.Pessoa;
import com.servicos.Dao;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Cadastro {

	private JFrame frame;
	private JTextField txtfIdPessoa;
	private JTextField txtfNome;
	private static Cadastro window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void findPessoaId() {
		Pessoa pessoa = Dao.findPessoaId(Integer.valueOf(window.txtfIdPessoa.getText()));
		if (pessoa != null) {
			window.txtfIdPessoa.setText(pessoa.getIdPessoa()+"");
			window.txtfNome.setText(pessoa.getNome());
		} else {
			window.txtfIdPessoa.setText(null);
			window.txtfNome.setText(null);
			JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
		}
	}
	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id Pessoa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 61, 86, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(365, 61, 86, 30);
		frame.getContentPane().add(lblNome);
		
		txtfIdPessoa = new JTextField();
		txtfIdPessoa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				findPessoaId();
			}
		});
		txtfIdPessoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtfIdPessoa.setBounds(131, 61, 77, 30);
		frame.getContentPane().add(txtfIdPessoa);
		txtfIdPessoa.setColumns(10);
		
		txtfNome = new JTextField();
		txtfNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtfNome.setColumns(10);
		txtfNome.setBounds(435, 61, 327, 30);
		frame.getContentPane().add(txtfNome);
	}
}
