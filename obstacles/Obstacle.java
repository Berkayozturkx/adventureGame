package MaceraOyunu;

public class Obstacle {
    private int id;
    private String obstacleName;
    private int obstacleDamage;
    private int obstacleHealt;

    private int originalHealt;

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalHealt() {
        return originalHealt;
    }

    public void setOriginalHealt(int originalHealt) {
        this.originalHealt = originalHealt;
    }

    public Obstacle(int id, String obstacleName, int obstacleDamage, int obstacleHealt, int award) {
        this.id = id;
        this.obstacleName = obstacleName;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealt = obstacleHealt;
        this.originalHealt = obstacleHealt;
        this.award = award;
    }

    private int award;

    public Obstacle(int id, String obstacleName,int obstacleDamage,int obstacleHealt){
        this.id = id;
        this.obstacleName = obstacleName;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealt = obstacleHealt;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getObstacleName(){return this.obstacleName;}
    public void setObstacleName(String obstacleName){this.obstacleName = obstacleName;}

    public int getObstacleDamage(){return this.obstacleDamage;}
    public void setObstacleDamage(int obstacleDamage){this.obstacleDamage = obstacleDamage;}

    public int getObstacleHealt(){return this.obstacleHealt;}
    public void setObstacleHealt(int obstacleHealt){
        if (obstacleHealt < 0){obstacleHealt = 0;}
        this.obstacleHealt = obstacleHealt;}
}
