

public class Comprador extends Utilizador{

        // Construtores
    public Comprador () {
        super("", "", false);
    }

    public Comprador (String username, String password, boolean logged) {
        super(username, password, logged);
    }

    public Comprador (Comprador a) {
        super(a);
    }

    // clone 
    public Comprador clone () {
        return new Comprador(this);
    }

    //Equals 
    @Override
    public boolean equals(Object o){
       if(this == o)
            return true;
       if ((o==null) || (this.getClass() != o.getClass()))
            return false;
       Comprador m = (Comprador) o;
       return (super.equals(m));
    }
    
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----|COMPRADOR|----\n");
        sb.append(super.toString()).append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode(){
       return this.getUsername().hashCode();
   }
}