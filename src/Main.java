import java.util.Scanner;

/**
 * Merupakan class main
 * Pada class ini akan dijalankan program untuk mengetahui jumlah pendapatan maksimum berdasarkan kue yang dijual
 * Dengan menggunakan metode grafik pemrograman linier
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Oktober 2017
 */
public class Main {

    static Scanner sScanner = new Scanner(System.in);

    static Double sFlourMax, sSugarMax;
    static Double sOmelettePrice, sApemPrice;
    static Double sIncome[] = new Double[4];

    static Point sFlourPoint = new Point();
    static Point sSugarPoint = new Point();
    static Point sGraphPoint[] = new Point[4];

    public static void main(String[] args) {
        initializeObject();
        getData();
        getCoordinate();
        getIncome();
    }

    private static void initializeObject() {
        for (int i = 0; i < sGraphPoint.length; i++)
            sGraphPoint[i] = new Point();
    }

    private static void getData() {
        System.out.print("Masukkan jumlah tepung yang tersedia (gram) : ");
        sFlourMax = sScanner.nextDouble();

        System.out.print("Masukkan jumlah gula yang tersedia (gram) : ");
        sSugarMax = sScanner.nextDouble();

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("");

        System.out.print("Masukkan tepung yang dibutuhkan untuk membuat kue dadar (gram) : ");
        sFlourPoint.setX(sScanner.nextDouble());

        System.out.print("Masukkan tepung yang dibutuhkan untuk membuat kue apem (gram) : ");
        sFlourPoint.setY(sScanner.nextDouble());

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("");

        System.out.print("Masukkan gula yang dibutuhkan untuk membuat kue dadar (gram) : ");
        sSugarPoint.setX(sScanner.nextDouble());

        System.out.print("Masukkan gula yang dibutuhkan untuk membuat kue apem (gram) : ");
        sSugarPoint.setY(sScanner.nextDouble());

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("");

        System.out.print("Masukkan harga penjualan kue dadar (rupiah) : ");
        sOmelettePrice = sScanner.nextDouble();

        System.out.print("Masukkan harga penjualan kue apem (rupiah) : ");
        sApemPrice = sScanner.nextDouble();

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("");
    }

    private static void getCoordinate() {
        Double x1, x2;
        Double y1, y2;

        x1 = sFlourMax / sFlourPoint.getX();
        x2 = sSugarMax / sSugarPoint.getX();

        y1 = sFlourMax / sFlourPoint.getY();
        y2 = sSugarMax / sSugarPoint.getY();

        sGraphPoint[3].setX(x1 <= x2 ? x1 : x2);
        sGraphPoint[3].setY(0D);

        sGraphPoint[1].setX(0D);
        sGraphPoint[1].setY(y1 <= y2 ? y1 : y2);

        sGraphPoint[0].setX(0D);
        sGraphPoint[0].setY(0D);

        x1 = ((sSugarMax * sFlourPoint.getY()) - (sSugarPoint.getY() * sFlourMax)) /
                ((sFlourPoint.getY() * sSugarPoint.getX()) - (sSugarPoint.getY() * sFlourPoint.getX()));

        y1 = ((sSugarMax * sFlourPoint.getX()) - (sSugarPoint.getX() * sFlourMax)) /
                ((sSugarPoint.getY() * sFlourPoint.getX()) - (sSugarPoint.getX() * sFlourPoint.getY()));

        sGraphPoint[2].setX(x1);
        sGraphPoint[2].setY(y1);
    }

    private static void getIncome() {
        int maxIndex;
        Double incomeMax;

        for (int i = 0; i < sGraphPoint.length; i++)
            sIncome[i] = (sOmelettePrice * sGraphPoint[i].getX()) + (sApemPrice * sGraphPoint[i].getY());

        maxIndex = 0;
        incomeMax = sIncome[0];

        for (int i = 1; i < sIncome.length; i++) {
            if (sIncome[i] >= incomeMax) {
                maxIndex = i;
                incomeMax = sIncome[i];
            }
        }

        System.out.println("Pendapatan terbesar adalah " + incomeMax);
        System.out.println("Kue dadar di produksi sebanyak " + sGraphPoint[maxIndex].getX());
        System.out.println("Kue apem di produksi sebanyak " + sGraphPoint[maxIndex].getY());

        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("");
    }
}
