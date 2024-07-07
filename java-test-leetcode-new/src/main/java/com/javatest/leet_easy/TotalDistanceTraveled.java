package com.javatest.leet_easy;

public class TotalDistanceTraveled {
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int total = 0; //расход на 1 литр - 10 км, каждые 5 литров из доп бака перевливается 1 литр если есть
        while (mainTank >= 0) {
            if (mainTank < 5 || additionalTank == 0) return total + mainTank * 10;
            total += 50;
            mainTank = mainTank - 5 + (additionalTank > 0 ? 1 : 0);
            --additionalTank;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(distanceTraveled(14, 1));
    }
}


//A truck has two fuel tanks. You are given two integers,
// mainTank representing the fuel present in the main tank in liters
// and additionalTank representing the fuel present in the additional tank in liters.
//
//The truck has a mileage of 10 km per liter. Whenever 5 liters of fuel
// get used up in the main tank, if the additional tank has at least 1 liters
// of fuel, 1 liters of fuel will be transferred from the additional tank to the main tank.
//
//Return the maximum distance which can be traveled.
//
//Note: Injection from the additional tank is not continuous.
// It happens suddenly and immediately for every 5 liters consumed.