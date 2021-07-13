package Second;

import java.util.*;

public class Dice {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Game setup: enter number of players and number of dice");
        int N = in.nextInt(); //players
        int K = in.nextInt(); //dice

        int[] wins = new int[N]; //wins

        int[] tries = new int[N];

        int result = 0;
        int iMax;

        do {
            for (int i=0; i<N-1; i++){
                System.out.println("Player " + (i+1) + "`s turn");
                tries[i] = diceJet(result, K);
                System.out.println("Result - " + tries[i]);
            }
            System.out.println("Computer`s turn");
            tries[N-1] = diceJet(result, K);
            System.out.println("Result - " + tries[N-1]);

            iMax = getMax(tries);
            wins[iMax]++;

            System.out.print("Score - ");
            for (int i=0; i<N-1; i++){
                System.out.print(wins[i] + ":");
            }
            System.out.println(wins[N-1]);

        } while (wins[iMax]<7);

        if (iMax<N-1) {
            System.out.println("Player " + (iMax + 1) + " won");
        } else {
            System.out.println("Computer won");
        }

    }

    public static int diceJet(int result, int K){
        result = 0;
        int min = 1;
        int max = 6;

        for (int i=0; i<K; i++){
            result += (int)(Math.random()* ++max) +min;
        }
        return result;
    }

    public static int getMax(int[] inputArray){
            int maxValue = inputArray[0];
            int iMaxValue = 0;
            for(int i=1;i < inputArray.length;i++){
                if(inputArray[i] > maxValue){
                    maxValue = inputArray[i];
                    iMaxValue = i;
                }
            }
        return iMaxValue;
    }
}
