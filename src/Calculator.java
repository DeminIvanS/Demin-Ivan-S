import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Введите число: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Что-то пошло не так, попробуйте еще раз");

                Number firstNumber = RomanNumber.parseAndValidate(symbols[0]);
                Number secondNumber = RomanNumber.parseAndValidate(symbols[2], firstNumber.getType());
                String result = MathAction.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Результат: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
                System.out.println("Ввод чисел производится через пробел");

    }

    private static void exitCalc() {

        System.out.println("Калькулятор закрыт.");

    }
}