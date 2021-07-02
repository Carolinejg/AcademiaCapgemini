package model;

import java.sql.Date;

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
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public double getInvestimentoPorDia() {
		return investimentoPorDia;
	}
	public void setInvestimentoPorDia(double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}
	
}
