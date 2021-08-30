import java.io.*;
import java.util.*;

//Class Livro
abstract class Livro{

    private int ano;
    private String titulo;
    private String ISBN;
    private String autor;
    private String editora;

    // Getters
    public int obterAno(){
        return this.ano;
    }
    public String obterTitulo(){
        return this.titulo;
    }
    public String obterISBN(){
        return this.ISBN;
    }
    public String obterAutor(){
        return this.autor;
    }
    public String obterEditora(){
        return this.editora;
    }

    // Setters
    public void definirAno(int ano){
        this.ano = ano;
    }
    public void definirTitulo(String titulo){
        this.titulo = titulo;
    }
    public void definirISBN(String isbn){
        this.ISBN = isbn;
    }
    public void definirAutor(String autor){
        this.autor = autor;
    }
    public void definirEditora(String editora){
        this.editora = editora;
    }
}

//Class LivroLivraria.
class LivroLivraria{
    
    boolean venda = true;
    
    public void venderLivro(){
        if(this.venda == true){
            System.out.println("Venda disponivel");
        }else{
            System.out.println("Venda indisponivel");
            this.venda = false;
        }
    }
}

// Class LivroBiblioteca.
class LivroBiblioteca{
    
    boolean emprestimo;

    public void emprestarLivro(){
        if(this.emprestimo == true){
            System.out.println("Emprestimo disponivel");
        }else{
            System.out.println("Emprestimo indisponivel");
            this.emprestimo = false;
        }
    }
}

public class Q1 {
    public static void main(String[] args){

        LivroLivraria livro1 = new LivroLivraria();
        // teste de venda
        livro1.venderLivro(); 
        livro1.venderLivro();

        LivroBiblioteca livro2 = new LivroBiblioteca();
        // teste de emprestimo
        livro2.emprestarLivro(); 
        livro2.emprestarLivro();
    }
}

