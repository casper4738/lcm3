package programClass;

import java.io.*;
import java.util.*;

public class konversi_biner_desimal2 {

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
        System.out.println();
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
            
            int k=(int) Math.pow(fandy,j);
            u++;
            des=des+(z*k);            
        }
        //System.out.println("HASIL KONVERSI : "+des);
        System.out.println(des);
    }
    

    public static void main (String[] args) throws IOException {

        BufferedReader stdin =
                new BufferedReader (new InputStreamReader(System.in));
        Scanner buffer = new Scanner(System.in);
        
        System.out.println("PROGRAM KONVERSI BILANGAN");
        System.out.println("=========================\n");         
        System.out.println("1. DESIMAL --> BINER - OKTAL - HEXADESIMAL");
        //System.out.println("2. BINER - OKTAL - HEXADESIMAL - DESIMAL");
        //System.out.println("3. OKTAL - HEXADESIMAL - DESIMAL - BINER");
        //System.out.println("4. HEXADESIMAL - DESIMAL - BINER - OKTAL");
        System.out.print("Masukkan pilihan : ");
        int pilih = buffer.nextInt();
        switch (pilih)
        {
            
            case 1: masuk();
                    fandy=2; System.out.print("BINER : "); des_bin_oktal_hex();
                    fandy=8; System.out.print("OKTAL : "); des_bin_oktal_hex();
                    fandy=16; System.out.print("HEXADESIMAL : "); des_bin_oktal_hex(); break;
            case 2: masuk();
                    fandy=8; System.out.print("OKTAL : "); bin_oktal_hex_des();
                    fandy=16; System.out.print("HEXADESIMAL : ");bin_oktal_hex_des();
                    fandy=2; System.out.print("DESIMAL : ");bin_oktal_hex_des(); break;
            case 3: masuk();
                    fandy=2; bin_oktal_hex_des();
                    fandy=8; bin_oktal_hex_des();
                    fandy=16; bin_oktal_hex_des(); break;
            case 4: masuk();
                    fandy=2; bin_oktal_hex_des();
                    fandy=8; bin_oktal_hex_des();
                    fandy=16; bin_oktal_hex_des(); break;
        }
        System.out.println();
    }
}