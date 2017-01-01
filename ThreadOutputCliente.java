/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabSD;

/**
 *
 * @author Houdini
 */

import java.lang.Thread;
import java.util.ResourceBundle;
import java.util.concurrent.locks.*;
import java.io.*;
import java.net.*;

public class ThreadOutputCliente {
    private BufferedReader br;
    private Menu menu;
    private ReentrantLock lock;
    private Condition cn;
    
    public ThreadOutputCliente(BufferedReader br, Menu menu, ReentrantLock lock, Condition cn){
        this.br = br;
        this.menu = menu;
        this.lock = lock;
        this.cn = cn;
    }
    
    public void run() throws Exception{
            String input;
            while((input = br.readLine()) != null){
                System.out.println("\n"+linha+"\n");
                if(input.equals("Comprador seleccionado")){
                    menu.setOption(1);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Vendedor seleccionado")){
                    menu.setOption(2);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Iniciou sessão como Comprador")){
                    menu.setOption(3);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Iniciou sessão como Vendedor")){
                    menu.setOption(4);
                    this.locl.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Comprador entrou no leilão")){
                    menu.setOption(5);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Vendedor iniciou um leilão")){
                    menu.setOption(6);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Consultar leilão")){
                    //Ver isto
                    }
                else if(input.equals("Sair") || input.equals("Username inválido") || input.equals("Password inválido")){
                    menu.setOption(0);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
            }
    }
}

