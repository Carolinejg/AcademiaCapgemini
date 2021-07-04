package model;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

//classe com os atributos da entidade Anuncio
public class Anuncio {
	private String nome;
	private String cliente;
	private Date dataInicio;
	private Date dataFinal;
	private double investimentoPorDia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(java.util.Date  dataInicio) {
		this.dataInicio = new Date(dataInicio.getTime());
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(java.util.Date dataFinal) {
		this.dataFinal = new Date(dataFinal.getTime());
	}
	
	public double getInvestimentoPorDia() {
		return investimentoPorDia;
	}
	public void setInvestimentoPorDia(double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	
	//função que calcula o total de todos os parametros (compartiilhamento, visualização e clicks)
	//recebe o investimento total
	public static Total calcTotal(double investimentoTotal) {
		Total total = new Total();
		double visualizacao;
		
		if(investimentoTotal < 0) {
			return null;
		}
		
		visualizacao = calcVisualizacao(investimentoTotal);
		total.acumulaVisualizacao(visualizacao);
		//Laço responsável por calcular a quantidade de visualizacao
		for(int i=0; i<4 ; i++) {
			Total totalTemp;
			//chamando a funcao de cálculo da nova visualizacao passando a anterior
			totalTemp = calcNovasVisualizacao(visualizacao);
			total.acumulaVisualizacao(totalTemp.getTotalVizualizacao());
			total.acumulaClicks(totalTemp.getTotalClicks());
			total.acumulaCompartilhamento(totalTemp.getTotalCompartilhamento());
			visualizacao = totalTemp.getTotalVizualizacao();
		}
		return total;
	}
	
	//função que calcula a visualização
		public static double calcVisualizacao(double investimento) {
			double visualizacao;
			if(investimento < 0) {
				return 0;
			}
			visualizacao=30*investimento;
			
			
		return visualizacao;
	}
		
	//função que calcula a quantidade de visualizacao a partir da visualizacao anterior 
	public static Total calcNovasVisualizacao(double visualizacaoAnterior) {
		Total total = new Total();
		
		if(visualizacaoAnterior <  0) {
			return null;
		}
		double clicks = calcClick(visualizacaoAnterior);
		total.acumulaClicks(clicks);
		double compartilhamento = calcCompartilhamento(clicks);
		total.acumulaCompartilhamento(compartilhamento);
		double visualizacao = calcNovas_Visualizacao(compartilhamento);
		total.acumulaVisualizacao(visualizacao);
		
		return total;
	}
	
	//função que calcula a quantidade de clicks
	private static double calcClick(double visualizacao) {
		double clicks;
		
		clicks= (12*visualizacao)/100;
		
		return clicks;
	}
		
	//funçâo que calcula a quantidade de compartilhamento
	private static double calcCompartilhamento(double clicks) {
		double compartilhamento;
		
		compartilhamento = (3*clicks)/20;
		return compartilhamento;
	}
	
	//função que calcula a quantidade de novas visualizações
	private static double calcNovas_Visualizacao(double compartilhamento) {
		double novVisualizacao;
		
		novVisualizacao = 40*compartilhamento;
		return novVisualizacao;
	}
	
	//funcão que calcula a quantidade de dias 
	public long calcularDias() {
		TimeUnit timeUnit = TimeUnit.DAYS;
		long diffInMillies = getDataFinal().getTime() - getDataInicio().getTime();
		long dias = timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
		return dias;
	}
	
	//função que calcula o investimento total
	public double investimentoTotal(double investimentoInicial) {
		double investimentoTotal=0;
		long dias = calcularDias();
		
		investimentoTotal = investimentoInicial*dias;
		
		return investimentoTotal;
	}
		
}
