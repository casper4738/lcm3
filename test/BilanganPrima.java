
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
/**
 *
 * @author casper
 */
public class BilanganPrima {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int input = 100;
//
//        for (int i = 2; i < input; i++) {
//            boolean isPrima = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrima = false;
//                    break;
//                }
//            }
//
//            if (isPrima) {
//                System.out.println(i + ",");
//            }
//        }

        BilanganPrima prima = new BilanganPrima();

        BigInteger p = BigInteger.valueOf(23);
        BigInteger q = BigInteger.valueOf(5);

//        System.out.println(prima.isBilanganPrima(p, q));
//        prima.convertToBin(BigInteger.valueOf(64));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);

        String string = "";

        for (int i = 6 - 1; i >= 0; i--) {
            string = string + list.get(list.size() - 1 - i);
        }
        System.out.println(string);

    }

    private List<BigInteger> convertToBin(BigInteger value) {
        List<BigInteger> vlist = new ArrayList<>();
        BigInteger ve = value;
        while (ve.compareTo(BigInteger.valueOf(0)) == 1) {
            vlist.add(ve.mod(BigInteger.valueOf(2)));
            ve = ve.divide(BigInteger.valueOf(2));
        }

        List<BigInteger> list = new ArrayList<>();
        for (int i = vlist.size() - 1; i >= 0; i--) {
            System.out.println(vlist.get(i));

            list.add(vlist.get(i));
        }

        return list;
    }

    public boolean isBilanganPrima(BigInteger p, BigInteger q) {
        boolean prima1 = true;
        boolean prima2 = true;

        for (int j = 2; j < p.intValue(); j++) {
            if (p.intValue() % j == 0) {
                prima1 = false;
                break;
            }
        }

        for (int j = 2; j < q.intValue(); j++) {
            if (q.intValue() % j == 0) {
                prima2 = false;
                break;
            }
        }

        return prima1 && prima2;
    }
}
