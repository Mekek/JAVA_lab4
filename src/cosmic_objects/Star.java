package cosmic_objects;

public class Star extends CosmicObject{
    public Star(String name, int distanceToRocket) {
        super(name, distanceToRocket);
        setType(CosmicObjectType.STAR);
    }

    public void shine() {
        System.out.println("Звезда '" + getName() + "' сияла в иллюминаторе.");
    }
}
