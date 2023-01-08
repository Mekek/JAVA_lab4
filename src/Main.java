import cosmic_objects.Planet;
import rocket.Rocket;
import cosmic_objects.Satellite;
import cosmic_objects.Star;
import people.*;
import food.*;
import rocket.RocketLaunch;

public class Main {
    public static void main(String[] args) {



        Soup soup1 = new Soup("борщ (красный)", 10);
        Soup soup2 = new Soup("борщ (оранжевый)", 10);
        Cutlet cutlet = new Cutlet("Котлета по-киевски", 12);
        Sausage sausage = new Sausage("Баварская колбаска к пиву", 11);
        TomatoJuice tomatoJuice = new TomatoJuice("Томатный сок", 10);
        System.out.println();


        System.out.println("Проверка equals, hashCode, toString для еды.");
        System.out.println(soup1.equals(soup2));
        System.out.println(soup1.hashCode());
        System.out.println(tomatoJuice);
        System.out.println();


        Neznayka neznayka = new Neznayka("главная палуба", 2100);
        Ponchik ponchik = new Ponchik("главная палуба", 350);
        System.out.println();


        System.out.println("Проверка equals, hashCode, toString для персонажей.");
        System.out.println(neznayka.equals(ponchik));
        System.out.println(ponchik.hashCode());
        System.out.println(neznayka);
        System.out.println();

        RocketLaunch rocketLaunch = new RocketLaunch() {  //Anonymous class

            Rocket.OnBoardComputer onBoardComputer = new Rocket.OnBoardComputer();
            Rocket rocket = new Rocket();
            Rocket.Engine engine1 = rocket.new Engine("Двигатель 1");
            Rocket.Engine engine2 = rocket.new Engine("Двигатель 2");
            Rocket.Engine engine3 = rocket.new Engine("Двигатель 3");
            @Override
            public void launchRocket() {
                onBoardComputer.startOnBoardComputer();
                engine1.startEngine();
                engine2.startEngine();
                engine3.startEngine();
                System.out.println();
            }

            public void turnOffRocket() {
                engine1.stopEngine();
                engine2.startEngine();
                engine3.startEngine();
                onBoardComputer.stopOnBoardComputer();
                System.out.println();
            }
        };

        rocketLaunch.launchRocket();

        try {
            neznayka.go("астрономическая кабина");
            ponchik.go("астрономическая кабина");
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }

        Star sun = new Star("Солнце", 1440000000);
        Star star1 = new Star("Звезда1", 995444666);
        Star star2 = new Star("Звезда2", 955844606);
        Star star3 = new Star("Звезда3", 915847654);
        Satellite moon = new Satellite("Луна", 200000);
        Planet earth = new Planet("Земля", 200000);

        System.out.println();
        neznayka.seeCosmicObject(sun);
        neznayka.seeCosmicObject(star1);
        neznayka.seeCosmicObject(star2);
        neznayka.seeCosmicObject(star3);
        ponchik.seeCosmicObject(sun);
        ponchik.seeCosmicObject(star1);
        ponchik.seeCosmicObject(star2);
        ponchik.seeCosmicObject(star3);

        moon.shine();
        System.out.println();

        neznayka.checkDistance(moon);
        System.out.println();

        ponchik.say("Ну что ж, поскольку мы летим на Луну и назад все пути отрезаны, теперь у нас только одна задача: пробраться обратно в пищевой отсек и как следует позавтракать.");

        try {
            neznayka.go("пищеблок");
            ponchik.go("пищеблок");
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        neznayka.showHunger();
        ponchik.showHunger();
        System.out.println();

        try {
            neznayka.eat(cutlet, 1);
            ponchik.eat(sausage, 11);
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }
        neznayka.showHunger();
        ponchik.showHunger();
        System.out.println();


        System.out.println("Незнайка хочет спать? " + neznayka.getSleepy());
        System.out.println("Пончик хочет спать? " + ponchik.getSleepy());
        System.out.println();

        ponchik.sleep();
        System.out.println();

        try {
            neznayka.go("астрономическая кабина");
            System.out.println();
        } catch (EmptyArgumentException e) {
            System.out.println(e.getMessage());
        }


        sun.shine();
        moon.shine();
        System.out.println();

        neznayka.checkDistance(sun);
        neznayka.checkDistance(moon);
        System.out.println();

        Rocket.OnBoardComputer.checkCurrentSpeed();
        Rocket.OnBoardComputer.checkCosmicInformation(moon, earth);

    }
}

