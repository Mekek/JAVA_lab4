package cosmic_objects;

public class Planet extends CosmicObject{
    public Planet(String name, int distanceToRocket) {
        super(name, distanceToRocket);
        setType(CosmicObjectType.PLANET);
    }

    public void shine() {
        System.out.println("Планета " +  getName() + "' не может сиять, разве что отражать свет.");
    }
}
