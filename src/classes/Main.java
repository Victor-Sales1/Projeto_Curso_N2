package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Aluno> dbAlunos = new ArrayList<Aluno>();
		ArrayList<Curso> dbCursos = new ArrayList<Curso>();
		
		Scanner sc = new Scanner(System.in);
		Boolean ext = false;
		Controller conn = new Controller();
			
		while(ext == false){
			System.out.println("---------------------SisCur--------------------\n"
							  +"Exibir Cursos - 1"+"\n"
							  +"Cadastrar Curso - 2 \n"
							  +"Cadastrar Aluno - 3 \n"
							  +"Fazer matricula - 4 \n"
							  +"Buscar Aluno por ID - 5 \n"
							  +"Buscar Curso por ID - 6 \n"
							  +"SAIR e encerrar - 0\n"
							  +"-------------------------------------------------");
			int input = sc.nextInt();
			
			switch(input) {
			case 0:
				ext = true;
				break;
			case 1:
				conn.exibirCursos(dbCursos);
				break;
			case 2:
				conn.cadastrarCurso(sc, dbCursos);
				break;
			case 3:
				conn.cadastrarAluno(sc, dbAlunos);
				break;
			case 4:
				conn.fazerMatricula(sc, dbAlunos, dbCursos);
				break;
			case 5:
				conn.exbirAluno(sc, dbAlunos);
				break;
			case 6:
				conn.exibirCurso(sc, dbCursos);
				break;
			default:
				System.out.println("Opção Invalida!");
			}
		}
	}

}
