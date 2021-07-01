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
		
		//Laço responsável por calcular a quantidade de visualizacao mínima
		for(int i=0; i<4 ; i++) {
			//chamando a funcao de cálculo da nova visualizacao passando a anterior
			visualizacaoMinima = calcNovasVisualizacao(visualizacaoMinima);
			//guardando de forma acumulativa o total de visualizacao a cada laço
			visuTotal += visualizacaoMinima;
		}
		
		setArredonda(false);
		visualizacaoMaxima = calcVisualizacao(investimento);
		visuTotalMax=visualizacaoMaxima;
		
		//Laço responsável por calcular a quantidade de visualizacao máxima
		for(int i=0; i<4 ; i++) {
			//chamando a funcao de cálculo da nova visualizacao passando a anterior
			visualizacaoMaxima = calcNovasVisualizacao(visualizacaoMaxima);
			//guardando de forma acumulativa o total de visualizacao máxima a cada laço
			visuTotalMax += visualizacaoMaxima;
		}
		
		System.out.println("O total de visualizações mínimas é de: "+visuTotal);
		System.out.println("O total de visualizações máximas é de: "+visuTotalMax);
		
	}
		
	
	//função que calcula o visualização
	public static double calcVisualizacao(double investimento) {
		double visualizacao;
		
		visualizacao=30*investimento;
		
		if(isArredonda()) {
			//funcao que arredonda o quantidade de visualizacao retirando as casas decimais
			visualizacao = Math.floor(visualizacao);
		}
		return visualizacao;
	}
	
	//função que calcula a quantidade de clicks
	private static double calcClick(double visualizacao) {
		double clicks;
		
		clicks= (12*visualizacao)/100;
		
		if(isArredonda()) {
			//funcao que arredonda o quantidade de clicks retirando as casas decimais
			clicks = Math.floor(clicks);
		}
		return clicks;
	}
	
	//funçâo que calcula a quantidade de compartilhamento
	private static double calcCompartilhamento(double clicks) {
		double compartilhamento;
		
		compartilhamento = (3*clicks)/20;
		if(isArredonda()) {
			//funcao que arredonda o quantidade de compartilhamento retirando as casas decimais
			compartilhamento = Math.floor(compartilhamento);
		}
		
		return compartilhamento;
	}
	
	//função que calcula a quantidade de novas visualizações
	private static double calcNovas_Visualizacao(double compartilhamento) {
		double novVisualizacao;
		
		novVisualizacao = 40*compartilhamento;
		if(isArredonda()) {
			//funcao que arredonda o quantidade de novas visualizações retirando as casas decimais
			novVisualizacao = Math.floor(novVisualizacao);
		}
		return novVisualizacao;
	}
	
	//função que calcula a quantidade de visualizacao a partir da visualizacao anterior 
	public static double calcNovasVisualizacao(double visualizacaoAnterior) {
		double clicks = calcClick(visualizacaoAnterior);
		double compartilhamento = calcCompartilhamento(clicks);
		double visualizacao = calcNovas_Visualizacao(compartilhamento);
		
		return visualizacao;
	}
	

}
