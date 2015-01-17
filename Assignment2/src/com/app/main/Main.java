/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.main;

import com.app.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yogita
 */
public class Main {

    public static int item;
    public static List<Integer> l1 = new ArrayList<Integer>();
    public static volatile boolean running = true;

    public static void main(String args[]) {

        final Producer p1 = new Producer();
        final Consumer p2 = new Consumer();

        Thread t1 = new Thread(new Producer());
        Thread t2 = new Thread(new Consumer());

        t1.start();
        t2.start();


//       try {
//           t1.join();
//           t2.join();
//           
//       } catch (InterruptedException ex) {
//           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//       }


        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        shutdown();
        System.out.println("Process Ended");
    }

    public static void shutdown()
      {
          running=false;
      }

}
