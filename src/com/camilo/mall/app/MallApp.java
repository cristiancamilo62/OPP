package com.camilo.mall.app;

import com.camilo.mall.domain.Category;
import com.camilo.mall.domain.Mall;
import com.camilo.mall.domain.Store;

import java.util.Scanner;

public class MallApp {
    public static void main(String[] args) {
        menu();
    }
    public static  void menu(){
        Scanner enterData = new Scanner(System.in);
        Mall sanAndres = new Mall("sanAndres");
        String option = "";
        boolean close = true;
        do{
            System.out.println("1. to open store\n2. to close store for code\n3. search store by name\n4. search store by code" +
                    "\n5. search stores by category\n6. to get stores with more the two categories\n7. sort stores by name" +
                    "\n8. finish program:(");
            option = enterData.nextLine();
            switch(option){
                case "1":
                    int numCategories = 0;
                    System.out.println("Enter name");
                    String name = enterData.nextLine();
                    System.out.println("Enter code");
                    long code = enterData.nextLong();
                    Store store = new Store(code,name);
                    enterData.nextLine();
                    System.out.println("How many categories you want to have in the store");
                    numCategories = enterData.nextInt();
                    int aux = 1;
                    enterData.nextLine();
                    while (aux <= numCategories){
                        System.out.println("Enter category "+ aux);
                        String category = enterData.nextLine();
                        Category ct = new Category(category);
                        store.getCategories().add(ct);
                        aux++;
                    }
                    sanAndres.openStore(store);
                    break;
                case "2":
                    System.out.println("Enter the code");
                    code = enterData.nextLong();
                    sanAndres.closeStoreForCode(code);
                    break;
                case "3":
                    System.out.println("Enter name the store to search");
                    name = enterData.nextLine();
                    System.out.println(sanAndres.searchStoreByName(name));
                    break;
                case "4":
                    System.out.println("Enter code the store to search");
                    code = enterData.nextLong();
                    sanAndres.searchStoreByCode(code);
                    break;
                case "5":
                    System.out.println("Enter category for search stores");
                    String category = enterData.nextLine();
                    System.out.println(sanAndres.searchStoreForDeterminateCategory(category));
                    break;
                case "6":
                    System.out.println(sanAndres.getStoreWithTwoMoreTheTwoCategories());
                    break;
                case "7":
                    sanAndres.sortedStoresByName();
                    System.out.println(sanAndres.getStores());
                    break;
                case "8":
                    close = false;
                    break;

            }

        }while(option != "8" && close);
    }
}
