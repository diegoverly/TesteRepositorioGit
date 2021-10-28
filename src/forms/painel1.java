package forms;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import DAL.Conection;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class painel1 extends JFrame {
	
	PreparedStatement pst2 = null;

	private JPanel contentPane;
	private JTable table;
	Connection conexao = null;
	ResultSet rs2 = null;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	painel1 frame = new painel1();
					//frame.setVisible(true);
					tela tela = new tela();
					tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public painel1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Preencher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				conexao = Conection.conector();
				
				 
		        String sql2 = "select * from TBUSUARIOS ORDER BY IDUSER";
		        
		        try {
		            
		            pst2 = conexao.prepareStatement(sql2,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //Essas duas configurações do ResultSet serve para permitir que a navegação do registro seja feita para frente e para trás
		            rs2 = pst2.executeQuery();
		            
		            
		            table.setModel(DbUtils.resultSetToTableModel(rs2));
		            
		            
		            
		            
		        } catch (Exception erro) {
		            
		            JOptionPane.showMessageDialog(null, "Erro!" +  erro.toString());
		        }
				
				
				
			}
		});
		btnNewButton.setBounds(37, 32, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(37, 92, 887, 438);
		contentPane.add(table);
	}
}
