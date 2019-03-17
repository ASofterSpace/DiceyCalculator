/**
 * Unlicensed code created by A Softer Space, 2018
 * www.asofterspace.com/licenses/unlicense.txt
 */
package com.asofterspace.diceyCalculator;

import com.asofterspace.toolbox.Utils;


public class Main {

  public final static String PROGRAM_TITLE = "DiceyCalculator";
  public final static String VERSION_NUMBER = "0.0.0.1(" + Utils.TOOLBOX_VERSION_NUMBER + ")";
  public final static String VERSION_DATE = "17. March 2019";

  public static void main(String[] args) {

    // let the Utils know in what program it is being used
    Utils.setProgramTitle(PROGRAM_TITLE);
    Utils.setVersionNumber(VERSION_NUMBER);
    Utils.setVersionDate(VERSION_DATE);
    
    if (args.length<4) {
      System.out.println("Bitte alle vier Parameter eingeben");
      return;
    } // end of if
      
    int number_of_dice=Integer.valueOf(args[0]);
    int target_number=Integer.valueOf(args[1]);
    int successes=Integer.valueOf(args[2]);
    int rerolls=Integer.valueOf(args[3]);
    
    if (target_number<2){
      System.out.println("Die Target Number kann nicht kleiner als 2 sein, bitte eine hoehere Target Number eingeben.");
      return;
    }

    double result=shadowrun_fun(number_of_dice, target_number, successes, rerolls);
    System.out.println("Wahrscheinlichkeiten:");
    System.out.println(result);
  }
    
  public static double shadowrun_fun(int number_of_dice, int target_number, int successes, int rerolls){
    if (successes>number_of_dice){
      return 0;
    }
    if (successes<1){
      return 1;
    }

    if (number_of_dice==1){
      int potenz=(int)Math.floor(target_number/6);
      System.out.println(potenz);
      System.out.println(Math.pow(6,potenz));
      return (1/(Math.pow(6,potenz)))*(1-(((target_number%6)-1.0)/6));  
    } 
    return 0;
  }
}
