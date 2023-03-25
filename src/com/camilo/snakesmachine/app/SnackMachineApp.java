package com.camilo.snakesmachine.app;

import com.camilo.snakesmachine.domain.Snack;
import com.camilo.snakesmachine.domain.SnackMachine;

import java.util.Scanner;

public class SnackMachineApp {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner EnterData = new Scanner(System.in);
        SnackMachine snacksMachine1 = new SnackMachine("snackMachine");
        String decision;
        boolean aux = true;
        do {
            System.out.println("Write:\n1. to add snack\n2. to take out unit by code" +
                    "\n3. take out unit by name\n4. up units of snack by code\n" +
                    "5. delete snacks by code\n6. get amount units of determinate snack\n7. show snacks\n" +
                    "8. to sort by amount of units up to down\n9. sort by amount of units down to up\n10. to" +
                    "get name of out stock snacks\n11. to close");
            decision = EnterData.nextLine();

            switch (decision) {
                case "1":
                    System.out.println("write the snack name");
                    String snackName = EnterData.nextLine();
                    System.out.println("write the snack code");
                    String snackCode = EnterData.nextLine();
                    System.out.println("write the snack price");
                    double snackPrice = EnterData.nextFloat();
                    Snack sk1 = new Snack(snackName, snackCode,snackPrice);
                    snacksMachine1.addSnake(sk1);
                    EnterData.nextLine();
                    break;
                case "2":
                    System.out.println("write the code");
                    String code = EnterData.next();
                    snacksMachine1.takeOutSnackByCode(code);
                    EnterData.nextLine();
                    break;
                case "3":
                    System.out.println("write the snack name");
                    snackName = EnterData.nextLine();
                    snacksMachine1.takeOutSnackForName(snackName);
                    break;
                case "4":
                    System.out.println("write the code");
                    String name = EnterData.nextLine();
                    System.out.println("write the units");
                    int units = EnterData.nextInt();
                    snacksMachine1.increaseAmountTheSnack(units,name);
                    EnterData.nextLine();
                    break;
                case "5":
                    System.out.println("write the code");
                    code = EnterData.nextLine();
                    snacksMachine1.deleteSnackByCode(code);
                    break;
                case "6":
                    System.out.println("write the code");
                    code = EnterData.nextLine();
                    snacksMachine1.getUnitsOfTheSnakeDeterminate(code);
                    break;
                case "7":
                    snacksMachine1.getNameAndUnitsOfTheSnack();
                    break;
                case "8":
                    snacksMachine1.sortedTheHighToLowest();
                    break;
                case "9":
                    snacksMachine1.sortTheLowestToHigh();
                    break;
                case "10":
                    System.out.println(snacksMachine1.getNameSnakesSoldOutStock());
                    break;
                case "11":
                    System.out.println("Program completed");
                    aux = false;
                    break;
                default:
                    System.out.println("write a correct number");
            }
        } while (decision != "11" && aux);


    }
}
