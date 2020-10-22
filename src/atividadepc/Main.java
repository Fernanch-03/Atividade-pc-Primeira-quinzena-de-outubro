/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadepc;

/**
 *
 * @author Fernando
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Fernando",1000);
        Cliente c2 = new Cliente("Cláudio",1000);
        Cliente c3 = new Cliente("Veridiane",1000);
        
        Thread ct1 = new Thread(c1);
        
        Thread ct2 = new Thread(c2);
        
        Thread ct3 = new Thread(c3);
        
        
        c1.deposito(500);
        c2.deposito(500);
        c3.saque(500);
        c3.deposito(300);
        c1.saque(1500);
        c1.deposito(300);
        c1.saque(500);
        c1.deposito(300);
        c1.saque(500);
        c3.deposito(1300);
        c2.saque(250);
        c1.saque(500);
        c2.deposito(1300);
        c2.saque(250);
        ct2.start();
        c1.saque(500);
        c3.deposito(1300);
        c3.saque(250);
        ct3.start();
        c1.deposito(1300);
        c1.saque(250);
        ct1.start();
        
        
        
        
        
        
        
        
        
        

       
        
    }
    
}
