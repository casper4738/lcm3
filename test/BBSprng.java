
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
/**
 *
 * @author casper
 */
public class BBSprng {

    public static void main(String[] args) {
        BBSprng bbs = new BBSprng();
        BigInteger bilangan_acak = bbs.generatorBBS(1000);// bangkitkan bil acak
        // 1000 bit
        System.out.println("Hasil pembangkitan bil acak = " + bilangan_acak);
    }

    private int ukuran_bit = 32;
    private BigInteger state;
    private SecureRandom r = new SecureRandom();
    private static final BigInteger tiga = BigInteger.valueOf(3L);
    private static final BigInteger empat = BigInteger.valueOf(4L);

    // Membangkitkan bilangan p dan q
    private BigInteger bangkitkan_bilanganPdanQ(int bits, Random rand) {
        BigInteger p;
        while (true) {
            // Bangkitkan BigInteger yang probably prima bits=ukuran bit,
            // 200=certainty = 1-1/2pangkat certainty
            // rand = seed berupa bil random
            p = new BigInteger(bits, 200, rand);
            if (p.mod(empat).equals(tiga)) { // kalau p(mod 4)=3, maka break
                break;
            }
        }
        return p;
    }

    private BigInteger ambil_bilanganPrima(int bits) {
        return this.bangkitkan_bilanganPdanQ(bits, r);
    }

    // Membangkitkan bilangan Blum pq=n
    private BigInteger bilanganBlum() {
        BigInteger p = this.ambil_bilanganPrima(ukuran_bit);
        BigInteger q = this.ambil_bilanganPrima(ukuran_bit);
        while (p.compareTo(q) == 0) {
            q = this.ambil_bilanganPrima(ukuran_bit);
        }
        return p.multiply(q);
    }

    // Memilih bilangan untuk seed Blum Blum Shub
    private BigInteger ambilSeedBBS(BigInteger bilangan_Blum) {
        BigInteger p;
        BigInteger bilangan_blum = bilangan_Blum;
        while (true) {
            p = new BigInteger(ukuran_bit, 200, r);
            if (p.gcd(bilangan_blum).equals(BigInteger.valueOf(1))) {
                break;
            }
        }
        return p;
    }

    // Fungsi pembangkit bil. acak BBS
    public BigInteger generatorBBS(int ukuranBilAcak) {
        BigInteger bilangan_Blum = this.bilanganBlum();
        BigInteger seedBBS = this.ambilSeedBBS(bilangan_Blum);
        String bil = "";
        BigInteger xi = null;
        BigInteger hasil = new BigInteger("0");
        while (hasil.compareTo(new BigInteger("10000000000")) == -1) { // Menjamin
            // bil
            // acak
            // minimum
            for (int i = 0; i < ukuranBilAcak; i++) {
                if (i == 0) {
                    xi = seedBBS.pow(2).mod(bilangan_Blum);
                } else {
                    xi = xi.pow(2).mod(bilangan_Blum);
                }
                // Ambil 1 bit lsb untuk deretan bilangan acak yg dihasilkan
                bil = bil + xi.mod(new BigInteger("2"));
            }
            hasil = new BigInteger(bil, 2);
            bilangan_Blum = this.bilanganBlum();
            seedBBS = this.ambilSeedBBS(bilangan_Blum);
        }
        return new BigInteger(bil, 2);
    }

    // Fungsi untuk menguji pembangkit bil. acak BBS
    public String uji_generatorBBS(int ukuranBilAcak) {
        BigInteger bilangan_Blum = this.bilanganBlum();
        BigInteger seedBBS = this.ambilSeedBBS(bilangan_Blum);
        String bil = "";
        BigInteger xi = null;
        BigInteger hasil = new BigInteger("0");

        for (int i = 0; i < ukuranBilAcak; i++) {
            if (i == 0) {
                xi = seedBBS.pow(2).mod(bilangan_Blum);
            } else {
                xi = xi.pow(2).mod(bilangan_Blum);
            }
            bil = bil + xi.mod(new BigInteger("2"));
        }
        hasil = new BigInteger(bil, 2);
        return bil;
    }
}
