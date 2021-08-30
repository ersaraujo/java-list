import java.io.*;
import java.util.*;

interface Expression {
    String avaliar();
    String imprimirArvore();
}

class ExprAritmetica implements Expression {
    static final String OPERATION_PRIORITY = "/*-+";
    String expressao;
  
    ExprAritmetica(String expr) {
      this.expressao = expr;
    }
  
    public String obterExpressao() { 
        return this.expressao; 
    }
    public void definirExpressao(String expr) {
        this.expressao = expr;
    }
    
    @Override
    public String toString(){
      return "ExprAritmetica " + this.hashCode() + ": " + this.obterExpressao();
    }
  
    public String avaliar(){
        for(int i=3; i>=0; i--){
            if(this.expressao.contains(String.valueOf(OPERATION_PRIORITY.charAt(i)))){
                exprAux aux = new exprAux();
                String[] args = aux.split(this.expressao, OPERATION_PRIORITY.charAt(i));
  
                Expression e1 = new ExprAritmetica(args[0]);
                double v1 = Double.parseDouble(e1.avaliar());
  
                Expression e2 = new ExprAritmetica(args[1]);
                double v2 = Double.parseDouble(e2.avaliar());
  
                if(i == 0){
                    return "" + (v1/v2);
                }else if(i == 1){
                    return "" + (v1*v2);  
                }else if(i == 2){
                    return "" + (v1-v2);
                }else{
                    return "" + (v1+v2);
                } 
            }
        }
        return this.expressao;
    }
  
    public String imprimirArvore(){
        for(int i=3; i>=0; i--){
            if(this.expressao.contains(String.valueOf(OPERATION_PRIORITY.charAt(i)))){
                exprAux aux = new exprAux();
                String[] args = aux.split(this.expressao, OPERATION_PRIORITY.charAt(i));
        
                Expression e1 = new ExprAritmetica(args[0]);
                String exp1 = e1.imprimirArvore();
        
                Expression e2 = new ExprAritmetica(args[1]);
                String exp2 = e2.imprimirArvore();
        
                return "(" + exp1 + OPERATION_PRIORITY.charAt(i) + exp2 + ")";
            }
        }
  
        return "(" + this.expressao + ")";
    }
}

class exprAux{
    public String[] split(String str, char c){
        String[] res = new String[2];
    
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c){
                res[0] = str.substring(0, i);
                res[1] = str.substring(i+1, str.length());
                return res;
            }
        }
    
        res[0] = str;
        return res;
    }
    
      
    String booleanEval(boolean value){
        if(value){
            return "True";
        }else{
            return "False";
        } 
    }
}

class ExprLogica implements Expression {
    static final String[] OPERATIONS = {">", "<", "<=", ">=", "==", "!="};
    String expressao;
  
    ExprLogica(String expr) {
      this.expressao = expr;
    }
  
    public void definirExpressao(String expr) {
        this.expressao = expr; 
    }
    public String obterExpressao() {
        return this.expressao; 
    }
  
    @Override
    public String toString(){
      return "ExprLogica " + this.hashCode() + ": " + this.obterExpressao();
    }
  
    public String avaliar(){
        String[] args = {"", ""};
    
        for(int i=0; i<6; i++){
            if(this.expressao.contains(OPERATIONS[i])){
            args = this.expressao.split(OPERATIONS[i]);
            }
        }
    
        Expression arit1 = new ExprAritmetica(args[0]);
        double v1 = Double.parseDouble(arit1.avaliar());
    
        Expression arit2 = new ExprAritmetica(args[1]);
        double v2 = Double.parseDouble(arit2.avaliar());
    
        exprAux aux = new exprAux();
        if(this.expressao.contains(">")) return aux.booleanEval(v1 > v2);
            else if(this.expressao.contains("<"))  return aux.booleanEval(v1 < v2);
            else if(this.expressao.contains(">=")) return aux.booleanEval(v1 >= v2);
            else if(this.expressao.contains("<=")) return aux.booleanEval(v1 <= v2);
            else if(this.expressao.contains("==")) return aux.booleanEval(v1 == v2);
            else return aux.booleanEval(v1 != v2);
        }
  
    public String imprimirArvore(){
        for(int i=0; i<6; i++){
            if(this.expressao.contains(OPERATIONS[i])){
                String[] args = this.expressao.split(OPERATIONS[i]);
                Expression arit1 = new ExprAritmetica(args[0]);
                Expression arit2 = new ExprAritmetica(args[1]);
  
                return "(" + arit1.imprimirArvore() + OPERATIONS[i] + arit2.imprimirArvore() + ")";
            }
        }
  
        Expression arit = new ExprAritmetica(this.expressao);
        return arit.imprimirArvore();
    }
}

public class Q6{
    public static void main(String args[]) {
        
        Expression t1 = new ExprAritmetica("2*3+4/6");
        System.out.println(t1);
        System.out.println(t1.avaliar());
        System.out.println(t1.imprimirArvore());

        Expression t2 = new ExprLogica("2+5/10<12+16");
        System.out.println(t2);
        System.out.println(t2.avaliar());
        System.out.println(t2.imprimirArvore());
    }
}