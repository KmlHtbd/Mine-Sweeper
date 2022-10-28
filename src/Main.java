import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int row;
        int col;
        Scanner scan = new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");
        System.out.println("Lütfen Mayın Tarlasının Boyutlarını Giriniz.");
        System.out.print("Satır Sayısını Giriniz: ");
        row = scan.nextInt();
        System.out.print("Sütun Sayısını Giriniz: ");
        col = scan.nextInt();

        MineSweeper mine = new MineSweeper(row,col);
        mine.run();
    }
}