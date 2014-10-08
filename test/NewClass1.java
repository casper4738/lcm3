
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
public class NewClass1 {

    public static void main(String[] args) {

        NewClass1 main = new NewClass1();
        for (int i = 0; i < 10; i++) {
            BigInteger p = BigInteger.valueOf(7);
            BigInteger q = BigInteger.valueOf(19);
            BigInteger s = BigInteger.valueOf(4);
            main.generatorBBS(s, p, q);
            
        }


//        System.out.println(main.getLSBInDec(126));
    }

    private static final int BIT = 4;
    private int[] listRandom = new int[38];

    public int[] getListRandom() {
        return listRandom;
    }

    public boolean isBilanganPrima(BigInteger p, BigInteger q) {
        if (p.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) != 0) {
            return false;
        }
        if (q.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) != 0) {
            return false;
        }
        return true;
    }

    public BigInteger getBilanganBlum(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    public boolean isSeed(BigInteger s, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        if (s.compareTo(BigInteger.valueOf(2)) >= 0 && s.compareTo(n) < 0) {
            return true;
        }
        return false;
    }

    public boolean isGreatestCommonDivisor(BigInteger s, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        List<BigInteger> list = new ArrayList();

        BigInteger i = BigInteger.valueOf(2);
        while (i.compareTo(s) <= 0) {
            double result = (s.doubleValue() / (double) i.doubleValue()) % 1;
            if (result == 0) {
                list.add(i);
            }
            i = i.add(BigInteger.valueOf(1));
        }

        for (BigInteger e : list) {
            if (n.mod(e).compareTo(BigInteger.ZERO) == 0) {
                return false;
            }
        }
        return true;
    }

    public void generatorBBS(BigInteger s, BigInteger p, BigInteger q) {
        if (!isBilanganPrima(p, q)) {
            System.out.print("tidak penuhi syarat bilangan 3 mod 4");
        } else if (!isSeed(s, p, q)) {
            System.out.print("tidak penuhi syarat 2 <= s < n ");
        } else if (!isGreatestCommonDivisor(s, p, q)) {
            System.out.print("tidak penuhi syarat relatif bilangan prima GCD = 1");
        } else {
            BigInteger n = getBilanganBlum(p, q);
            BigInteger x = (s.multiply(s)).mod(n);
            for (int i = 0; i < 38; i++) {
                x = (x.multiply(x)).mod(n);
                BigInteger value = getLSBInDec(x);
                listRandom[i] = value.intValue();
                System.out.println("berhasil");
//                System.out.println(i + ":" + x + " | " + listRandom[i]);
            }

        }
        System.out.println();
    }

    public BigInteger getLSBInDec(BigInteger value) {
        List<BigInteger> list = convertToBin(value);
        String string = "";
        if (list.size() < BIT) {
            for (int i = list.size() - 1; i >= 0; i--) {
                string = string + list.get(list.size() - 1 - i);
            }
        } else {
            for (int i = BIT - 1; i >= 0; i--) {
                string = string + list.get(list.size() - 1 - i);
            }
        }
        return convertToDec(string);
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
            list.add(vlist.get(i));
        }

        return list;
    }

    private BigInteger convertToDec(String value) {
        BigInteger dec = BigInteger.valueOf(0);
        int u = 0;
        for (int j = value.length() - 1; j >= 0; j--) {
            BigInteger z = BigInteger.valueOf(Integer.valueOf(value.charAt(u) + ""));
            int k = (int) Math.pow(2, j);
            u++;
            dec = dec.add(z.multiply(BigInteger.valueOf(k)));
        }
        return dec;
    }

}
