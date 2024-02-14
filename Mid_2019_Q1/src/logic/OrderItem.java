package logic;

public class OrderItem {
    private Item item;
    private int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        setItem(item);
        setItemAmount(itemAmount);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = Math.max(0,itemAmount);
    }

    public void increaseItemAmount(int amount){
        if(amount >= 0){
            setItemAmount(getItemAmount()+amount);
        }
        else{
            setItemAmount(getItemAmount());
        }
    }

    public int calculateTotalPrice(){
        return getItemAmount()*getItem().getPricePerPiece();
    }
}
