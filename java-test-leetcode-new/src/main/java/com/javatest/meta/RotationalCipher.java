package com.javatest.meta;

public class RotationalCipher {
    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + rotationFactor) % 26 + base));
            } else if (Character.isDigit(ch)) {
                result.append((char) ((ch - '0' + rotationFactor) % 10 + '0'));
            } else
                result.append(ch);
        }

        return result.toString();
    }
}
//One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
// Rotating a character means replacing it with another character that
// is a certain number of steps away in normal alphabetic or numerical order.
//For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
// Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
// and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
// Note that the non-alphanumeric characters remain unchanged.
//Given a string and a rotation factor, return an encrypted string.