
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BreadAlgorithm {

    //Main Method
    public static void main(String[] args) {
        BreadAlgorithm test = new BreadAlgorithm();
        test.scanBread();

        
    }

    //Bread Scanner
    public void scanBread(){
        //initialize scanner
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        Scanner timeRead = new Scanner(System.in);
        
        //ask user if they want to make bread now or have bread ready by a certain time

        System.out.println("Get b-ready! Do you want to 1: make bread now, 2: you already started, or 3: plan a time for bread to be ready later?");
        System.out.println("Note that this calculator is intended for Alex's Bakery recipes only.");
        System.out.println("1: Bread Now, 2: Bread Later, 3: Bread WIP");
        String breadOption = timeRead.nextLine();

        if(breadOption.equals("1")){

            LocalTime time = LocalTime.now();
            String formattedTime = time.format(formatter);

            System.out.println("The time now is: " + formattedTime);

            focacciaRecipeForwards(formattedTime);
            
        }
        if(breadOption.equals("2")){

            System.out.println("Let's get our hands messy. What time do you need it? (e.g., 06:30 p (hh:mm a)): ");

            String input = timeRead.nextLine();

            LocalTime time = LocalTime.parse(input);
            String timeStart = time.format(formatter);

            focacciaRecipeForwards(timeStart);

        }


        //end of program
        System.out.println(" ");
        System.out.println("Do you want to do another calculation? y or n");

        String responseClose = timeRead.nextLine();
        if(responseClose.equals("Y")){
            scanBread();
          }
          else{
            timeRead.close();
          }
        }

    private void focacciaRecipeForwards(String formattedTime) {
        System.out.println("Happy you're in a flour-y mood. Here's an outline of the process.");

        //mix ingredients
        System.out.println("Once you mix your ingredients, let dough rest for 20 minutes.");

        //dough rest
        String doughRested = calculateMinutes(formattedTime, 20);

        System.out.println("The dough will rest until " + doughRested);

        //Bulk Fermentation

        //The first fold, using 25 minutes as rest time

        String firstFold = calculateMinutes(doughRested, 25);
        System.out.println(doughRested + ": first fold done");

        //The second fold, using 25 minutes as rest time

        String secondFold = calculateMinutes(firstFold, 25);
        System.out.println(secondFold + ": second fold done");

        //The third fold, using 25 minutes as rest time

        String thirdFold = calculateMinutes(secondFold, 25);
        System.out.println(thirdFold + ": third fold done");

        //The fourth fold, using 25 minutes as rest time

        String fourthFold = calculateMinutes(thirdFold, 25);
        System.out.println(fourthFold + ": fourth fold done");

        //Proofing (Second Ferment)

        System.out.println("Time to proof!");

        //Time to prep dough

        String prepTime = calculateMinutes(fourthFold, 5);

        System.out.println("Get that olive oil and pan out with parchment paper. That should put you at " +prepTime);

        String proofTime = calculateMinutes(prepTime, 45);

        System.out.println("Your 45-min proof should be done by " + proofTime + "! Be sure to preheat the oven to 450F.");

        //Bake for 23 minutes

        String bakeTime = calculateMinutes(proofTime, 23);

        System.out.println("Your bread will be done at: " + bakeTime);

        //Rest on wire rack for 5 minutes

        String restTime = calculateMinutes(bakeTime, 5);

        System.out.println("Make sure to rest it until " + restTime);
    }
    private String calculateMinutes (String input, long mins){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime LT = LocalTime.parse(input, formatter).plusMinutes(mins);
        String mainTime = LT.format(formatter);

        return mainTime;

    }
    
}