package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	public Controller() {
		super();
	}
	
	public void salvarAluno(ArrayList<Aluno> dbAlunos, Aluno aluno) {
		dbAlunos.add(aluno);
		System.out.println("Aluno: "+aluno.getNome()+" salvo com sucesso!");
	}
	
	public void salvarCurso(ArrayList<Curso> dbCursos, Curso curso) {
		dbCursos.add(curso);
		System.out.println("Curso: "+curso.getNomeCurso()+", na turma "+curso.getTurma()+" salvo com sucesso!");
	}
	
	public boolean buscarAlunoById(ArrayList<Aluno> dbAlunos, int id) {
		for(Aluno a : dbAlunos) {
			if(a.getId() == id) {
				return true;
			}
		};
		return false;
	}
	
	public int buscarIndexAlunoById(ArrayList<Aluno> dbAlunos, int id) {
		int index = 0;
		for(Aluno a : dbAlunos) {
			if(a.getId() == id) {
				return index;
			}
			index++;
		};
		return -1;
	}
	
	public Aluno retornoAlunoById(ArrayList<Aluno> dbAlunos, int id) {
		Aluno e = new Aluno();
		for(Aluno a : dbAlunos) {
			if(a.getId() == id) {
				return a;
			}
		};
		return e;
	}
	
	public boolean buscarCursoByID(ArrayList<Curso> dbCursos, int id) {
		for(Curso c : dbCursos) {
			if(c.getIdCurso() == id) {
				return true;
			}
		}
		return false;
	}
	
	public int buscarIndexCursoByID(ArrayList<Curso> dbCursos, int id) {
		int index = 0;
		for(Curso c : dbCursos) {
			if(c.getIdCurso() == id) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public Curso retornoCursoById(ArrayList<Curso> dbCursos, int id) {
		Curso cs = new Curso();
		for(Curso a : dbCursos) {
			if(a.getIdCurso() == id) {
				return a;
			}
		};
		return cs;
	}

	public void exibirCursos(ArrayList<Curso> dbCursos) {
		if(dbCursos.size() == 0) {
			System.out.println("Nenhum Curso cadastrado!");
		}else {
			for(Curso c : dbCursos) {
				System.out.println("---------------------------------------------\n"
								  +"Curso: "+c.getNomeCurso()+"\n"
								  +"ID: "+c.getIdCurso()+"\n"
								  +"Data de inicio: "+c.getData()+"\n"
								  +"Turma: "+c.getTurma()+"\n"
								  +"Hora: "+c.getHora()+"\n"
								  +"Vagas Totais: "+c.getCapacidade()+"\n"
								  +"Vagas Disponíveis: "+c.vagasLivres()+"\n"
								  +"Turma iniciada: "+c.getIniciado()+"\n"
								  +"---------------------------------------------\n");
				System.out.println("Alunos: \n");
				for(Aluno a : c.getAlunos()) {
					System.out.println(a.getNome()+"\n");
				}
			}
		}
	}
	public void cadastrarCurso(Scanner sc, ArrayList<Curso> dbCursos) {
		System.out.println("Digite o nome do Curso: \n");
		String nome = sc.next();
		System.out.println("Digite o ID para o Curso: \n");
		int id= sc.nextInt();
		System.out.println("Digite o nome da turma: \n");
		String turma = sc.next();
		System.out.println("Digite a capacidade de alunos para a turma: \n");
		int capacidade = sc.nextInt();
		System.out.println("Digite uma data para início da turma: (DD/MM/AAAA) \n");
		String data = sc.next();
		System.out.println("Digite um horário para início das atividades: (HH:MM)");
		String hora = sc.next();
		
		System.out.println("Detalhes do curso: \n"
				          +"Nome: "+nome+"\n"
				          +"ID: "+id+"\n"
				          +"Turma: "+turma+"\n"
				          +"Capacidade: "+capacidade+"\n"
				          +"Data de início: "+data+"\n"
				          +"Horário: "+hora+"\n\n"
				          +"Confirma essas informações: 1 - Sim ou 2 para Não...");
		int conf = sc.nextInt();
		
		if(conf == 1) {
			Curso cs = new Curso(id, nome, turma,data,hora, capacidade);
			this.salvarCurso(dbCursos, cs);
			System.out.println("Curso salvo com sucesso!");
		}else if(conf == 2) {
			System.out.println("Operação Cancelada!");
		}else {
			System.out.println("Opção invalida, operação cancelada!");
		}
		
	}
	public void cadastrarAluno(Scanner sc, ArrayList<Aluno> dbAlunos) {
		System.out.println("Digite o nome do Aluno: \n");
		String nome = sc.next();
		System.out.println("Digite o ID para o Aluno: \n");
		int id= sc.nextInt();
		System.out.println("Digite a idade do Aluno: \n");
		String idade = sc.next();
		
		System.out.println("Detalhes do Aluno: \n"
		          +"Nome: "+nome+"\n"
		          +"ID: "+id+"\n"
		          +"Idade: "+idade+"\n"
		          +"Confirma essas informações: 1 - Sim ou 2 para Não...");
		int conf = sc.nextInt();
		if(conf == 1) {
			Aluno al = new Aluno(id, nome, idade);
			this.salvarAluno(dbAlunos, al);
			System.out.println("Aluno salvo com sucesso!");
		}else if(conf == 2) {
			System.out.println("Operação Cancelada!");
		}else {
			System.out.println("Opção invalida, operação cancelada!");
		}
	}
	
	public void fazerMatricula(Scanner sc, ArrayList<Aluno> dbAlunos, ArrayList<Curso> dbCursos) {
		if(dbCursos.size() > 0) {
			System.out.println("Selecione o Curso desejado");
			for( Curso c : dbCursos) {
				int count = 1;
				System.out.println(count+" - "+c.getNomeCurso()+"\n");
				count++;
			}
			int index = sc.nextInt();
			Curso cs = dbCursos.get(index-1);
			System.out.println("Digite o ID do Aluno: ");
			int id = sc.nextInt();
			if(this.buscarAlunoById(dbAlunos, id)) {
				Aluno al = this.retornoAlunoById(dbAlunos, id);
				this.confirmarTudo(sc, dbAlunos, dbCursos, al, cs);
			}else {
				System.out.println("Aluno não Cadastrado na base de dados, deseja fazer o cadastro?\n"
									+"1 para sim ou qualquer número para não...");
				int conf = sc.nextInt();
				if(conf == 1) {
					this.cadastrarAluno(sc, dbAlunos);
					System.out.println("Digite o ID do Aluno para realizar a Matricula: ");
					int idn = sc.nextInt();
					Aluno aln = this.retornoAlunoById(dbAlunos, idn);
					this.confirmarTudo(sc, dbAlunos, dbCursos, aln, cs);
				}else {
					System.out.println("Operação Cancelada!");
				}
			}
		}else {
			System.out.println("Nenhum curso cadastrado!");
		}
	}
	public void confirmarTudo(Scanner sc, ArrayList<Aluno> dbAlunos, ArrayList<Curso> dbCursos, Aluno al, Curso cs) {
		System.out.println("Confirma a matricula do aluno(a): "+al.getNome()+" no curso "+cs.getNomeCurso()+"? \n"
						  +"1 para sim ou qualquer número para não...");
		int conf = sc.nextInt();
		if(conf == 1) {
			int indexCurso = this.buscarIndexCursoByID(dbCursos, cs.getIdCurso());
			cs.setAlunos(al);
			dbCursos.add(indexCurso, cs);
			
			System.out.println("Matricula realizada com sucesso!");
		}else {
			System.out.println("Operação Cancelada!");
		}
	}
	public void exbirAluno(Scanner sc, ArrayList<Aluno> dbAlunos) {
		System.out.println("Digite o ID do Aluno: ");
		int id = sc.nextInt();
		Aluno al = this.retornoAlunoById(dbAlunos, id);
		if(al.getNome().equals("")) {
			System.out.println("Aluno não cadastrado!");
		}else{
			System.out.println("Nome: "+al.getNome()+"\n"
					          +"Idade:"+al.getIdade()+"\n"
					          +"ID: "+al.getId()+"\n\n");
		}
	}
	public void exibirCurso(Scanner sc, ArrayList<Curso> dbCursos) {
		System.out.println("Digite o ID do Curso: ");
		int id = sc.nextInt();
		Curso cs = this.retornoCursoById(dbCursos, id);
		
		if(cs.getNomeCurso().equals("")) {
			System.out.println("Nenhum Curso cadastrado!");
		}else {
				System.out.println("---------------------------------------------\n"
								  +"Curso: "+cs.getNomeCurso()+"\n"
								  +"ID: "+cs.getIdCurso()+"\n"
								  +"Data de inicio: "+cs.getData()+"\n"
								  +"Turma: "+cs.getTurma()+"\n"
								  +"Hora: "+cs.getHora()+"\n"
								  +"Vagas Totais: "+cs.getCapacidade()+"\n"
								  +"Vagas Disponíveis: "+cs.vagasLivres()+"\n"
								  +"Turma iniciada: "+cs.getIniciado()+"\n"
								  +"---------------------------------------------\n");
				System.out.println("Alunos: \n");
				for(Aluno a : cs.getAlunos()) {
					System.out.println(a.getNome()+"\n");
				}
		}
	}
}
