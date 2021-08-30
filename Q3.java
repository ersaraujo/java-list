import java.io.*;
import java.util.*;

enum Genero{
    CIS{
        @Override
        public String toString() {
            return "Cisgênero";
        }
    },
    TRANS {
        @Override
        public String toString() {
            return "Transgênero";
        }
      },
    FLUID {
        @Override
        public String toString() {
          return "Gênero fluido";
        }
      },
    NONBIN {
        @Override
        public String toString() {
          return "Não-binário";
        }
    }
}

class Pessoa{

    private String nome;
    private String grauEscolaridade;
    private String orientacaoSexual;
    private char sexoBiologico;
    private int idade;
    
    Genero genero;
    
    Pessoa() {}
    Pessoa(String nome, int idade, String grauEscolaridade, String orientacaoSexual, char sexoBiologico, Genero genero) {
        this.nome = nome;
        this.grauEscolaridade = grauEscolaridade;
        this.orientacaoSexual = orientacaoSexual;
        this.sexoBiologico = sexoBiologico;
        this.idade = idade;
        this.genero = genero;
    }

    // Nome
    public void definirNome(String nome){
        this.nome = nome;
    }
    public String obterNome(){
        return this.nome;
    }
    // Grau de escolaridade
    public void definirGrauEsc(String grauEsc){
        this.grauEscolaridade = grauEsc;
    }
    public String obterGrauEsc(String grauEsc){
        return this.grauEscolaridade;
    }
    // Orientação sexual
    public String obterOrientacao(){
        return this.orientacaoSexual;
    }
    // Sexo biologico
    public char obterSexo(){
        return this.sexoBiologico;
    }
    // Idade
    public void definirIdade(int idade){
        this.idade = idade;
    }
    public int obterIdade(){
        return this.idade;
    }
    // Genero
    public Genero obterGenero(){
        return this.genero;
    }

    public void dormir(){   System.out.println("Dormindo...."); }
    public void cagar(){    System.out.println("Cagando...."); }
    public void comer(){    System.out.println("Comendo...."); }
    public void estudar(){  System.out.println("Estudando...."); }
    public void viver(){    System.out.println("Vivendo...."); }
    public void sobreviver(){   System.out.println("Sobrevivendo...."); }
    public void trabalhar(){    System.out.println("Trabalhando...."); }
}

public class Q3 {
    public static void main(String[] args){
        Pessoa ana = new Pessoa();
        ana = new Pessoa("Ana", 17, "Medio completo", "Hetero", 'M', Genero.CIS);

        ana.dormir();
        ana.cagar();
        ana.comer();
        ana.estudar();
        ana.viver();
        ana.sobreviver();
        ana.trabalhar();
    }
}