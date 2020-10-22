package controller;

import model.Senha;

public class VerificadorFacade {
	
	private Senha senha;
	private int nivelSeguranca = 0;
	
	public void setSenha(Senha senha) {
		this.senha = senha;
	}
	
	private boolean contaisDigit(String texto) {
		
		boolean retorno = false;
		char[] vetor = texto.toCharArray();
		
		for (int a = 0; a < vetor.length; a++) {
		
			if(Character.isDigit(vetor[a])) {
			
				retorno = true;
			}	
		}
		return retorno;
	}
	
	private boolean contaisAlphabetic(String texto) {
		
		boolean retorno = false;
		char[] vetor = texto.toCharArray();
		
		for (int a = 0; a < vetor.length; a++) {
			
			if(Character.isAlphabetic(vetor[a])) {
				retorno = true;
			}	
		}
		return retorno;
	}
	
	private boolean contaisUpper(String texto) {
		
		boolean retorno = false;
		char[] vetor = texto.toCharArray();
		
		for (int a = 0; a < vetor.length; a++) {
			
			if(Character.isUpperCase((vetor[a]))) {
				retorno = true;
			}	
		}
		return retorno;
	}
	
	
	private boolean contaisEspecial(String texto) {
		
		boolean retorno = false;
		char[] vetor = texto.toCharArray();
		
		for (int a = 0; a < vetor.length; a++) {
			
			if(!Character.isLetterOrDigit((vetor[a]))) {
				retorno = true;
			}	
		}
		return retorno;
	}
	
	public int verificaSenha(Senha senha) {
		
		
		
		
		String passString = senha.getPassword();
		System.out.println(passString.length());
		System.out.println();
		
		if(passString.length() >  0 && passString.length() < 6 ) {
			
			nivelSeguranca = 1;
			
		}else
			if(passString.length() >= 6 && passString.length() < 8) {
				
				nivelSeguranca = 2;
				
			}else
		if(passString.length() >= 8 ) {
				
				nivelSeguranca = 3;
				
			}
		
		if(contaisAlphabetic(passString)) {
			nivelSeguranca += 1; 
			System.out.println("alfabeto");
		}
		
		if(contaisDigit(passString)) {
			nivelSeguranca +=1;
			System.out.println("digito");
		}
		
		if(contaisEspecial(passString)) {
			nivelSeguranca += 2;
			System.out.println("especial");
		}
		
		if(contaisUpper(passString)) {
			nivelSeguranca += 2;
			System.out.println("maiuscula");
		}
		
		
		
		return nivelSeguranca;
	}
	
	

}
