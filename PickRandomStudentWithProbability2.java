
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PickRandomStudentWithProbability2 {
    public static void main(String[] args) {

        //Declare 2 Lists
        //First list contains persons once
        //Second list contains each person 10 times

        //Probability : P(A)= n(a)/n(S)

        List<String> persons= List.of("isuf.muca@crystal-system.eu", "danjel.halili@crystal-system.eu", "flavio.lorenci@crystal-system.eu", "elia.omeri@crystal-system.eu", "ardit.elezi@crystal-system.eu", "luka.buziu@crystal-system.eu", "megi.lala@crystal-system.eu", "irena.shahini@crystal-system.eu", "indrit.vaka@crystal-system.eu", "griselda.muci@crystal-system.eu", "theodor.gheorghe@crystal-system.eu", "ioan.cocianu@crystal-system.eu", "teofil.mitrea@crystal-system.eu", "eduard.tiutiu@crystal-system.eu", "george.dobrota@crystal-system.eu", "stefanita.plesa@crystal-system.eu", "adrian-nicolae.tigau@crystal-system.eu", "emanuel.grabovschi@crystal-system.eu", "george.sirbu@crystal-system.eu", "andrei.state@crystal-system.eu", "florin-adrian.dumitru@crystal-system.eu", "victor.hincu@crystal-system.eu");
        ArrayList<String> personChances= new ArrayList<>();

        for(int i=0;i<persons.size();i++){
            for(int j=0;j<10;j++)
                personChances.add(persons.get(i));
        }
        Random random = new Random();

        while(true){
           int index = random.nextInt(personChances.size());
           System.out.println("Chosen person is: " + personChances.get(index));
           personChances.remove(index);

           //Fill personChances if it is empty
            //It becomes empty when everyone is picked 10 times
            if (personChances.size() == 0) {

                for (int i = 0; i < persons.size(); i++) {
                    for (int j = 0; j < 10; j++)
                        personChances.add(persons.get(i));
                }
            }


            System.out.println("You want to continue ? \nEnter yes,YES,y,Y,Yes to continue\nEnter no to stop");
            Scanner scan = new Scanner(System.in);
            String answer = scan.next();

            if (answer.equals("no"))
                break;
        }
    }
}
