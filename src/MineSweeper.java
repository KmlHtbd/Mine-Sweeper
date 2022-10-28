import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber;
    int colNumber;
    int size;
    int[][] map ;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    MineSweeper(int rowNumber,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        this.map= new int[rowNumber][colNumber];
        this.board= new int[rowNumber][colNumber];
        this.size=rowNumber*colNumber;
    }
    public void run(){
        int row;
        int col;
        int success=0;
        prepare();
        printMap(map);
        System.out.println("Oyun Başladı!");
        while (game){
            print(board);
            System.out.print("Satır Değeri: ");
            row = scan.nextInt();
            System.out.print("Sütun Değeri: ");
            col = scan.nextInt();
            if (row<0 || col<0 || row>=rowNumber || col>=colNumber){
                System.out.println("Hatalı Konum Girdiniz!");
                continue;
            }
            if (map[row][col]!=-1){
                check(row,col);
                success++;
                if (success==(size-size/4)){
                    System.out.println("Tebrikler!Mayın Tarlasından Başarıyla Geçtiniz.");
                    printEnd(board);
                    break;
                }
            }else{
                game=false;
                System.out.print("Mayına Bastınız.Oyun Bitti!");
            }
        }
    }
    public void check(int r,int c){
        if (map[r][c]==0){
            if ((c<colNumber-1) && (map[r][c+1]==-1)){
                board[r][c]++;
            }
            if ((r<rowNumber-1) && (map[r+1][c]==-1)){
                board[r][c]++;
            }
            if ((r>0) && (map[r-1][c]==-1)){
                board[r][c]++;
            }
            if ((c>0) && (map[r][c-1]==-1)){
                board[r][c]++;
            }
            if ((c>0) && (r>0) && (map[r-1][c-1]==-1)){
                board[r][c]++;
            }
            if ((c<colNumber-1) && (r>0) && (map[r-1][c+1]==-1)){
                board[r][c]++;
            }
            if ((c<colNumber-1) && (r<rowNumber-1) && (map[r+1][c+1]==-1)){
                board[r][c]++;
            }
            if ((c>0) && (r<rowNumber-1) && (map[r+1][c-1]==-1)){
                board[r][c]++;
            }
            if (board[r][c]==0){
                board[r][c]=-2;
            }
        }
    }
    public void prepare(){
        int randRow;
        int randCol;
        int count=0;
        while (count!=(size/4)){
            randRow= rand.nextInt(rowNumber);
            randCol= rand.nextInt(colNumber);
            if (map[randRow][randCol]!=-1){
                map[randRow][randCol]=-1;
                count++;
            }
        }
    }
    public void printMap(int[][] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]>=0){
                    System.out.print(" "+arr[i][j]+" ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
    public void print(int[][] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    System.out.print(" - ");
                }
                else if(arr[i][j]>0) {
                    System.out.print(" " + arr[i][j] + " ");
                }
                else if (arr[i][j]==-2){
                        System.out.print(" 0 ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public void printEnd(int[][] arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    System.out.print(" * ");
                }
                else if(arr[i][j]>0) {
                    System.out.print(" " + arr[i][j] + " ");
                }
                else if (arr[i][j]==-2){
                    System.out.print(" 0 ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
