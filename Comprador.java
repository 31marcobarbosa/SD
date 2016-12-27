public class Comprador extends Utilizador{
	private String nickname;
	private String pass;


	// Construtores
	public Comprador () {
		this.("", "");
	}

	public Comprador (String nickname, String pass) {
		super(username, password);
	}

	public Comprador (Comprador a) {
		super(a);
	}

	// clone 
	public Comprador clone () {
		return new Comprador (this);
	}

	//Equals 
    public boolean equals(Object o){
       if(this == o)
            return true;
       if ((o==null) || (this.getClass() != o.getClass()))
            return false;
       Comprador m = (Comprador) o;
       return (super.equals(m));
    }
    
    //toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----|COMPRADOR|----\n");
        sb.append(super.toString()).append("\n");
        return sb.toString();
    }

    /*public int hashCode(){
       return this.getEmail().hashCode();
   }*/
}