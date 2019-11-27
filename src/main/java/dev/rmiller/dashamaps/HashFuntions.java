package dev.rmiller.dashamaps;

public class HashFuntions {

    public static int hashFunctionOne(String key) {
        if (key.length() > 0) {
            return Character.toLowerCase(key.charAt(0)) - 'a';
        }
        return -1;
    }

    public static int hashFunctionTwo(String key) {
        if (key.length() > 1) {
            return Character.toLowerCase(key.charAt(1)) - 'a';
        } else {
            return hashFunctionOne(key);
        }
    }

    public static int hashFunctionThree(String key) {
        if (key.length() > 1) {
            int secondDigit = Character.toLowerCase(key.charAt(0)) - 'a';
            int firstDigit  = Character.toLowerCase(key.charAt(1)) - 'a';
            return (secondDigit * 26) + firstDigit;
        } else {
            return hashFunctionOne(key);
        }
    }

}
