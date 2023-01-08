package people;
import cosmic_objects.CosmicObject;
import cosmic_objects.CosmicObjectType;
import food.CosmicFood;

import java.util.Objects;

public abstract class Human{
    private String name;
    private String location;
    private int satiety;
    private boolean conscious = true;
    private boolean sleepy;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public void setSleepy(boolean sleepy) {
        this.sleepy = sleepy;
    }
    public boolean getSleepy() {
        return sleepy;
    }

    public void setLocation (String location) {
        this.location = location;
    }
    public String getLocation (){
        return location;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setConscious(boolean conscious) {
        this.conscious = conscious;
    }

    public boolean getConscious() {
        return conscious;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, satiety, conscious);
    }

    @Override
    public String toString() {
        return "Персонаж " +
                "под именем '" + name + '\'' +
                " находится в локации:'" + location + '\'' +
                ", сыт на " + satiety +
                ", находится в сознаии: " + conscious;
    }

    public void eat(CosmicFood dish, int amount) throws EmptyArgumentException {
        if (dish != null && amount != 0) {
            if (dish.getNumberOfServings() - amount >= 0) {
                dish.eat(amount);
                if (satiety + dish.getCalories() * amount >= 2500) {
                    satiety += dish.getCalories() * amount;
                    dish.setNumberOfServings(dish.getNumberOfServings() + (satiety - 2500) / dish.getCalories());
                    if ((satiety - 2500) / dish.getCalories() != 0) {
                        System.out.println(name + " объелся. Он не доел " + dish.getName() + " в количестве " + (satiety - 2500) / dish.getCalories() + ". Эта еда вернулась на склад.");
                    } else System.out.println(name + " объелся. Он не доел " + dish.getName() + ".");
                    satiety = 2500;

                } else {
                    satiety += dish.getCalories();
                    System.out.println(name + " съел " + dish.getName() + " в количестве: " + amount);
                }
            } else {
                System.out.println("На ракете нет такого количества еды...");
            }
        }
        else throw new EmptyArgumentException("Передан пустой аргумент!");

    }

    public void go(String place) throws CurrentLocationException, EmptyArgumentException{
        if ("".equals(place)) {
            throw new EmptyArgumentException("Передан пустой аргумент!");
        }
        else if (getLocation().equals(place)) {
            throw new CurrentLocationException(getName() + " уже находится в этой локации!");
        }
        else {
            System.out.println(name + " перешёл из " + location + " в " + place + ".");
            location = place;
        }

    }

    public abstract void sleep();

    public void wakeUp() {
        setConscious(true);
        System.out.println(getName() + " проснулся.");
    }

    public void showHunger() {
        if (satiety > 2000) {
            System.out.println(name + " не голоден.");
            System.out.println(name + " сыт на " + satiety + "/2500.");

        }
        else {
            System.out.println(name + " сыт на " + satiety + "/2500.");
        }
    }

    public void seeCosmicObject(CosmicObject cosmicObject) {
        System.out.println(getName() + " увидел космический объект '" + cosmicObject.getName() + "'.");
    }

    public void say(String speech) {
        System.out.println(getName() + " сказал: " + speech);
    }

    public void checkDistance(CosmicObject cosmicObject) {
        if (cosmicObject.getType() == CosmicObjectType.STAR){
            System.out.println(getName() + " оценил расстояне до космического объекта '" + cosmicObject.getName() + "'. Кажется, что расстояние осталось прежним.");
        } else if (cosmicObject.getName().equals("Луна")) {
            if (cosmicObject.checkFirstCheck()) {
                System.out.println("Луна казалась несколько крупнее, чем обычно кажется нам с Земли.");
                cosmicObject.checkObject();
            }
            else {
                System.out.println(getName() + " посмотрел на Луну. Кажется, что Луна стала в два раза больше.");
            }
        } else if (cosmicObject.getName().equals("Земля")) {
            System.out.println(getName() + " оценил расстояне до Земли . Кажется, что Земля стала значительно меньше.");
        }
        else System.out.println(getName() + " оценил расстояне до космического объекта '" + cosmicObject.getName() + "'. Кажется, что расстояние не изменилось");
    }
}
