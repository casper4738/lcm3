package lcm;

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
public class BBS {

    public static void main(String[] args) throws InterruptedException {

        BBS bbs = new BBS();
        bbs.setP(BigInteger.valueOf(72));
        bbs.setQ(BigInteger.valueOf(11));
        bbs.run();
        int[] listRandom = bbs.getListRandom();
        for (int i : listRandom) {
            if (i > listRandom.length) {
                System.out.print("xX:");
            }
            System.out.println(i);
        }

    }

    private static final int BIT = 6;
    private int[] listRandom;
    private BigInteger p;
    private BigInteger q;

    public BBS() {
        this.listRandom = new int[38];
    }

    public void run() {
        boolean bool = true;
        BigInteger new_p = p;
        BigInteger new_q = q;
        while (new_p.compareTo(BigInteger.valueOf(100)) <= 0) {
            new_q = q;
            while (new_q.compareTo(BigInteger.valueOf(100)) <= 0 && bool) {
                for (int k = 8; k < 100; k++) {
                    BigInteger s = BigInteger.valueOf(k);
                    if (generatorBBS(s, new_p, new_q)) {
                        int[] cek = getListRandom();
                        while (!cek(cek)) {
                        }
                        p = new_p;
                        q = new_q;
                        bool = false;
                        break;
                    }
                }
                new_q = new_q.add(BigInteger.ONE);
            }
            new_p = new_p.add(BigInteger.ONE);
        }
    }

    private boolean cek(int[] cek) {
        boolean[] bool = new boolean[cek.length];
        for (int i = 0; i < cek.length; i++) {
            bool[i] = false;
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = 0; j < cek.length; j++) {
                if (cek[j] == i) {
                    bool[i] = true;
                }
            }
        }

        for (int i = 0; i < cek.length; i++) {
            if (cek[i] > cek.length) {
                cek[i] = cek[i] % 38;
            } else {
                for (int j = i + 1; j < cek.length; j++) {
                    if (cek[i] == cek[j]) {
                        for (int n = 0; n < cek.length; n++) {
                            if (!bool[n]) {
                                cek[j] = n;
                                bool[n] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < cek.length; i++) {
            for (int j = i + 1; j < cek.length; j++) {
                if (cek[i] == cek[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] getListRandom() {
        return listRandom;
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

    public boolean isCongruent(BigInteger p, BigInteger q) {
        if (p.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) != 0) {
            return false;
        }
        return q.mod(BigInteger.valueOf(4)).compareTo(BigInteger.valueOf(3)) == 0;
    }

    private BigInteger getBilanganBlum(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    private boolean isSeed(BigInteger s, BigInteger p, BigInteger q) {
        BigInteger n = p.multiply(q);
        return s.compareTo(BigInteger.valueOf(2)) >= 0 && s.compareTo(n) < 0;
    }

    private boolean isGreatestCommonDivisor(BigInteger s, BigInteger p, BigInteger q) {
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

    private boolean generatorBBS(BigInteger s, BigInteger p, BigInteger q) {
        if (!isBilanganPrima(p, q)) {
            return false;
        } else if (!isCongruent(p, q)) {
            return false;
        } else if (!isSeed(s, p, q)) {
            return false;
        } else if (!isGreatestCommonDivisor(s, p, q)) {
            return false;
        } else {
            BigInteger n = getBilanganBlum(p, q);
            BigInteger x = (s.multiply(s)).mod(n);
            int ite = 0;
            int maxIte = 0;
            while (maxIte < 38) {
                x = (x.multiply(x)).mod(n);
                BigInteger value = getLSBInDec(x);
                listRandom[ite] = value.intValue();
                ite++;
                maxIte++;
            }
            return true;
        }
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

    public void setP(BigInteger p) {
        this.p = p;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

}
