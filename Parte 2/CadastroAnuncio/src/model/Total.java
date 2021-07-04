package model;

public class Total {

	double totalVisualizacao=0;
	double totalClicks = 0;
	double totalCompartilhamento = 0;
	
	public double getTotalVizualizacao() {
		return totalVisualizacao;
	}
	public double getTotalClicks() {
		return totalClicks;
	}
	public double getTotalCompartilhamento() {
		return totalCompartilhamento;
	}
	
	
	public void acumulaVisualizacao(double valor) {
		totalVisualizacao += valor;
	}
	
	public void acumulaClicks(double valor) {
		totalClicks+= valor;
	}
	
	public void acumulaCompartilhamento(double valor) {
		totalCompartilhamento += valor;
	}
}
