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


	public static void main(String[] args) {
		double investimento;
		double visualizacaoMinima, visuTotal,visualizacaoMaxima,visuTotalMax;
		
		System.out.println("Informe o valor do investimento!");
		Scanner ler = new Scanner(System.in);
		investimento = ler.nextDouble();
		ler.close();
		
		visualizacaoMinima = calcVisualizacao(investimento);
		visuTotal=visualizacaoMinima;
		
		setArredonda(true);
		
		//La�o respons�vel por calcular a quantidade de visualizacao m�nima
		for(int i=0; i<4 ; i++) {
			//chamando a funcao de c�lculo da nova visualizacao passando a anterior
			visualizacaoMinima = calcNovasVisualizacao(visualizacaoMinima);
			//guardando de forma acumulativa o total de visualizacao a cada la�o
			visuTotal += visualizacaoMinima;
		}
		
		setArredonda(false);
		visualizacaoMaxima = calcVisualizacao(investimento);
		visuTotalMax=visualizacaoMaxima;
		
		//La�o respons�vel por calcular a quantidade de visualizacao m�xima
		for(int i=0; i<4 ; i++) {
			//chamando a funcao de c�lculo da nova visualizacao passando a anterior
			visualizacaoMaxima = calcNovasVisualizacao(visualizacaoMaxima);
			//guardando de forma acumulativa o total de visualizacao m�xima a cada la�o
			visuTotalMax += visualizacaoMaxima;
		}
		
		System.out.println("O total de visualiza��es m�nimas � de: "+visuTotal);
		System.out.println("O total de visualiza��es m�ximas � de: "+visuTotalMax);
		
	}
		
	
	//fun��o que calcula o visualiza��o
	public static double calcVisualizacao(double investimento) {
		double visualizacao;
		
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
		double clicks = calcClick(visualizacaoAnterior);
		double compartilhamento = calcCompartilhamento(clicks);
		double visualizacao = calcNovas_Visualizacao(compartilhamento);
		
		return visualizacao;
	}
	

}
