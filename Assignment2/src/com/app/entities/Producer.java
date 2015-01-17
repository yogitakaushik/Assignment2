package com.app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.app.main.Main.l1;
import com.app.main.Main;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yogita
 */
public class Producer implements Runnable {

    Random r1 = new Random();
    static final int MAX_SIZE = 20;
    // private  static List<Integer> l1=new ArrayList<Integer>(count);
    static int items;
    static int i;

    public void run() {
        System.out.println("Opening");

        synchronized (l1) {
            while (Main.running) {

                while (l1.size() >= MAX_SIZE) {
                    try {
//                    Thread.sleep(100);
                        l1.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
//                else {

                    items = r1.nextInt(100);
                    l1.add(items);
                    System.out.println("New Element:'" + items);
                    l1.notifyAll();

//                }
            }
        }
    }
}
