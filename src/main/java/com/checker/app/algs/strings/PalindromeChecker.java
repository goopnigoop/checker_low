package com.checker.app.algs.strings;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(isPalindromea("qwertyuio12oiuytrewq"));
        System.out.println(isPalindromeb("qwertyuio12oiuytrewq"));
        System.out.println(isPalindromec("qwertyuio12oiuytrewq"));
    }

    private static boolean isPalindromec(String str) {
        int i = 0; int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeb(String str) {
        StringBuilder temp = new StringBuilder();
        for (int i = str.length()-1; i >=0; i--) {
            temp.append(str.charAt(i));
        }
        return temp.toString().equals(str);
    }

    private static boolean isPalindromea(String qwertyuiooiuytrewq) {
        char[] chars = qwertyuiooiuytrewq.toCharArray();
        for (int i = 0; i <qwertyuiooiuytrewq.length()/2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
