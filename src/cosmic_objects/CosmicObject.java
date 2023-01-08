package cosmic_objects;

public abstract class CosmicObject {
    private String name;
    private int distanceToRocket;
    private CosmicObjectType type;

    static private boolean firstCheck = true;

    public CosmicObject (String name, int distanceToRocket) {
        this.name = name;
        this.distanceToRocket = distanceToRocket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CosmicObjectType getType() {
        return type;
    }

    public void setType(CosmicObjectType type) {
        this.type = type;
    }

    public int getDistanceToRocket() {
        return distanceToRocket;
    }

    public void setDistanceToRocket(int distanceToRocket) {
        this.distanceToRocket = distanceToRocket;
    }

    abstract void shine();

    public void checkObject () {
        firstCheck = false;
    }

    public boolean checkFirstCheck () {
        return firstCheck;
    }
}
