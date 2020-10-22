/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadepc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
    public class Cliente extends Pessoa implements Runnable {
    
    private boolean parada = false;
    private double saldo = 1000;

    public double getSaldo() {
        return saldo;
    }
    private int timestamp;
    private boolean fim;

    Cliente(String nome, int timestamp) {
       this.setNome(nome);
       this.timestamp = timestamp;
    }

    
    
    @Override
    public void Pessoa(){}
    
    
    
    @Override
    public void run(){
        try {
            
            System.out.println("Nome: "+this.getNome());
            System.out.println("Saldo: "+this.saldo);
            
                Thread.sleep(timestamp);
                
            while(parada){

                synchronized(this){
                     wait();  
                }
                if(fim){
                    Thread.interrupted();
                    break;
                  }
                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void deposito(int valor){
        
        this.saldo = this.saldo + valor;
        System.out.println("O saldo de "+this.getNome()+" é de "+this.getSaldo());
    }
    
    public void saque(int valor){
        
        if(this.saldo >= valor){
            this.saldo = this.saldo - valor;
            System.out.println("O saldo de "+this.getNome()+" é de "+this.getSaldo());
        }
    }
        
  
    public synchronized void parar(){
        this.parada = true;
        notify();
    }
    
    
    public synchronized void voltar(){
        this.parada = false;
        notify();
    }
    public synchronized void sair(){
        this.fim = true;
        notify();
    }
    
    }
