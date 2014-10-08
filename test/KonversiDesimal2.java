package programClass;

import java.io.*;


public class KonversiDesimal2 {
    public static void main(String[] args) throws Exception{
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Masukkan bilangan desimal : ");
        String input = stdin.readLine();

        int pTitik = input.indexOf(".");
        String sebTitik=null, setTitik=null;
        if(pTitik != -1) {
            sebTitik = input.substring(0, pTitik);
            setTitik = input.substring(pTitik+1, input.length());
        } else {
            sebTitik = input;
        }
                
        //System.out.println(pTitik +"//"+sebTitik+"//"+setTitik);
        //--------------------------------------------------
        int [] bin  = new int[100];
        int j=0;
        for(int i=Integer.parseInt(sebTitik); i>0; i=i/2) {
            bin[j] = i % 2;
            j++;
        }
//        System.out.print("Hasil Konversi Sebelum Koma : ");
        for(int i=j-1; i>=0; i--) {
            System.out.print(bin[i]);
        }
        //--------------------------------------------------
        if(pTitik != -1) {
//        System.out.println("\n================================");
        int a=0;
        double b=0,f=0;
        String c=null,e=null;
        
        int [] des = new int[100];
        int u=0;
        int r=0;
        int i=Integer.parseInt(setTitik);
        while(i>0) {
            if(u < 10) {
                c = "0."+i;
                f = Double.parseDouble(c) * 2.0;
                c = ""+f;
                a = (int) (f % 2);
                e = c.substring(2, c.length());
                i = Integer.parseInt(e);
                //System.out.println(""+i+"//"+a+"//"+e+"//"+f+"//"+c);
                //System.out.println(""+i);
                des[r] = a;
                r++;
               //if(i == 0)
               //     des[r] = 0;
            } else if(u >= 10) {
                i=0;
            }
            u++;
        }
        //---------
//        System.out.print("Hasil Konversi Setelah Koma : ");
        for(int t=0; t<=r; t++) {
            System.out.print(""+des[t]);
        }
        //--------------------------------------------------
        }
        System.out.println();        
    }
}