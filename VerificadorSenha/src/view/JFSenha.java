package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import controller.VerificadorFacade;
import model.Senha;
//import skins.Estilos;
//import skins.Plataform;

public class JFSenha extends JFrame{
	public JFSenha() {
		setTitle("Verificador Senha");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(74, 76, 188, 14);
		getContentPane().add(lblNewLabel);
		
		lblSeguranca = new JLabel("");
		lblSeguranca.setBounds(74, 132, 261, 14);
		getContentPane().add(lblSeguranca);
		
		JLabel lblCripto = new JLabel("");
		lblCripto.setBounds(74, 22, 46, 14);
		getContentPane().add(lblCripto);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				verifica();
	
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		passwordField.setBounds(73, 89, 294, 20);
		
		setSize(460,250);
		getContentPane().add(passwordField);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}

	
	private void verifica() {
		
		VerificadorFacade facade = new VerificadorFacade();
		String passwordString = passwordField.getText();
		Senha senha = new Senha(passwordString);
		int nivelSeguranca = facade.verificaSenha(senha);
		String textoString = "";
		
		if(nivelSeguranca <= 0){
			lblSeguranca.setText("");
		}
		else
		if(nivelSeguranca > 0 && nivelSeguranca <= 3) {
			
			textoString = "Muito Fraca";
			lblSeguranca.setForeground(Color.RED);
			
		}
		else
			if(nivelSeguranca > 3 && nivelSeguranca <= 5) {
				
				textoString = "Fraca";
				lblSeguranca.setForeground(Color.ORANGE);
			}
		
			else
				if(nivelSeguranca > 5 && nivelSeguranca <= 7) {
					
					textoString = "Boa";
					lblSeguranca.setForeground(Color.BLUE);
				}
					else
						if(nivelSeguranca == 8 ) {
							
							textoString = "Muito Boa";
							lblSeguranca.setForeground(Color.YELLOW);
						}
		
						else
							if(nivelSeguranca == 9) {
								textoString = "Fodasticamente Foda";
								lblSeguranca.setForeground(Color.GREEN);
								
							}
		
		lblSeguranca.setText(textoString);
	}
	
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JLabel lblSeguranca ;
	
	
	public static void main(String[] args) {
			
		SwingUtilities.invokeLater(() ->{
			
			//Plataform.installSkin(Estilos.ALUMINIUM);
			new JFSenha();
			
		});
		
	}
}
