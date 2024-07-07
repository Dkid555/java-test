package com.javatest.leet_easy;

public class LongPressedName {
    public static boolean isLongPressedName(String name, String typed) {
        int typedPos = 0;
        int namePos = 0;
        if (name.length() > typed.length())
            return false;

        for (; namePos < name.length(); namePos++) {
            if (typedPos < typed.length() && name.charAt(namePos) != typed.charAt(typedPos)) {
                return false;
            } else if (typedPos >= typed.length())
                return false;
            int countNameC = 0;
            while (namePos < name.length() && name.charAt(namePos) == typed.charAt(typedPos)) {
                namePos++;
                countNameC++;
            }
            namePos--;
            int countNameT = 0;
            while (typedPos < typed.length() && name.charAt(namePos) == typed.charAt(typedPos)) {
                typedPos++;
                countNameT++;
            }
            if (countNameT < countNameC)
                return false;
        }
        namePos--;
        if (namePos < typedPos && typedPos < typed.length()) {
            while (typedPos < typed.length()) {
                if (name.charAt(namePos) != typed.charAt(typedPos))
                    return false;
                typedPos++;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alexa", "aaleex"));
    }
}
