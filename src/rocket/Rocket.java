package rocket;

import cosmic_objects.CosmicObject;

public class Rocket {
    private static double currentSpeed = 0;
    private final double enginePower = 180000;
    private double totalPower = 0;

    public static class OnBoardComputer { //static nested class
        private static boolean workMode = false;
        public void startOnBoardComputer() {
            if (!workMode) {
                workMode = true;
                System.out.println("Бортовой компьютер запущен.");
            }
            else System.out.println("Бортовой компьютер уже запущен.");
        }
        public void stopOnBoardComputer() {
            if (workMode) {
                workMode = false;
                System.out.println("Бортовой компьютер выключен.");
            } else System.out.println("Бортовой компьютер уже отключен.");
        }

            public static void checkCurrentSpeed() {
            System.out.println("Текущая скорость ракеты - " + currentSpeed + " километров в секунду.");
        }

        public static void checkCosmicInformation(CosmicObject cosmicObject1, CosmicObject cosmicObject2) {
            if ((cosmicObject1.getName().equals("Земля") && cosmicObject2.getName().equals("Луна")) || (cosmicObject1.getName().equals("Луна") && cosmicObject2.getName().equals("Земля"))) {
                System.out.println("Расстояние от Земли до Луны очень большое - около четырехсот тысяч километров. При таком огромном расстоянии скорость двенадцать километров в секунду не так велика, чтоб ее можно было заметить на глаз, да еще находясь в ракете.");
                System.out.println("При такой скорости путь от Земли до Луны займет около " + 400000 / 12 / 3600 + " часов.");
            } else if (cosmicObject1.equals(cosmicObject2)) {
                System.out.println("В качестве аргументов указна один объект. Системная информация отсутсвует.");
            }
            else {
                System.out.println("Бортовой компьюте не обладает информацие по указанным объектам: " + cosmicObject1.getName() + ", " + cosmicObject2.getName());
            }
        }
    }

    public class Engine {   //Non-static nested class (inner class)

        private final String name;
        private boolean ignition;

        public Engine (String name) {
            this.name = name;
            ignition = false;
        }
        public void startEngine() {
            if (!ignition) {
                class CombustionChamber {
                    void addOxidizer() {
                        System.out.println("Впрыск окислителя...");
                    }
                    void addReducingAgent() {
                        System.out.println("Впрыск окислителя...");
                    }
                    void ignite() {
                        System.out.println("Зажигание...");
                        ignition = true;
                        totalPower += enginePower;
                        currentSpeed += 4;
                    }
                }

                CombustionChamber combustionChamber = new CombustionChamber();
                combustionChamber.addOxidizer();
                combustionChamber.addReducingAgent();
                combustionChamber.ignite();

                System.out.println("Двигатель '" + name + "' запущен. Суммарная мощность двигателей - " + totalPower + " киловатт.");
            }
            else System.out.println("Двигатель '" + name + "' уже запущен.");
        }
        public void stopEngine() {
            if (ignition) {
                ignition = false;
                totalPower -= enginePower;
                currentSpeed -= 4;
                System.out.println("Двигатель '" + name + "' остановлен.");
            }
            else System.out.println("Двигатель '" + name + "' уже отключен.");
        }
    }
}
