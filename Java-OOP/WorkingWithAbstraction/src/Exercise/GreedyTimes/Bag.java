package Exercise.GreedyTimes;

public class Bag {
    private int capacity;
    private int gold;
    private int gems;
    private int money;

    public Bag(int capacity, int gold, int gems, int money) {
        this.capacity = capacity;
        this.gold = gold;
        this.gems = gems;
        this.money = money;
    }

    public int getCurrentVolume(int amount){
        return this.gold + this.gems + this.money + amount;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getGold() {
        return gold;
    }

    public int getGems() {
        return gems;
    }

    public int getMoney() {
        return money;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
