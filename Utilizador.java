
import java.io.Serializable;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public abstract class Utilizador implements Serializable
{
   private String username, password;
   private boolean logged;
   private Socket s;
   private PrintWriter output;
   
   public Utilizador(String username, String password, boolean logged){
       this.username = username;
       this.password = password;
       this.logged = logged;
  }
    
   public Utilizador(){
       this("","", false);
   }
   
   public Utilizador(Utilizador u){
       this.username = u.getUsername();
       this.password = u.getPassword();
       this.logged = u.getLogged();
   }

   public void send(String msg){
      output.println(msg);
   }
    
   public Socket getS(){
      return s;
   }

   public void setS(Socket s) throws IOException{
      this.s = s;
      output = new PrintWriter(s.getOutputStream(), true);
   }

   public String getPassword(){
      return password;
    }
    
    public String getUsername() {
      return username;
    }

    public boolean getLogged() {
      return logged;
    }

   public void setPassword(String password){
      this.password = password;
    }
    
   public void setUsername(String username) {
      this.username = username;
   }

   public void setLogged(boolean logged) {
      this.logged = logged;
   }
    
   public boolean equals(Object o){
       if(this == o)
            return true;
       if ((o==null) || (this.getClass() != o.getClass()))
            return false;
       Utilizador m = (Utilizador) o;
       return (this.password.equals(m.getPassword()) &&
               this.username.equals(m.getUsername()));
   }
   
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Password: ").append(password).append("\n");
        sb.append("Username: ").append(password).append("\n");
        return sb.toString();
    }
    
   @Override
   public abstract Utilizador clone();
   
   /*public int hashCode(){
       return this.email.hashCode();
   }*/
}