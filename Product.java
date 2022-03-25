import java.util.Calendar;

public class Product {
    private String productName;
    private java.util.Calendar saleDate;
    private double price;

    public Product(String sName,java.util.Calendar sDate,double price){
        productName = sName;
        saleDate = sDate;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
       if (productName.length() >= 3){
       this.productName = productName;
    }else try {
           throw new Exception("productName cannot be less than 3 symbols.. ");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public Calendar getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
       if (price >= 0 ){

        this.price = price;
    }else try {
           throw new Exception("Price cannot be negative.. ");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public String calendarToString(Calendar c){
        String MM = String.valueOf(c.get(Calendar.MONTH )+1);

        String DD = String.valueOf(c.get(Calendar.DATE));

        String YYYY = String.valueOf(c.get(Calendar.YEAR));

        return (DD + "/" + MM + "/" + YYYY);
    }

    @Override
    public String toString() {
        return "Product [" +
                "productName=" + productName +
                ", transactionDate=" + calendarToString(saleDate) +
                ", price=" + price +
                ']';
    }
}
