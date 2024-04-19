import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Baslangic ucun eded daxil edin: ");
        double num = in.nextDouble();
        in.nextLine();
        String operation;
        double result = num;
        System.out.println("Tetbiq ede bileceyiniz emeller: (+, -, *, /). Bosluq ya da '=' neticeni ekrana cixaracaq. Her daxiletmeden sonra enter-e basin: ");
        while(true){
            operation = in.nextLine();
            if(operation.equals("=")){
                break;
            }if(operation.equals(" ") || operation.equals(null)){
                System.out.println("Son netice: " + result);
                break;
            }
            else if(!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))){
                System.out.println("Teyin edilmemis emel. Yeniden daxil edin: ");
                continue;
            }
            num = in.nextDouble();
            in.nextLine();
            switch(operation){
                case "+": result = result + num; break;
                case "-": result = result - num; break;
                case "*": result = result * num; break;
                case "/": 
                    if(num == 0){
                        System.out.println("0-a bolmek olmaz.");
                        continue;
                    }
                    result = result / num;
                    break;
                case " ": operation = "="; break;  
            }
            System.out.println(result);
        }
        System.out.println("Son netice: " + result);
    }
}