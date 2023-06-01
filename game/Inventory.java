package MaceraOyunu;

public class Inventory {
    private Armor armor;
    private Weapon weapon;

    public Inventory(){
        this.weapon = new Weapon(-1,"Yumruk",0,0);
        this.armor = new Armor(-1,"Zırhsız",0,0);
    }

    public Weapon getWeapon(){return this.weapon;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}

    public Armor getArmor(){return this.armor;}
    public void setArmor(Armor armor){this.armor = armor;}
}
