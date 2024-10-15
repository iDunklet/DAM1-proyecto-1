//!VIRTUAL PET
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //?variables
        int energy = randomizer();
        int fatigue = randomizer();
        int hygiene = randomizer();
        int weight = randomizer();
        int sleep = randomizer();
        char animal;
        int opcion = -1;

        //?start of the game
        String pet_result=tipo_de_pet(scanner);
        Skip();
        //game loop
        try {
            do {
                menu(pet_result);
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 0:
                        System.out.println("Exiting the application...");
                        break;

                    case 1:
                        if (pet_result.equals("cat")){
                            System.out.println("Your "+pet_result+" slept!");
                            sleep=sleep-20;
                        } else {
                            System.out.println("Your "+pet_result+" slept!");
                            sleep=sleep-25;
                        }
                        fatigue=fatigue-15;
                        energy=energy+15;
                        break;

                    case 2:
                        if (pet_result.equals("cat")){
                            System.out.println("You played with your "+pet_result+"!");
                            sleep=sleep-20;
                        } else {
                            System.out.println("You played with your "+pet_result+"!");
                            sleep=sleep-15;
                        }
                        fatigue=fatigue-15;
                        energy=energy+15;
                        break;
                    case 3:
                        if (pet_result.equals("cat")){
                            System.out.println("Your "+pet_result+" ate!");
                            sleep=sleep+10;
                        }   else {
                            System.out.println("Your "+pet_result+" ate!");
                            sleep=sleep+15;
                        }
                        energy=energy+10;
                        hygiene=hygiene-10;
                        weight=weight+5;
                        break;
                    case 4:
                        if (pet_result.equals("cat")){
                            System.out.println("Your "+pet_result+" self-cleaned!");
                            sleep=sleep+10;
                            hygiene=hygiene+20;
                        } else {
                            System.out.println("Your "+pet_result+" showered!");
                            sleep=sleep-15;
                            hygiene=hygiene-20;
                        }
                        break;
                    case 5:
                        show_status(energy, fatigue, hygiene, weight, sleep);
                        scanner.nextLine();
                        break;

                    default:
                        System.out.println("Invalid option, please try again!");
                        break;
                }
                check_life(energy, fatigue, hygiene, weight, sleep, scanner);

            }while (opcion!= 0);

        }catch (InputMismatchException e){
            System.out.println("Invalid input, please enter a number!\n");
            scanner.nextLine();
            opcion = -1;
        }finally {
            scanner.close();
        }
    }

    private static void Skip() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    private static void show_status(int energy, int fatigue, int hygiene, int weight,int sleep) {
        System.out.println("\n| Your pet's status:\n");
        System.out.printf("| Energy: "+energy+"\n");
        System.out.printf("| Fatigue: "+fatigue+"\n");
        System.out.printf("| Hygiene: "+hygiene+"\n");
        System.out.printf("| Weight: "+weight+"\n");
        System.out.printf("| Sleep: "+sleep+"\n");
        System.out.println("Press any key to come back to original menu...");
    }

    private static String tipo_de_pet(Scanner scanner) {
        System.out.println("\nWelcome to the Virtual Pet!");
        System.out.println("\nWhat pet would you like to adopt? (cat, dog)");
        String pet_result = scanner.nextLine().toLowerCase();
        System.out.println("You selected a " + pet_result + "!\n");
        return pet_result;
    }

    public static void menu(String pet_result) {
        System.out.println("\n******************************");
        System.out.printf("| %-28s |\n", "Bienvenido a nuestro menu!");
        System.out.println("------------------------------");
        System.out.printf("| %-2d. %-25s |\n", 1, "Sleep");
        System.out.printf("| %-2d. %-25s |\n", 2, "Play");
        System.out.printf("| %-2d. %-25s |\n", 3, "Eat");

        if (pet_result.equals("cat")) {
            System.out.printf("| %-2d. %-25s |\n", 4, "Self-cleaning");
        } else {
            System.out.printf("| %-2d. %-25s |\n", 4, "Shower");
        }
        System.out.printf("| %-2d. %-25s |\n", 5, "Pet status");
        System.out.printf("| %-2d. %-25s |\n", 0, "Exit application");
        System.out.println("******************************\n");
        System.out.print("Choose an option(number): ");
    }

    public static int randomizer(){
        Random random = new Random();
        int randomValue = random.nextInt(21)+40;
        return randomValue;
    }

    public static int check_life(int energy, int fatigue, int hygiene, int weight,int sleep, Scanner scanner){

        int[] life_status = {energy, fatigue, hygiene, weight};
        String[] Slife_status = {"energy", "fatigue", "hygiene", "weight"};


        for(int i = 0; i < life_status.length;i++){
            int life_check = life_status[i];
            if (life_check > 100){
                System.out.println("\nYour pet died");
                System.out.println("by high: "+Slife_status[i]);
                scanner.close();
                System.exit(0);

            } else if (life_check <= 0) {
                System.out.println("\nyour pet died");
                System.out.println("by low: "+Slife_status[i]);
                scanner.close();
                System.exit(0);

            }
        }
        return 1;
    }
}





