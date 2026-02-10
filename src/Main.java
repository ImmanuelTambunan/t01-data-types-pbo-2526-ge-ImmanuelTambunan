import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Cek apakah ada argumen soal (seperti Soal1, Soal2, dst)
        if (args.length == 0) {
            System.out.println("Gunakan: java Main <NamaSoal>");
            return;
        }

        Scanner sc = new Scanner(System.in);
        String pilihanSoal = args[0];

        switch (pilihanSoal) {
            case "Soal1":
                // Soal 1: Integer Overflow Detection
                if (sc.hasNextInt()) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int res = a + b;
                    // Menggunakan operasi bitwise untuk deteksi overflow
                    if (((a ^ res) & (b ^ res)) < 0) {
                        System.out.println("OVERFLOW");
                    } else {
                        System.out.println(res);
                    }
                }
                break;

            case "Soal2":
    // 1. Baca input sebagai double
    double x = sc.nextDouble();
    double y = sc.nextDouble();

    // 2. Logika VITAL: Cast masing-masing variabel ke float SEBELUM dijumlahkan
    // Ini akan memicu "loss of precision" pada masing-masing angka
    float resFloat = (float) x + (float) y; 

    // 3. Jumlahkan secara normal sebagai double (presisi tetap terjaga)
    double resDouble = x + y;

    // 4. Hitung selisih absolutnya
    double selisih = Math.abs((double) resFloat - resDouble);

    // 5. Cetak dengan 6 digit di belakang koma
    System.out.printf("%.6f\n", selisih);
    break;

            case "Soal3":
                // Soal 3: Primitive vs Wrapper Comparison
                int n = sc.nextInt();
                Integer aObj = n; // Autoboxing
                Integer bObj = aObj;
                aObj++; // Integer bersifat immutable, operasi ini membuat objek baru
                System.out.println("==: " + (aObj == bObj));
                System.out.println("equals: " + aObj.equals(bObj));
                break;

            case "Soal4":
                // Soal 4: String Immutability & Reference
                String s = sc.next();
                String strA = s;
                String strB = new String(s); // Membuat objek string baru di heap
                strA = strA + "X"; // String bersifat immutable
                System.out.println("==: " + (strA == strB));
                System.out.println("equals: " + strA.equals(strB));
                break;

            case "Soal5":
                // Soal 5: Parsing & Type Safety
                int valInt = Integer.parseInt(sc.next()); // Parsing ke int
                double valDouble = Double.parseDouble(sc.next()); // Parsing ke double
                boolean valBool = Boolean.parseBoolean(sc.next()); // Parsing ke boolean
                double result = valInt * valDouble;
                if (!valBool) result *= -1;
                System.out.printf("%.2f\n", result);
                break;

            default:
                System.out.println("Soal tidak ditemukan.");
                break;
        }
    }
}