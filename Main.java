//!VIRTUAL PET
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //variables
        int energy = randomizer();
        int fatigue = randomizer();
        int hygiene = randomizer();
        int weight = randomizer();
        char animal;

        //start of the game
        System.out.println("Welcome to the Virtual Pet!");
        System.out.println("what pet would you like to adopt? (cat, dog)");
        String pet_result = scanner.nextLine();

        switch (pet_result){
            case "cat":
                System.out.println("you selected a "+ pet_result+"!");
                animal = 'c';
                break;
            case "dog":
                System.out.println("you selected a "+ pet_result+"!");
                animal = 'd';
                break;
            case "Dog":
                System.out.println("you selected a "+pet_result+"!");
                animal = 'd';
                break;
            case "Cat":
                System.out.println("you selected a "+ pet_result+"!");
                animal = 'c';
                break;
            default:
                System.out.println("Invalid input, please try again!");
                return;
        }

        //game loop
        do{
            System.out.println("******************************");
            System.out.printf("| %-28s |\n", "Bienvenido a nuestro menu!");
            System.out.println("------------------------------");
            System.out.printf("| %-2d. %-25s |\n", 1, "Sleep");
            System.out.printf("| %-2d. %-25s |\n", 2, "Play");

            if (animal == 'c') {
                System.out.printf("| %-2d. %-25s |\n", 3, "Shower");
            } else {
                System.out.printf("| %-2d. %-25s |\n", 3, "Self-cleaning");
            }

            System.out.printf("| %-2d. %-25s |\n", 0, "Exit application");
            System.out.println("******************************");
            int opcion = Scanner.nextInt();
            switch (opcion){

            }



        }while()



    }
    public static int randomizer(){
        Random random = new Random();
        int randomValue = random.nextInt(21)+40;
        return randomValue;
    }

    public static int check_life(int energy, int fatigue, int hygiene, int weight){

        int[] life_status = {energy, fatigue, hygiene, weight};

        for(int i = 0; i < life_status.length;i++){
            int life_check = life_status[i];
            if (life_check > 100){
                System.out.println("Your pet died");
                System.out.println("by:"+life_status[i]);
                return 0;
            } else if (life_check == 0) {
                System.out.println("your pet died");
                System.out.println("by:"+life_status[i]);
                return 0;
            }
        }
        return 1;
    }


}



