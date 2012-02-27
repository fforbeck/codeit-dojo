package br.com.codeit.dojo;

public class ContadorPalitos {

//	private int ladoDireito = 1;
//	private int ladoEsquerdo = 1;

	public String contar(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Número não natural.");
		}
		
		if (isNumeroPrimo(valor)) {
			return montarPalitos(valor);
		}
		
		if (raizExata(valor)) {
			return solucaoMultiplicacao((int)Math.sqrt(valor));
		}
		
		return solucaoGeral(valor);
		
//		return "";
	}
	
	private String solucaoGeral(int valor) {
		int [] divisores = new int[valor/2];
		int divisor = 2;
		int i = 0;
		while (valor != 1) {
			if (valor % divisor == 0) {
				valor /= divisor;
				divisores[i] = divisor;
				i++;
			} else {
				divisor++;
			}
		}
		
		int primeiraParte = divisores[0];
		for (int j = 1; j < i-1; j++) {
			primeiraParte *= divisores[j]; 
		}
	
		return montarPalitos(primeiraParte) + "x" + montarPalitos(divisores[i-1]);
	}

//	private void incrementaLados() {
//		if (ladoEsquerdo == ladoDireito) {
//			ladoEsquerdo++;
//		} else {
//			ladoDireito++;
//		}
//	}

	private boolean isNumeroPrimo(int valor) {
		if (valor <= 3) {
			return true;
		}
		
		for (int i = 2; i <= (valor / 2); i++) {
			if ((valor % i) == 0) {
				return false;
			}
		}
		
		return true;
	}

	private String solucaoMultiplicacao(int sqrt) {
		return montarPalitos(sqrt) + "x" + montarPalitos(sqrt);
	}

	private boolean raizExata(int valor) {
		Double sqrt = Math.sqrt(valor);
		return sqrt - sqrt.intValue()  == 0.0;
	}

	private String solucaoSoma(int ladoDireito, int ladoEsquerdo) {
		String solucaoSemOperacao = montarPalitos(ladoEsquerdo);
		String solucaoSemOperacao2 = montarPalitos(ladoDireito);
		return solucaoSemOperacao + "+" + solucaoSemOperacao2;
	}

	private String solucaoMultiplicacao(int ladoDireito, int ladoEsquerdo) {
		String solucaoSemOperacao = montarPalitos(ladoEsquerdo);
		String solucaoSemOperacao2 = montarPalitos(ladoDireito);
		return solucaoSemOperacao + "x" + solucaoSemOperacao2;
	}
	
	private int soma(int ladoDireito, int ladoEsquerdo) {
		return ladoDireito + ladoEsquerdo;
	}

	private int multiplica(int ladoDireito, int ladoEsquerdo) {
		return ladoDireito * ladoEsquerdo;
	}

	private String montarPalitos(int valor) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < valor; i++) {
			sb.append("|");
		}
		return sb.toString();
	}

}
