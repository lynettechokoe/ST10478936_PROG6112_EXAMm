package exam;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + names[i] + " mattress: ");
                sales[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        Product p = new Product(names, sales);
        
        // Print Output (Q1.3 combined here to save time)
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + p.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) p.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + p.GetMostPopularProduct());
    }
}
