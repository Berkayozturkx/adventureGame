package MaceraOyunu;

public class ToolStore extends NormalLocation{
    public ToolStore(Player player){
        super(player,"Mağaza");
    }

    public void printWeapon(){
        System.out.println("########## Silahlar ##########");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() +")" +w.getName() +" Hasar:"+w.getDamage() +" Fiyat: "+ w.getPrice());
        }
        System.out.println("4)Çıkış yap.");
        System.out.println("--------------------------------------------------------------------------------------");

    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");
        int select = input.nextInt();
        while (select < 0 && select > Weapon.weapons().length){
            System.out.println("Geçersiz değer girdiniz, tekrar deneyiniz: ");
            select = input.nextInt();
        }
        if (select != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(select);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Paranız Yetersiz");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("########## Zırhlar ##########");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId()+")"+a.getName()+" Hasar Engelleme: "+a.getDamageBlock()+ " Fiyat: "+ a.getPrice());
        }
        System.out.println("4)Çıkış yap.");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz: ");
        int select = input.nextInt();
        while (select < 1 && select > Armor.armors().length){
            System.out.println("Geçersiz değer girdiniz, tekrar deneyiniz: ");
            select = input.nextInt();
        }
        if (select != 0){
            Armor selectedArmor = Armor.getArmorObjByID(select);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Paranız Yetersiz");
                } else {
                    System.out.println(selectedArmor.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }

    public boolean onLocation(){
        System.out.println("Mağazaya Hoşgeldiniz.");
        boolean menuKey = true;
        while(menuKey){
            System.out.println("1)Silahlar\n2)Zırhlar\n3)Çıkış Yap");
            System.out.print("Seçiminizi giriniz:");
            int select = input.nextInt();
            while(select < 1 && select >3){
                System.out.print("Geçersiz bir değer girdiniz, tekrar deneyiniz: ");
                select = input.nextInt();
            }
                switch (select){
                    case 1:
                        printWeapon();
                        buyWeapon();
                        this.getPlayer().getCharInfo();
                        break;

                    case 2:
                        printArmor();
                        buyArmor();
                        this.getPlayer().getCharInfo();
                        break;
                    case 3:
                        System.out.println("Başarıyla çıkış yaptınız.");
                        menuKey = false;
                        break;
            }
        }
        return true;
    }
}
