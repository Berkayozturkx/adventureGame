package MaceraOyunu;

public abstract class GameChar {
    private String name;

    private int damage;

    private int healty;

    private int money;
    public GameChar(String name,int damage,int healty, int money){
        this.name = name;
        this.damage = damage;
        this.healty = healty;
        this.money = money;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
