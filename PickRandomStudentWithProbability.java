import java.util.Random;
import java.util.Scanner;

public class PickRandomStudentWithProbability {

    public static void main(String[] args) {

        String[] persons = {"isuf.muca@crystal-system.eu", "danjel.halili@crystal-system.eu", "flavio.lorenci@crystal-system.eu", "elia.omeri@crystal-system.eu", "ardit.elezi@crystal-system.eu", "luka.buziu@crystal-system.eu", "megi.lala@crystal-system.eu", "irena.shahini@crystal-system.eu", "indrit.vaka@crystal-system.eu", "griselda.muci@crystal-system.eu", "theodor.gheorghe@crystal-system.eu", "ioan.cocianu@crystal-system.eu", "teofil.mitrea@crystal-system.eu", "eduard.tiutiu@crystal-system.eu", "george.dobrota@crystal-system.eu", "stefanita.plesa@crystal-system.eu", "adrian-nicolae.tigau@crystal-system.eu", "emanuel.grabovschi@crystal-system.eu", "george.sirbu@crystal-system.eu", "andrei.state@crystal-system.eu", "florin-adrian.dumitru@crystal-system.eu", "victor.hincu@crystal-system.eu"};
        int[] numberOfActivations = new int[persons.length];
        int maxNumOfActivations = 0;

        //Pick first person
        Random random = new Random();
        int index = random.nextInt(persons.length);
        System.out.println("First chosen person is: " + persons[index]);
        numberOfActivations[index] += 1;

        //Pick another students;
        while (true) {
            System.out.println("You want to continue ? \nEnter yes,YES,y,Y,Yes to continue\nEnter no to stop");
            Scanner scan = new Scanner(System.in);
            String answer = scan.next();

            if (answer.equals("no"))
                break;

            //Find max
            for (int i = 0; i < persons.length; i++) {
                if (numberOfActivations[i] > maxNumOfActivations)
                    maxNumOfActivations = numberOfActivations[i];
            }

//controll variable helps to pick a random student if every student is picked once
            int controll = 0;
            while (true) {
                index = random.nextInt(persons.length);
                if (numberOfActivations[index] < maxNumOfActivations) {
                    System.out.println("Chosen student is: " + persons[index]);
                    numberOfActivations[index]++;
                    break;
                } else {
                    controll += 1;
                    if (controll > 2) {
                        index = random.nextInt(persons.length);
                        System.out.println("Chosen student is: " + persons[index]);
                        numberOfActivations[index]++;
                        controll = 0;
                        break;
                    }
                }
            }

        }

        System.out.println("GoodBye !");
    }
}
