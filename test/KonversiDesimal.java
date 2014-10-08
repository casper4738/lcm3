
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KonversiDesimal {
    public static void main(String[] args) throws Exception{
        BufferedReader stdin =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Masukkan bilangan desimal : ");
        String input = stdin.readLine();        
        //--------------------------------------------------
//        int [] bin  = new int[100];
//        int j=0;
//        for(int i=Integer.parseInt(input); i>0; i=i/2) {
//            bin[j] = i % 2;
//            j++;
//        }
//
//        for(int i=j-1; i>=0; i--) {
//            System.out.print(bin[i]);
//        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = Integer.parseInt(input); i > 0; i = i / 2) {
            list.add(i % 2);
        }

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
        
        System.out.println();
        //--------------------------------------------------        
    }
}