package classes;

import java.util.ArrayList;

public class Curso {
	
	private int idCurso;
	private String nomeCurso;
	private String turma;
	private String hora;
	private String data;
	private int capacidade;
	private Boolean iniciado;
	private ArrayList<Aluno> alunos;
	
	public Curso() {
		super();
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno aluno) {
		this.alunos.add(aluno);
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Boolean getIniciado() {
		return iniciado;
	}
	public void setIniciado(Boolean iniciado) {
		if(this.alunos.size() == this.capacidade) {
			this.iniciado = iniciado;
		}else {
			this.iniciado = false;
		}
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Curso (int id, String nome, String turma, String data, String hora, int capacidade) {
		super();
		this.idCurso = id;
		this.nomeCurso = nome;
		this.turma = turma;
		this.data = data;
		this.hora = hora;
		this.iniciado = false;
		this.capacidade = capacidade;
		this.alunos = new ArrayList<Aluno>();
	}
	public void salvarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	public void isIniciado() {
		if(this.alunos.size() == this.capacidade) {
			System.out.println("Turma Iniciada! "+this.getNomeCurso()+" , na data "+this.getData());
		}else {
			System.out.println("Turma não iniciada!, turma contem apenas "+this.alunos.size()+" Alunos.");
		}
	}
	public int vagasLivres() {
		return (this.capacidade - this.alunos.size());
	}
}
