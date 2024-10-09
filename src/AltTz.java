import java.util.Scanner;
public class AltTz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String newString = stringOneM(string);
        System.out.println(newString);
    }
    public static String stringOneM(String string){
        char[] charOne = string.toCharArray();
        char[] charTwo = new char[charOne.length];
        char[] charThree = new char[charOne.length];
        if(charOne[0] != '"') {
            throw new RuntimeException();
        }
        int a = 0;
        int b = 0;
        int number = 0;
        for (int i = 1; i < charOne.length; i++) {
            if (charOne[i] != '"') {
                charTwo[a++] = charOne[i];
            } else {
                break;
            }
        }
        if(isString(charOne[a+5])){
            for (int i = a+6; i < charOne.length; i++) {
                if(charOne[i] != '"'){
                    charThree[b++] = charOne[i];
                }
            }
        } else {
            for (int i = a + 5; i < charOne.length; i++) {
                charThree[b++] = charOne[i];
            }
        }
        char[] resultCharTwo = new char[a];
        for (int i = 0; i < resultCharTwo.length; i++) {
            resultCharTwo[i] = charTwo[i];
        }
        char[] resultCharThree = new char[b];
        for (int i = 0; i < resultCharThree.length; i++) {
            resultCharThree[i] = charThree[i];
        }
        char p = charOne[a+3];
        char z = '"';
        String string1 = String.valueOf(resultCharTwo);
        String string3 = String.valueOf(resultCharThree);
        if(isString(charOne[a+5])){
        } else {
            number = Integer.parseInt(string3);
            if(isNotNumberOneToTen(number)) {
                throw new RuntimeException();
            }
        }
        String finalString = "";
        if(p == '+'){
            finalString = string1 + string3;
        } else {
            if(p == '-'){
                finalString = string1.replaceFirst(string3, "");
            } else {
                if(p == '*'){
                    for (int i = 0; i < number; i++) {
                        finalString = string1 + finalString;
                    }
                    char[] finalCharOne = finalString.toCharArray();
                    if(finalCharOne.length > 40){
                        char[] theFinalChar40 = new char[43];
                        for (int i = 0; i < 40; i++) {
                            theFinalChar40[i] = finalCharOne[i];
                            theFinalChar40[40] = '.';
                            theFinalChar40[41] = '.';
                            theFinalChar40[42] = '.';
                        }
                        finalString = String.valueOf(theFinalChar40);
                    } else {
                        finalString = String.valueOf(finalCharOne);
                    }
                } else {
                    if(p == '/'){
                        if(isNotNumberOneToTen(number)){
                            throw new RuntimeException();
                        }
                        char[] chars = string1.toCharArray();
                        int c = 0;
                        for (int i = 0; i < chars.length; i++) {
                            c++;
                        }
                        c = c / number;
                        char[] theFinalChar = new char[c];
                        for (int i = 0; i < c; i++) {
                            theFinalChar[i] = chars[i];
                        }
                        if(theFinalChar.length > 40){
                            char[] theFinalChar40 = new char[42];
                            for (int i = 0; i < 40; i++) {
                                theFinalChar40[i] = theFinalChar[i];
                                theFinalChar40[40] = '.';
                                theFinalChar40[41] = '.';
                                theFinalChar40[42] = '.';
                            }
                            finalString = String.valueOf(theFinalChar40);
                        } else {
                            finalString = String.valueOf(theFinalChar);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        }
        return z + finalString + z;
    }
    public static Boolean isString(char x){
        if (x == '"'){
            return true;
        } else {
            return false;
        }
    }
    public static Boolean isNotNumberOneToTen(int z){
        if (z == 1 || z == 2 || z == 3 || z == 4 || z == 5 || z == 6 || z == 7 || z == 8 || z == 9 || z == 10){
            return false;
        } else {
            return true;
        }
    }
}