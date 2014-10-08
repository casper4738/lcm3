package programClass;

import java.io.*;
import java.util.*;

public class konversi_biner_desimal {

    private static String input="";
    private static int des=0;
    private static int fandy;
    private static int [] bin = new int[100];
    private static int [] oktal = new int[100];    
    private static String [] hex = {"1","2","3","4","5","6","7","8","9","A","B",
        "C","D","E","F"} ;
   
    public static void masuk() throws IOException
    {
        BufferedReader stdin = 
                new BufferedReader (new InputStreamReader(System.in));

        System.out.print("Masukkan input : ");
        input = stdin.readLine();        
    }

    public static void des_bin_oktal_hex() throws IOException
    {
        BufferedReader stdin =
                new BufferedReader (new InputStreamReader(System.in));

        des = Integer.parseInt(input);
        System.out.print("\nHASIL KONVERSI : ");
        int j=0;
        for (int i=des; i>0; i=i/fandy)
        {
            bin[j]=i%fandy;
            j++;
        }

        j=j-1;
        while (j>=0)
        {
            if(bin[j]<10)
                System.out.print(bin[j]);
            else if(bin[j]==10)
                System.out.print(hex[bin[j]-1]);
            else if(bin[j]==11)
                System.out.print(hex[bin[j]-1]);
            else if(bin[j]==12)
                System.out.print(hex[bin[j]-1]);
            else if(bin[j]==13)
                System.out.print(hex[bin[j]-1]);
            else if(bin[j]==14)
                System.out.print(hex[bin[j]-1]);
            else if(bin[j]==15)
                System.out.print(hex[bin[j]-1]);
            j--;
        }
    }

    public static void bin_oktal_hex_des() throws IOException
    {   
        int u=0;
        for (int j=input.length()-1; j>=0; j--)
        {
            int z=input.charAt(u)-'0';
            
            if(input.charAt(u)=='A'||input.charAt(u)=='a')
                z=10;
            if(input.charAt(u)=='B'||input.charAt(u)=='b')
                z=11;
            if(input.charAt(u)=='C'||input.charAt(u)=='c')
                z=12;
            if(input.charAt(u)=='D'||input.charAt(u)=='d')
                z=13;
            if(input.charAt(u)=='E'||input.charAt(u)=='e')
                z=14;
            if(input.charAt(u)=='F'||input.charAt(u)=='f')
                z=15;           
            
            //int k=(int) Math.pow(fandy,j);
            int k=1;
            for(int i=j; i>=1 ; i--) {
                k = k * fandy;
            }           
            u++;
            des=des+(z*k);            
            k=0;            
        }
        System.out.println("HASIL KONVERSI : "+des);
    }
    

    public static void main (String[] args) throws IOException {

        BufferedReader stdin =
                new BufferedReader (new InputStreamReader(System.in));
        Scanner buffer = new Scanner(System.in);
        
        System.out.println("PROGRAM KONVERSI BILANGAN");
        System.out.println("=========================\n");         
        System.out.println("1. DESIMAL KE BINER");
        System.out.println("2. DESIMAL KE OKTAL");
        System.out.println("3. DESIMAL KE HEXADESIMAL");
        System.out.println("4. BINER KE DESIMAL");
        System.out.println("5. OKTAL KE DESIMAL");
        System.out.println("6. HEXADESIMAL KE DESIMAL");
        System.out.print("Masukkan pilihan : ");
        int pilih = buffer.nextInt();
        masuk();  
        switch (pilih)
        {
            case 1: fandy=2; des_bin_oktal_hex(); break;
            case 2: fandy=8; des_bin_oktal_hex(); break;
            case 3: fandy=16; des_bin_oktal_hex(); break;
            case 4: fandy=2; bin_oktal_hex_des(); break;
            case 5: fandy=8; bin_oktal_hex_des(); break;
            case 6: fandy=16; bin_oktal_hex_des(); break;
        }        
        System.out.println();
    }
}