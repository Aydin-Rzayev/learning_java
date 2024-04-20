import java.util.Scanner;

// todo əlavə olaraq git convention-la tanış olmağınız tövsiyyə edilir
// todo InputMismatchException nəzərə alınmayıb. Ədə olaraq sətr daxil edirəm və bu istisna baş verir
// todo OOP-dan istifadə edərək daha optimal yazmaq olar kodu. Məsələn, bir neçə method yaradaraq.
public class Calculator{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Baslangic ucun eded daxil edin: ");
        double num = in.nextDouble();
        in.nextLine();
        String operation;
        double result = num; // todo double-da dəqiqlik olmaya bilər. BigDecimal - https://stackoverflow.com/questions/3413448/double-vs-bigdecimal
        System.out.println("Tetbiq ede bileceyiniz emeller: (+, -, *, /). Bosluq ya da '=' neticeni ekrana cixaracaq. Her daxiletmeden sonra enter-e basin: ");
        while(true){
            operation = in.nextLine();
            if(operation.equals("=")){
                break; // todo coding convention-la tanış olmağınız tövsiyyə edilir. Hər yeni if bloku yeni sətirnən olmalıdır.
            }if(operation.equals(" ") || operation.equals(null)){  // todo String class-ı ilə yaxından tanış olun -.isBlank() .isEmpty()
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
                // todo kod heç vaxt bura çatan deyil
                case " ": operation = "="; break;
            }
            System.out.println(result);
        }
        System.out.println("Son netice: " + result);
    }
}