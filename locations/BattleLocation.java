package MaceraOyunu;

import java.util.Random;

public class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLocation(Player player,String locationName, Obstacle obstacle,String award,int maxObstacle){
        super(player,locationName);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation(){
        int obstacleNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız: "+this.getLocationName());
        System.out.println("Dikkatli ol! Burada "+obstacleNumber+ " tane "+ this.getObstacle().getObstacleName()+ " yaşıyor.");
        System.out.print("Savaşmak için S'yi Kaçmak için K'yi tuşlayınız: ");
        String select = input.nextLine();
        select = select.toUpperCase();
        if (select.equals("S")){
            if (combat(obstacleNumber)){
                System.out.println(this.getLocationName() + " tüm düşmanları yendiniz.");
                return true;
            }
        }
        if (this.getPlayer().getHealty() <= 0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public void playerStats(){
        System.out.println("Oyuncu değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealty());
        System.out.println("Hasar: "+ this.getPlayer().getDamage());
        System.out.println("Silah: "+ this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar Bloklama: "+this.getPlayer().getInventory().getArmor().getDamageBlock());
        System.out.println("Para: "+ this.getPlayer().getMoney());

    }

    public void obstacleStats(int i){
        System.out.println(i+"."+this.getObstacle().getObstacleName()+" Değerleri");
        System.out.println("--------------------------");
        System.out.println("Hasar: "+this.getObstacle().getObstacleDamage());
        System.out.println("Sağlık: "+this.getObstacle().getObstacleHealt());
        System.out.println("Ödül: "+this.getObstacle().getAward());
    }
    public boolean combat(int obstacleNumber){
        for (int i = 1 ; i <= obstacleNumber ; i++){
            this.getObstacle().setObstacleHealt(this.getObstacle().getOriginalHealt());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealty() > 0 && this.getObstacle().getObstacleHealt() > 0){
                System.out.println("<V> Vur veya <K> Kaç");
                String select = input.nextLine().toUpperCase();
                if (select.equals("V")){
                    System.out.println("Siz vurdunuz");
                    obstacle.setObstacleHealt(this.getObstacle().getObstacleHealt()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getObstacleHealt() > 0){
                        System.out.println("Canavar size vurdu");
                        int obsDmg = this.getObstacle().getObstacleDamage() - this.getPlayer().getInventory().getArmor().getDamageBlock();
                        if (obsDmg < 0 ){
                            obsDmg = 0;
                        }
                        this.getPlayer().setHealty(this.getPlayer().getHealty()-obsDmg);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getObstacleHealt() < this.getPlayer().getHealty()){
                System.out.println("Düşmanı yendiniz.");
                System.out.println(this.getObstacle().getAward()+ " para kazandınız.");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealty());
        System.out.println(this.getObstacle().getObstacleName() + " Canı: " + this.getObstacle().getObstacleHealt());
        System.out.println("------------------------");
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle())+1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}
