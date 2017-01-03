/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Houdini
 */

import java.util.concurrent.locks.*;
import java.io.*;

public class ThreadOutputCliente extends Thread{
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
    
    public void run(){
        try{
            String input;
            while((input = br.readLine()) != null){
                if(input.equals("Comprador")){
                    menu.setOption(1);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Vendedor")){
                    menu.setOption(2);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("RegistarComprador")){
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("RegistarVendedor")){
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("LogarComprador")){
                    menu.setOption(3);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("LogarVendedor")){
                    menu.setOption(4);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("EscolherLeilao")){
                    menu.setOption(5);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("IniciarLeilao")){
                    menu.setOption(6);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("FinalizarLeilao")) {
                    menu.setOption(4);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Consultar leilão")){
                    //Ver isto
                }
                else if(input.equals("Licitar")){
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("LeilaoInexistente")){
                    menu.setOption(3);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Consultar")){
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Voltar")){
                    menu.setOption(3);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Erro") || input.equals("Utilizador já registado") || input.equals(("Logout"))){
                    menu.setOption(0);
                    this.lock.lock();
                    cn.signal();
                    this.lock.unlock();
                }
                else if(input.equals("Sair")){
                    System.exit(1);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

