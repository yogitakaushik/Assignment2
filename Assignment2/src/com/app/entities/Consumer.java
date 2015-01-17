/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entities;

import com.app.main.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.app.main.Main.l1;

/**
 *
 * @author yogita
 */
public class Consumer implements Runnable {

    // private  static List<Integer> l1=new ArrayList<Integer>();
    public void run() {

        synchronized (l1) {

            while (Main.running) {

                while (l1.isEmpty()) {
                    System.out.println("List is empty");
                    try {
//                 Thread.sleep(1000);
                        l1.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Waiting");
                }
                System.out.println("removed elements are");
                System.out.println(l1.remove(0));
                l1.notifyAll();
            }
        }

    }
}
