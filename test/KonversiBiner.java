package programClass;

import java.io.*;


public class KonversiBiner {
    public static void main(String[] args) throws Exception{
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));


        System.out.print("Masukkan bilangan biner : ");
        String input = stdin.readLine();

        double pangkat=1, total=0, jKali, hKonversi=0 ;
        int pTitik = 0, cekError=0;
        int titik = input.indexOf(".");
        for(int i=2; i<=9; i++) {
            cekError = input.indexOf(""+i);
            if(cekError != -1) {
                cekError = 1;
                i = 10;
            }
            System.out.println(i+":error : "+cekError);
        }
          
         
          
         
        //int a=2;
        //cekError = input.indexOf(""+a);
        //System.out.println("error : "+cekError);
        
        //System.out.println(titik+" \n\n");
        
        if(cekError == -1)
        { // -----------
            if(titik != -1) {
                pTitik = titik;
            } else {
                pTitik = input.length();
            }

            for(int i=0; i<pTitik; i++) {
                pangkat = 1;
                for(int j=pTitik-1; j>i; j--) {
                    System.out.print(input.charAt(i)+"*2^"+j+" + ");
                    pangkat = pangkat * 2;
                }
                jKali = (input.charAt(i)-'0') * pangkat;
                total = total + jKali;
                System.out.println("-----"+pangkat+"//"+jKali);
            }
            hKonversi = hKonversi + total;
            System.out.println("Hasil Konversi : "+total);

            if(titik != -1) {
                total=0;
                System.out.println("aaa : "+pTitik);
                for(int i=pTitik+1; i<input.length(); i++) {
                    pangkat = 1;
                    for(int j=pTitik+1; j<=i; j++) {
                        System.out.print(input.charAt(i)+"*2^-"+j+" + ");
                        pangkat = pangkat * 2;
                    }
                    jKali = (input.charAt(i)-'0') * ( 1 / pangkat);
                    total = total + jKali;
                    System.out.println("-----"+pangkat+"//"+jKali);
                }
                hKonversi = hKonversi + total;
                System.out.println("Hasil Konversi : "+total);
                System.out.println("Hasil Konversi : "+hKonversi);
            }
        } // -----------
        else {
            System.out.println("Bilangan biner terdiri 0 dan 1!");
        }
         
    } 
        
}