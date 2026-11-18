package exam;

public class Product implements IProduct {
    private final int[][] salesData; 
    private final String[] productNames; 

    public Product(String[] names, int[][] data) {
        this.productNames = names;
        this.salesData = data;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] salesData1 : salesData) {
            for (int j = 0; j < salesData1.length; j++) {
                total += salesData1[j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        return (double) GetTotalProductsSold() / productNames.length;
    }

    @Override
    public String GetMostPopularProduct() {
        int highest = 0;
        String popular = "";
        for (int i = 0; i < salesData.length; i++) {
            int sum = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                sum += salesData[i][j];
            }
            if (sum > highest) {
                highest = sum;
                popular = productNames[i] + " (" + highest + ")";
            }
        }
        return popular;
    }
}