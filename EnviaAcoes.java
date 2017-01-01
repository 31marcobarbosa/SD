package trabSD;


import java.io.Serializable;
import java.util.HashMap;



public class EnviaAcoes implements Serializable {

    private final String accao;
    private final HashMap<String,String> argumentos;
// string 1 -> comando para o servidor 
// string 2 -> 
    
    public EnviaAcoes(String accao, HashMap<String,String> args){
        this.accao = accao;
        this.argumentos = args;
     }

    

    public String getAccao(){
        return accao;
        }

    

    public HashMap<String,String> getArgumentos(){
         return argumentos;
        }
}