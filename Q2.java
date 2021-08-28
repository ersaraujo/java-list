import java.io.*;
import java.util.*;

class Texto{

    private String texto;
    Texto(String texto){
        this.texto = texto;
    }

    public String obterTexto(){
        return this.texto;
    }
    public String definirTexto(String texto){
        this.texto = texto;
    }

    public void imprimir(){
        System.out.println(texto);
    }

    public int contarPalavras(){
        int palavras = 0;
        int aux = 0;

        for(char c: this.texto.toCharArray()){
            if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9')){
                aux +=1;
            }else{
                if(aux > 0){
                    palavras++;
                }
            }
        }
        if(aux > 0){
            palavras++;
        }
        return palavras;
    }

    public int contarFreq(String palavra){
        int FreqPalavra = 0;
        
        int tamPalavra = palavra.length();
        int tamTexto = this.texto.length();

        for(int i = 0; i+tamPalavra <= tamTexto; i++){
            if(this.texto.substring(i, i+tamPalavra).equals(palavra)){
                freqPalavra++;
            }
        }
        return freqPalavra;
    }

    public void substituirPalavra(String palavraO, Strings palavraD){
        string novoTexto = "";

        int tamPalavra = palavraO.length();
        int tamTexto = this.texto.length();

        for(int i = 0; i+tamPalavra <= tamTexto; i++){
            if(this.texto.substring(i, i+tamPalavra).equals(palavraO)){
                novoTexto += palavraD;
                i += tamPalavra-1;
            }else{
                novoTexto += this.texto.charAt(i);
            }
        }
        this.texto = novoTexto;
    }
}

public class questao2{
    public static void main(String[] args){
        Texto texto = new Texto("bau tchica bau au, falou o meu amor! bau au au");
        texto.imprimir();
        
        System.out.println("Quantidade de palavras: ");
        System.out.println(texto.contarPalavras());
        
        System.out.println("A frenquencia da palavra bau: ");
        System.out.println(texto.FreqPalavra("bau"))

        texto.substituirPalavra("au", "bau");
        texto.imprimir();
    }
}