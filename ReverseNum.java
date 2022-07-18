import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args){

        Scanner input= new Scanner(System.in);
        System.out.println("Enter Num:");

        int num=input.nextInt();

        int temp=0;
        int i;

        while(num>0){
            i= num%10;
            temp=temp*10 +i;
            num=num/10;
        }

        System.out.println(temp);

    }
}
