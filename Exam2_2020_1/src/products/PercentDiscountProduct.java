package products;

import discount.PercentDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class PercentDiscountProduct extends BaseProduct implements PercentDiscountable,Sellable {
    private double percent;
    public PercentDiscountProduct(String name, int price,double percent) {
        super(name, price);
        setPercent(percent);
    }

    @Override
    public int calcDiscountPerPiece() {
        return ShopUtil.calculateDiscountUsingPercent(getPrice(),getPercent());
    }

    @Override
    public int calculateDiscount(int quantity) {
        return calcDiscountPerPiece()*quantity;
    }

    @Override
    public String toString() {
        return this.getProductName() + " (Price: " + this.getPrice() +", "+ this.getPercent() + "% Off)";
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        if(percent<0)
            this.percent=0;
        else
            this.percent = Math.min(100,percent);
    }
}
