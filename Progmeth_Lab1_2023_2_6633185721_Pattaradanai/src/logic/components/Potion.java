package logic.components;

public class Potion {
    private String name;
    private int price;
    private Status increasingStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = Math.max(1,price);
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }

    public Potion(String name, int price, Status increasingStatus){
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Potion potion = (Potion) o;

        if (price != potion.price) return false;
        if (!name.equals(potion.name)) return false;
        return increasingStatus.equals(potion.increasingStatus);
    }

}
