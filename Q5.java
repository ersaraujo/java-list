import java.io.*;
import java.util.*;

abstract class Pessoa{
    
    protected String nome;
	protected String cpf;
	
	Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}

	String obterNome() {
		return this.nome;
	}
    void definirNome(String nome){
		this.nome = nome;
	};

	String obterCpf() {
		return this.cpf;
	}
	void definirCpf(String cpf){
		this.cpf = cpf;
	};
}

class Professor extends Pessoa{
	
	private String formacao;
	private String area;
	
	Professor(String nome, String cpf, String formacao, String area) {
		super(nome, cpf);
		this.formacao = formacao;
		this.area = area;
	}

	public String obterFormacao() {
		return this.formacao;
	}
    public void definirFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String obterArea() {
		return this.area;
	}
	public void definirArea(String area) {
		this.area = area;
	}

	@Override
	void definirNome(String nome) { this.nome = nome; }
	@Override
	void definirCpf(String cpf) { this.cpf = cpf; }
}

class Aluno extends Pessoa{
	
	private String matricula;
	private String curso;

	Aluno(String nome, String cpf, String matricula,String curso) {
		super(nome, cpf);
		this.matricula = matricula;
		this.curso = curso;
	}

	public String obterMatricula() {
		return this.matricula;
	}
    public void definirMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String obterCurso() {
		return this.curso;
	}
	public void definirCurso(String curso) {
		this.curso = curso;
	}

	@Override
	void definirNome(String nome) { this.nome = nome; }
	@Override
	void definirCpf(String cpf) { this.cpf = cpf; }
}

interface Colecao{
    void inserir(Pessoa p);
    int tamanhoColecaoNaoNull();
}

class ColecaoVetor implements Colecao{
    private Pessoa[] dados = new Pessoa[5];
    private int aux = 0;

    @Override
    public void inserir(Pessoa pessoa){
        if(aux < 5){
            dados[aux] = pessoa;
            aux++;
            
            int vagas = this.tamanhoColecaoNaoNull();
            if(vagas < 0){
                System.out.println("Restam" + vagas + "vagas!");
            }else{
                System.out.println("Sem vagas!");
            }
        }
    }

    @Override
    public int tamanhoColecaoNaoNull(){
        return 5 - aux;
    }

    String[] obterNomes(){
        String res[] = new String[this.aux];

        for(int i=0; i<this.aux; i++){
            res[i] = dados[i].obterNome();
        }
          
        return res;
    }
}

public class Q5 {
    public static void main(String arg[]){

        ColecaoVetor colecao = new ColecaoVetor();

        Aluno aluno1 = new Aluno("Fernando", "123.456.789-00", "fld", "engenharia da computação");
        Professor professor = new Professor("Lucas", "999.999.999-99", "lcea", "ciência da computação");
    
        colecao.inserir(aluno1);
        colecao.inserir(professor);

        String nomes[] = colecao.obterNomes();
        for(String nome: nomes) {
            System.out.println(nome);
        }
    }
}