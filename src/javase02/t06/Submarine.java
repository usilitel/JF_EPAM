package javase02.t06;

import javase02.t07.*;


// АтомнаяЛодка
@EngineModel(engineModel="двигатель 1.0")
public class Submarine {
    private String model; // модель
    private int airRest; // количество баллонов с воздухом
    private Engine engine;

    Submarine(String modelSubmarine, int airRest, String modelEngine, double fuelRest){
        this.model = modelSubmarine;
        this.airRest = airRest;
        engine = new Engine(modelEngine, fuelRest);
    }


    public void startSubmarine(){
        System.out.println("АПЛ запущена");
    }

    public int checkSubmarine(){
        if(airRest < 100) return 0; // недостаточно воздуха
        return engine.checkEngine(); // проверка двигателя
    }

    // внутренний класс – ДвигательДляАтомнойЛодки
    private class Engine{
        private String model; // модель
        private double fuelRest; // количество оставшегося топлива

        Engine(String model, double fuelRest){
            this.model = model;
            this.fuelRest = fuelRest;
        }

        public int checkEngine(){
            if(fuelRest < 10) return 0; // слишком мало топлива осталось

            System.out.println("проверка двигателя прошла успешно");
            return 1;
        }
    }
}
