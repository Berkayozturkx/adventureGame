package MaceraOyunu;

import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz.");
        System.out.print("Lütfen bir isim giriniz:");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        player.selectChar();

        Location location = null;
        while(true){
            System.out.println();
            System.out.println("###############Bölgeler###############");
            System.out.println();
            System.out.println("0)Çıkış Yap");
            System.out.println("1)Güvenli Ev");
            System.out.println("2)Mağaza");
            System.out.println("3)Mağara");
            System.out.println("4)Orman");
            System.out.println("5)Nehir");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz:");
            int select = input.nextInt();
            switch (select){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;

                case 3:
                    location = new Cave(player);
                    break;

                case 4:
                    location = new Forest(player);
                    break;

                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if (location == null){
                System.out.println("Oyundan Çıktınız.");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }
    }
}
