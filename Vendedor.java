

public class Vendedor extends Utilizador {

    public Vendedor(String username, String password, boolean logged){
        super(username, password, logged);
    }
    
    public Vendedor(){
        this("","", false);
    }
    
    public Vendedor(Vendedor v){
        super(v);
    }

    public Vendedor clone(){
        return new Vendedor(this);
    }
    
    public boolean equals(Object o){
       if(this == o)
            return true;
       if ((o==null) || (this.getClass() != o.getClass()))
            return false;
       Vendedor m = (Vendedor) o;
       return (super.equals(m));
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----|VENDEDOR|----\n");
        sb.append(super.toString()).append("\n");
        return sb.toString();
    }
    
    /*public int hashCode(){
       return this.getEmail().hashCode();
   }*/
}