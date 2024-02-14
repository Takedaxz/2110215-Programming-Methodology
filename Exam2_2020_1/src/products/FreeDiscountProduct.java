package products;

import discount.FreeDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements FreeDiscountable,Sellable {

    private int promoQuantity;
    private int freeQuantity;
    public FreeDiscountProduct(String name, int price, int promoQ,int freeQ){
        super(name, price);
        setPromoQuantity(promoQ);
        setFreeQuantity(freeQ);
    }
    @Override
    public int calcFreeDiscountPieces(int totalQuantityBought){
        return ShopUtil.calculateFreeDiscountPieces(getFreeQuantity(),getPromoQuantity(),totalQuantityBought);
    }
    @Override
    public int calculateDiscount(int quantity){
        return calcFreeDiscountPieces(quantity)*getPrice();
    }

    @Override
    public String toString() {
        return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
    }

    public int getPromoQuantity() {
        return promoQuantity;
    }

    public void setPromoQuantity(int promoQuantity) {
        this.promoQuantity = Math.max(1,promoQuantity);
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(int freeQuantity) {
        this.freeQuantity = Math.max(1,freeQuantity);
    }
}
