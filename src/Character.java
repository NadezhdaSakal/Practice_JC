
public abstract class Character implements Fight {


    private String name;
    private int HealthPoint;
    private int Gold;
    private int dexterity;
    private int experience;
    private int force;

    public Character(String name, int HealthPoint, int Gold,
                     int dexterity, int experience, int force) {

        this.name = name;
        this.HealthPoint = HealthPoint;
        this.Gold = Gold;
        this.dexterity = dexterity;
        this.experience = experience;
        this.force = force;
    }

    @Override
    public int attack() {
        if (dexterity * 5 > RandomValue()) return force;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoint() {
        return HealthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        HealthPoint = healthPoint;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int RandomValue() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, HealthPoint);
    }


}


