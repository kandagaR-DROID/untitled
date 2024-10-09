import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        string = scanner.nextLine();
        char[] firstChar = string.toCharArray();
        while (isExist(' ', firstChar)) {
            firstChar = deleteChar(firstChar, ' ');
        }
        System.out.println(firstChar);
    }

    public static char[] deleteChar(char[] charsToDelete, char x) {//x = чар который удалить нахуй надо
        char[] newChars = new char[charsToDelete.length - 1];
        for (int i = 0; i < charsToDelete.length; i++) {
            if (charsToDelete[i] != x) {
                newChars[i] = charsToDelete[i];
            } else {
                while (i < charsToDelete.length - 1) {
                    newChars[i] = charsToDelete[i + 1];
                    i++;
                }
            }
        }
        return newChars;
    }


    public static int squareInt(int i) {
        return i * i;
    }

    public static boolean isExist(char c, char[] charsArray) {
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] == c)
            {
                return true;
            }
        }
        return false;
    }
}