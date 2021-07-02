import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class calculadora {
	private static boolean arredonda;
	
	public static boolean isArredonda() {
		return arredonda;
	}

	public static void setArredonda(boolean arredonda) {
		calculadora.arredonda = arredonda;
	}
	
	//m�todo principal 
	//para realiza��o dos testes descomente a linha mainTeste
	public static void main(String[] args) {
		//mainTeste(args);
		mainUsuario(args);
	}
	
	//funcao principal para realizar os testes unitarios 
	public static void mainTeste(String[] args) {
		Teste.teste();
	}
	
	//funcao principal para interacao com usu�rio
	public static void mainUsuario(String[] args) {
		double investimento;
		double visuMin, visuMax;
		
		System.out.println("Informe o valor do investimento!");
		Scanner ler = new Scanner(System.in);
		
		investimento = ler.nextDouble();
		while(investimento <= 0) {
			System.out.println("Digite um valor maior que zero!");
			investimento = ler.nextDouble();
		}
		visuMin=calcVisualizacaoMinima(investimento);
		ler.close();
		visuMax=calcVisualizacaoMaxima(investimento);
			
		System.out.println("O total de visualiza��es m�nimas � de: "+visuMin);
		System.out.println("O total de visualiza��es m�ximas � de: "+visuMax);
		
	}
	
	//fun��o que calcula a visualizacao total
	public static double calcVisualizacaoTotal(double investimento) {
		double visualizacao,visuTotal;
		
		if(investimento < 0) {
			return 0;
		}
		
		visualizacao = calcVisualizacao(investimento);
		visuTotal=visualizacao;
		//La�o respons�vel por calcular a quantidade de visualizacao m�nima
		for(int i=0; i<4 ; i++) {
			//chamando a funcao de c�lculo da nova visualizacao passando a anterior
			visualizacao = calcNovasVisualizacao(visualizacao);
			//guardando de forma acumulativa o total de visualizacao a cada la�o
			visuTotal += visualizacao;
		
		}
		return visuTotal;
	}
	
	//calcula a visualizacao m�nima
	public static double calcVisualizacaoMinima(double investimento) {
		double totalVisu;
		
		setArredonda(true);
		totalVisu = calcVisualizacaoTotal(investimento);
		
		return totalVisu;
	}
	
	//calcula a visualizacao maxima
	public static double calcVisualizacaoMaxima(double investimento) {
		double totalVisu; 
		
		setArredonda(false);
		totalVisu = calcVisualizacaoTotal(investimento);
		
		return totalVisu;
	}
	
	//fun��o que calcula o visualiza��o
	public static double calcVisualizacao(double investimento) {
		double visualizacao;
		if(investimento < 0) {
			return 0;
		}
		visualizacao=30*investimento;
		
		if(isArredonda()) {
			//funcao que arredonda o quantidade de visualizacao retirando as casas decimais
			visualizacao = Math.floor(visualizacao);
		}
		return visualizacao;
	}
	
	//fun��o que calcula a quantidade de clicks
	private static double calcClick(double visualizacao) {
		double clicks;
		
		clicks= (12*visualizacao)/100;
		
		if(isArredonda()) {
			//funcao que arredonda o quantidade de clicks retirando as casas decimais
			clicks = Math.floor(clicks);
		}
		return clicks;
	}
	
	//fun��o que calcula a quantidade de compartilhamento
	private static double calcCompartilhamento(double clicks) {
		double compartilhamento;
		
		compartilhamento = (3*clicks)/20;
		if(isArredonda()) {
			//funcao que arredonda o quantidade de compartilhamento retirando as casas decimais
			compartilhamento = Math.floor(compartilhamento);
		}
		
		return compartilhamento;
	}
	
	//fun��o que calcula a quantidade de novas visualiza��es
	private static double calcNovas_Visualizacao(double compartilhamento) {
		double novVisualizacao;
		
		novVisualizacao = 40*compartilhamento;
		if(isArredonda()) {
			//funcao que arredonda o quantidade de novas visualiza��es retirando as casas decimais
			novVisualizacao = Math.floor(novVisualizacao);
		}
		return novVisualizacao;
	}
	
	//fun��o que calcula a quantidade de visualizacao a partir da visualizacao anterior 
	public static double calcNovasVisualizacao(double visualizacaoAnterior) {
		if(visualizacaoAnterior <  0) {
			return 0;
		}
		double clicks = calcClick(visualizacaoAnterior);
		double compartilhamento = calcCompartilhamento(clicks);
		double visualizacao = calcNovas_Visualizacao(compartilhamento);
		
		return visualizacao;
	}
	
	//classe para teste
	public static class Teste {
		private static void teste() {
			ArrayList<Double> entradas = new ArrayList<>();
			ArrayList<Double>saidas = new ArrayList<>();
			ArrayList<Double>saidasMax = new ArrayList<>();
			
			//entradas gerais
			entradas.add(-1.0);
			entradas.add(0.0);
			entradas.add(1.0);
			
			//saidas esperadas no minimo
			saidas.add(0.0);
			saidas.add(0.0);
			saidas.add(30.0);
			
			//saidas para m�ximo
			saidasMax.add(0.0);
			saidasMax.add(0.0);
			saidasMax.add(86.41159680000001);
			
			for(int i = 0; i < entradas.size(); i++) {
				//se a sa�da esperada for atendida
				if(calcVisualizacaoMinima(entradas.get(i)) == saidas.get(i)) {
					System.out.println("Passou no teste "+i+ " da fun��o m�nima");
				}
				else {
					System.out.println("N�o passou no teste "+ i + " da fun��o m�nima");
				}
				
				if(calcVisualizacaoMaxima(entradas.get(i)) == saidasMax.get(i)) {
					System.out.println("Passou no teste "+i+ " da fun��o m�xima");
				}
				else {
					System.out.println("N�o passou no teste "+i+ " da fun��o m�xima");
				}
			}
		}
	}
}
