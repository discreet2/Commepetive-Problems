package leetcode;

public class Utility {
    public static void main(String[] args) {
        //Remove white space(non visible character)
        System.out.println(" a man can  do".replaceAll("\\s",""));//20% faster
        System.out.println(" a man can  do".replaceAll("\\s+",""));//better when consecutive space
        System.out.println("a good   example".replaceAll("\\s+"," "));//better when consecutive space

        //Keep only alphanumeric character
        System.out.println("-jash ashash 098 laso".replaceAll("[^A-Za-z0-9]",""));

    }
}
