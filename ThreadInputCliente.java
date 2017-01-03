

import java.io.*;
import java.net.*;
import java.util.concurrent.locks.*;

public class ThreadInputCliente extends Thread {
    private Socket s;
    private PrintWriter output;
    private Menu menu;
    private BufferedReader br;
    private ReentrantLock lock;
    private Condition cn;

    public ThreadInputCliente (Socket s, ReentrantLock lock, Condition cn, Menu menu){
        try{
            this.output = new PrintWriter(s.getOutputStream(), true);
            this.br = new BufferedReader(new InputStreamReader(System.in));
            this.lock = lock;
            this.s = s;
            this.cn = cn;
            this.menu = menu;
         }catch(IOException e){
            System.out.println(e.getMessage());
         }
    }
    
    @Override
    public void run() {
        
        try{
            menu.Manager();
            String input;
            while((input = br.readLine()) != null){
                if(menu.getOption() == 0){
                    if(input.equals("1")){ //Comprador
                        output.println("Comprador");
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("2")){ //Vendedor
                        output.println("Vendedor");
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){ //Sair
                        output.println("Sair");
                        break;
                    }
                    else{
                        System.out.println("Opção inválida");
                    }
                }
                else if(menu.getOption() == 1){ //LoginComprador
                    if(input.equals("1")){ //Entrar Comprador
                        output.println("LogarComprador");
                        System.out.println("Username: "); 
                        input = br.readLine();
                        output.println(input);
                        System.out.println("Password: ");
                        input = br.readLine();
                        output.println(input);
                        
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("2")){ //Registar Comprador
                        output.println("RegistarComprador");
                        System.out.println("Introduza um username: ");
                        input = br.readLine();
                        output.println(input);
                        System.out.println("Introduza uma password: ");
                        input = br.readLine();
                        output.println(input);
                        
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){ //Sair
                        break;
                    }
                    else{
                        System.out.println("Opção inválida");
                    }
                }
                else if(menu.getOption() == 2){ //Login Vendedor
                    if(input.equals("1")){ //Entrar Vendedor
                        output.println("LogarVendedor");
                        System.out.println("Username: "); 
                        input = br.readLine();
                        output.println(input);
                        System.out.println("Password: ");
                        input = br.readLine();
                        output.println(input);
                        
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("2")){ //Registar Vendedor
                        output.println("RegistarVendedor");
                        System.out.println("Introduza um username: ");
                        input = br.readLine();
                        output.println(input);
                        System.out.println("Introduza uma password: ");
                        input = br.readLine();
                        output.println(input);
                        
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){ //Sair
                        break;
                    }
                    else{
                        System.out.println("Opção inválida");
                    }
                }
                else if(menu.getOption() == 3){ //MenuComprador
                    if(input.equals("1")){
                        output.println("EscolherLeilao");
                        System.out.println("Introduza o ID do leilão: ");
                        input = br.readLine();
                        output.println(input);
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("2")){ //Consultar
                        output.println("ConsultarLeilao");
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){ //Logout
                        output.println("LogoutComprador");
                        break;
                    }
                    else{
                        System.out.println("Opção Inválida");
                    }
                }
                else if(menu.getOption() == 4){ //MenuVendedor
                    if(input.equals("1")){
                        output.println("IniciarLeilao");
                        System.out.println("Introduzir preço inicial");
                        input = br.readLine();
                        output.println(input);
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("2")){ //Consultar
                        output.println("ConsultarLeilao");
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){
                        output.println("LogoutVendedor");
                        break;
                    }
                    else{
                        System.out.println("Opção Inválida");
                    }
                }
                else if(menu.getOption() == 5){ //Leilao Comprador
                    if(input.equals("1")){ //Licitar
                        output.println("FazerLicitação");
                        System.out.println("Valor: ");
                        input = br.readLine();
                        output.println(input);
                        
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){ //Sair
                        break;
                    }
                    else{
                        System.out.println("Opção Inválida");
                    }
                }
                else if(menu.getOption() == 6) { //Leilao Vendedor
                    if(input.equals("1")){
                        output.println("FinalizarLeilao");
                        this.lock.lock();
                        cn.await();
                        this.lock.unlock();
                        clear();
                        menu.Manager();
                    }
                    else if(input.equals("0")){
                        break;
                    }
                    else{
                        System.out.println("Opção Inválida");
                    }
                }
            }
            s.shutdownOutput();
        }catch(Exception e){
                    System.out.println(e.getMessage());
        }
    }
    
    private void clear(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }
}