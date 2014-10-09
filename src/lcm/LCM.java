/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcm;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author casper
 */
public class LCM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LCM main = new LCM();
        main.setA(1);
        main.setC(7);
        main.setM(38);
        main.setZ0(8);
        main.run();
    }

    private int c;
    private int m;
    private int a;
    private int z0;
    private final int[] listRandom;

    public LCM() {
        this.listRandom = new int[38];
    }

    public void run() {
        int z = z0;
        for (int i = 0; i < 38; i++) {
            z = getLinearCongruen(z);
            listRandom[i] = z;
        }
    }

    public int getLinearCongruen(int z) {
        return ((a * z) + c) % m;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setZ0(int z0) {
        this.z0 = z0;
    }

    public int[] getListRandom() {
        return listRandom;
    }

}
