import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

public class ThreadInputServidor extends Thread {
	private Socket s;
	private CasaLeiloes cs;
	private PrintWriter output;
	private Comprador comprador;
    private Vendedor vendedor;
	private BufferedReader br;
	private ReentrantLock lock;
	private Condition cn;
    private Mensagem mensagem;


	public ThreadInputServidor (BufferedReader br, Socket s, CasaLeiloes cs, ReentrantLock lock, Condition cn, PrintWriter output, Mensagem mensagem){
            this.s = s;
            this.cs = cs;
            this.output = output;
            this.br = br;
            this.lock = lock;
            this.cn = cn;
            this.mensagem = mensagem;
            vendedor = new Vendedor();
            comprador = new Comprador();
    }	

    public void LoginVendedor(){
        try{
            String username = br.readLine();
            String password = br.readLine();
            vendedor.setUsername(username);
            vendedor.setPassword(password);
            vendedor.setLogged(cs.LoginVendedor(username, password));
            if(vendedor.getLogged()){
                System.out.println("Iniciou sessão como Vendedor");
                output.println("Vendedor");
            }
            else{
                System.out.println("Erro ao logar");
                output.println("Erro");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void LoginComprador(){
        try{
            String username = br.readLine();
            String password = br.readLine();
            comprador.setUsername(username);
            comprador.setPassword(password);
            comprador.setLogged(cs.LoginComprador(username, password));
            if(comprador.getLogged()){
                System.out.println("Iniciou sessão como Comprador");
                comprador.setS(s);
                output.println("Comprador");
            }
            else{
                System.out.println("Erro ao logar");
                output.println("Erro");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void RegistarVendedor(){
        try{
            String username = br.readLine();
            String password = br.readLine();
            boolean res;
            vendedor.setUsername(username);
            vendedor.setPassword(password);
            res = cs.registaVendedor(username,password);
            if(res){
                System.out.println("Vendedor Registado com Sucesso");
                output.println("RegistarVendedor");
            }
            else{
                System.out.println("Utilizador já registado");
                output.println("Utilizador já registado");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void RegistarComprador(){
        try{
            String username = br.readLine();
            String password = br.readLine();
            comprador.setUsername(username);
            comprador.setPassword(password);
            boolean res;
            res = cs.registaComprador(username,password);
            if(res){
                System.out.println("Comprador Registado com Sucesso");
                output.println("RegistarComprador");
            }
            else{
                System.out.println("Utilizador já registado");
                output.println("Utilizador já registado");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void LogoutVendedor(){
        try{
            cs.logoutVendedor(vendedor.getUsername());
            System.out.println("Logout efetuado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void LogoutComprador(){
        try{
            cs.logoutComprador(comprador.getUsername());
            System.out.println("Logout efetuado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void IniciarLeilao(){
        try{
            String username = vendedor.getUsername();
            float pInicial = Integer.parseInt(br.readLine());
            float max = pInicial;
            System.out.println(username);
            cs.IniciaLeilao(username,pInicial,max);
            System.out.println("Leilão Iniciado");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }  
    }
    
    public void FinalizarLeilao(){
        try{
            String username = vendedor.getUsername();
            cs.FinalizarLeilao(username);
            System.out.println("Leilão Acabado");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void Licitar(int id_leilao) {
        try{
            if(id_leilao != -1){
            boolean r;
            float valor = Integer.parseInt(br.readLine());
            String username = comprador.getUsername();
            r = cs.FazLicitaçao(valor,id_leilao, comprador);
            if(r){
            System.out.println("Licitação Efetuada");
            output.println("Licitar");
            }
            else{
                System.out.println("Erro ao Licitar");
                output.println("Erro");
            }
            }
            else{
                System.out.println("Erro");
                output.println("Erro");
            }
        } catch (IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void EscolherLeilao(int id_leilao) {
        try{
            boolean r;
            r = cs.EscolheLeilao(id_leilao);
            if(r){
                System.out.println("Entrou no leilão");
                output.println("EscolherLeilao");
            }
            else{
                System.out.println("Leilão inexistente");
                output.println("LeilaoInexistente");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void Consultar(){
        try{
            String r;
            r = cs.ConsultaLeilao();
            System.out.println("Consultou leilões");
            mensagem.setMsg(r);
            output.println("Consultar");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        @Override
    public void run () {
    	try{ 
    	    int id_leilao = 0;
            String leitura;
    	    while ((leitura = br.readLine()) != null){
                mensagem.setMsg(leitura);
                if((leitura.equals("Comprador"))){
                    System.out.println("Comprador seleccionado");
                    output.println("Comprador");
                }
                else if(leitura.equals("Vendedor")){
                    System.out.println("Vendedor seleccionado");
                    output.println("Vendedor");
                }
                else if (leitura.equals("LogarVendedor")) {
                    LoginVendedor();
                    output.println("LogarVendedor");
                } 
                else if(leitura.equals("LogarComprador")){
                    LoginComprador();
                    output.println("LogarComprador");
    	        }
                else if(leitura.equals("RegistarVendedor")){
                    RegistarVendedor();
                    output.println("RegistarVendedor");
                }
                else if (leitura.equals("RegistarComprador")){
                    RegistarComprador();
                    output.println("RegistarComprador");
                }
                else if (leitura.equals("LogoutVendedor")) {
                    LogoutVendedor();
                    output.println("Logout");
                }
                else if (leitura.equals("LogoutComprador")) {
                    LogoutComprador();
                    output.println("Logout");
                }
                else if (leitura.equals("ConsultarLeilao")) {
                    Consultar();
                    output.println("ConsultarLeilao");
                }
                else if (leitura.equals("IniciarLeilao")) {
                    IniciarLeilao();
                    output.println("IniciarLeilao");
                }
                else if (leitura.equals("FinalizarLeilao")) {
                    FinalizarLeilao();
                    output.println("FinalizarLeilao");
                }
                else if (leitura.equals("FazerLicitação")) {
                    Licitar(id_leilao);
                } 
                else if (leitura.equals("EscolherLeilao")){
                    id_leilao = Integer.parseInt(br.readLine());
                    EscolherLeilao(id_leilao);
                }
                else if (leitura.equals("Voltar")){
                    System.out.println("Voltar");
                    output.println("Voltar");
                }
                else if (leitura.equals("Sair")){
                    System.out.println("Sair");
                    output.println("Sair");
                }
            }
    	}catch(IOException | NumberFormatException e){ 
    		 System.out.println(e.getMessage());
    	}
    }

    private void clear() {
    	for (int i=0;i<50;i++){
    		System.out.println();
    	}
    }
}