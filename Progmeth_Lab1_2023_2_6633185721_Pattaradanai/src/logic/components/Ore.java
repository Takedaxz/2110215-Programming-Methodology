package logic.components;

import java.util.Objects;

public class Ore {
    private String name;
    private int cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ore ore = (Ore) o;

        if (cost != ore.cost) return false;
        return Objects.equals(name, ore.name);
    }

    public void setCost(int cost) {
        this.cost = Math.max(1,cost);
    }

    public Ore(String name, int cost){
        setCost(cost);
        setName(name);
    }
}
