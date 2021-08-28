import java.io.*;
import java.util.*;

class Conta{
    protected int id;
    protected String agencia.
    protected Senha senha;

    Conta(int id, String agencia, Senha senha){
        this.id = id;
        this.agencia = agencia;
        this.senha = senha;
    }

    protected int obterId() { return this.id; }
    protected void definirId(int id) {
        this.id = id;
    }

    protected String obterAgencia() { return this.agencia; }
    protected void definirAgencia(String agencia) { 
        this.agencia = agencia; 
    }

    protected Senha obterSenha() { 
        return this.senha; 
    }
    protected void definirSenha(Senha senha)    { this.senha = senha; }
    protected void definirSenha(int numerica)   { this.senha.definirNumerica(numerica); }
    protected void definirSenha(String alfanumerica) { this.senha.definirAlfanumerica(alfanumerica); }
}

class Senha{
    protected String alfanumerica;
    protected int numerica;
  
    Senha(String alfanumerica, int numerica) {
      this.alfanumerica = alfanumerica;
      this.numerica = numerica;
    }
  
    protected void definirAlfanumerica(String alfanumerica) {
        this.alfanumerica = alfanumerica; 
    }
    protected String obterAlfanumerica() {
        return this.alfanumerica;
    }
  
    protected void definirNumerica(int numerica) {
        this.numerica = numerica;
    }
    protected int obterNumerica() {
        return this.numerica;
    }
}

public class questao4 {
    public static void main(String args[]) {
      Conta conta = new Conta(1234, "abc", new Senha("A1B2C3", 123456));
  
      System.out.println(conta.definirSenha().obterAlfanumerica());
      System.out.println(conta.definirId());
  
      conta.setSenha("Nova Senha de Letras");
      System.out.println(conta.obterSenha().obterAlfanumerica());
    }
  }