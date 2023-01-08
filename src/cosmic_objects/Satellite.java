package cosmic_objects;

public class Satellite extends CosmicObject {
    public Satellite(String name, int distanceToRocket) {
        super(name, distanceToRocket);
        setType(CosmicObjectType.SATELLITE);
    }

    public void shine() {
        System.out.println("Спутник '" + getName() + "' светилcя в одном из иллюминаторов.");
    }

}
