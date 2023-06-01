package MaceraOyunu;



import java.sql.SQLOutput;
import java.util.Scanner;

public class Player {
    private String charName;
    private String name;
    private int damage;
    private int healty;
    private int originalHealty;

    public int getOriginalHealty() {
        return originalHealty;
    }

    public void setOriginalHealty(int originalHealty) {
        this.originalHealty = originalHealty;
    }

    private int money;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public String getCharName(){return this.charName;}
    public void setCharName(String charName){this.charName = charName;}

    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage(){return this.damage;}
    public void setDamage(int damage){this.damage = damage;}

    public int getHealty(){return this.healty;}
    public void setHealty(int healty){
        if (healty < 0){
            healty = 0;
        }
        this.healty = healty;}

    public int getMoney(){return this.money;}
    public void setMoney(int money){this.money = money;}

    public Inventory getInventory(){return this.inventory;}
    public void setInventory(Inventory inventory){this.inventory = inventory;}

    public void getCharInfo(){
        System.out.println("------------------------------------------------");
        System.out.println("Karakter Bilgileri");
        System.out.println("Silah:"+ this.getInventory().getWeapon().getName()+ "\n"+
                "Zırh:"+ this.getInventory().getArmor().getName()+"\n"+
                "Hasar:"+ this.getTotalDamage() +"\n"+
                "Hasar Bloklama:"+ this.getInventory().getArmor().getDamageBlock()+"\n"+
                "Sağlık:" + this.getHealty() +"\n"+
                "Para:"+ this.getMoney());
        System.out.println("------------------------------------------------");
    }

    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealty(gameChar.getHealty());
        this.setOriginalHealty(gameChar.getHealty());
        this.setMoney(gameChar.getMoney());
    }


    public void selectChar(){

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        for (int i = 0 ; i < charList.length ; i++){
            System.out.println((i+1)+".Karakter: "+charList[i].getName()+
                    " Hasar:"+charList[i].getDamage()+
                    " Sağlık:"+charList[i].getHealty()+
                    " Para:"+charList[i].getMoney());
        }
        System.out.println();
        System.out.print("Lütfen seçmek istediğiniz karakteri giriniz:");
        int select = input.nextInt();
        switch (select){
            case 1:
                initPlayer(new Samurai());
                System.out.println("Karakter Başarıyla Oluşturuldu.");
                break;
            case 2:
                initPlayer(new Archer());
                System.out.println("Karakter Başarıyla Oluşturuldu.");
                break;
            case 3:
                initPlayer(new Knight());
                System.out.println("Karakter Başarıyla Oluşturuldu.");
                break;
            default:
                System.out.println("Yanlış bir karakter numarası girdiniz.");
                break;
        }
        getCharInfo();
    }
}
