package src;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class TextAnalyzerMainApp {

    private static void chooseFile() throws MalformedURLException, FileNotFoundException {

        System.out.println("Download file from internet? [Y/N]");
        Scanner sc = new Scanner(System.in);
        String select = sc.nextLine();
        if (select.equals("y") || select.equals("Y")) {
            System.out.println("Enter URL address: ");
            String urlAddress = sc.nextLine();
            URL web = new URL(urlAddress);
            try (InputStream in = web.openStream()) {
                Files.copy(in, Path.of("plik.txt"));
            } catch (IOException e) {
                System.out.println("URL address isn't correct");
                e.printStackTrace();
            }
            // https://s3.zylowski.net/public/input/7.txt
        } else if (select.equals("n") || select.equals("N")) {
            System.out.println("Enter file name: ");
            String fileName = sc.nextLine();
            try {
                FileReader fr = new FileReader(fileName);
                Files.copy(Paths.get(fileName), Path.of(fileName));
            } catch (IOException e) {
                System.out.println("File isn't exist");
                e.printStackTrace();
            }

        } else {
            System.out.println("Pick correct option next time. ");
        }

    }

    private static int countChars() {
        String file = "plik.txt";
        String worlds = null;
        try {

            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }
        int vowels = 0;
        int consonants = 0;

        for (int i = 0, length = worlds.length(); i < length; i++) {
            if (worlds.equals("a") || worlds.equals("e") ||
                    worlds.equals("i") || worlds.equals("o") ||
                    worlds.equals("u")) {

                vowels++;
            } else {
                consonants++;

            }
            System.out.print("The number of vowels is " + vowels);
            System.out.print(" The number of consonants is " + consonants);
        }
        int characters = 0;
        for (int i = 0, length = worlds.length(); i < length; i++) {
            if (worlds.charAt(i) != ' ') {
                characters++;
            }
        }
        return characters;

    }

    private static int countWords() {
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }
        String[] w = worlds.split("\\s");
        return w.length;
    }

    private static int countSentence() {
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }
        String[] w = worlds.split("[.]");
        return w.length + 1;
    }

    private static void generateLettersRaport() {
        final int MAX_CHAR = 256;
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }
        char[] array = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        System.out.println("Please enter a sentence to parse.");
        String userString = worlds;
        System.out.println("samogloski = " + countVowel(userString));
        System.out.println("Spolgloski = " + countConsonant(userString));
        System.out.println("Liczba wyrazow: " + countWords());
        System.out.println("Liczba zdań: " + countSentence());
        HashMap<Character, Integer> charint = new HashMap<>();

        for (Character c : userString.toCharArray()) {
            if (charint.containsKey(c)) charint.replace(c, charint.get(c).intValue() + 1);
            else charint.put(c, 1);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " : " + (charint.get(array[i]) == null ? "0" : charint.get(array[i])));
        }

    }

    public static int countVowel(String z) {
        char n;
        int vowel = 0;
        for (int i = 0; i < z.length(); i++) {
            n = z.charAt(i);
            if (Character.toString(n).matches("[AEYUIOaeyuio]")) {
                vowel++;
            }
        }
        return vowel;
    }

    public static int countConsonant(String z) {
        char n;
        int col = 0;
        for (int i = 0; i < z.length(); i++) {
            n = z.charAt(i);
            if (Character.toString(n).matches("[a-zA-Z&&[^aeyuioAEYUIO]]")) {
                col++;
            }
        }
        return col;
    }


    public static int countPuncMarks() {
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }

        int countPuncMark = 0;
        for (int i = 0, length = worlds.length(); i < length; i++) {
            if (worlds.charAt(i) == ',' || worlds.charAt(i) == '.' || worlds.charAt(i) == '?') {
                countPuncMark++;
            }
        }

        return countPuncMark;

    }

    public static int countChar() {
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }

        int countChar = 0;
        for (int i = 0, length = worlds.length(); i < length; i++) {
            if (worlds.charAt(i) == '.' || worlds.charAt(i) == '?') {
                countChar++;
            }
        }
        return countChar;
    }

    public static void main(String[] args) throws IOException {
        final int chooseFile = 1;
        final int countNumberOfLetters = 2;
        final int countNumberOfWords = 3;
        final int countNumberOfPunctuationMarks = 4;
        final int countNumberOfPhrases = 5;
        final int generateLettersRaport = 6;
        final int saveStats = 7;
        final int exit = 0;
        Scanner input = new Scanner(System.in);
        int option = -1;

        while (option != exit) {
            System.out.println("Options: ");
            System.out.println("0 - Exit");
            System.out.println("1 - Choose enter file");
            System.out.println("2 - Count number of letters");
            System.out.println("3 - Count number of words");
            System.out.println("4 - Count number of punctuation marks");
            System.out.println("5 - Count number of phrases");
            System.out.println("6 - Generate letters raport");
            System.out.println("7 - Save statistics of txt file");


            System.out.println("Pick option: ");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case chooseFile:
                    chooseFile();
                    break;
                case countNumberOfLetters:
                    System.out.println(countChars());
                    break;
                case countNumberOfWords:
                    System.out.println(countWords());
                    break;
                case countNumberOfPunctuationMarks:
                    System.out.println(countPuncMarks());
                    break;
                case countNumberOfPhrases:
                    System.out.println(countChar());
                    break;
                case generateLettersRaport:
                    generateLettersRaport();
                    break;
                case saveStats:
                    //zad 7 TODO 7. [Student C] Zapisać plik ze statystykami.
                    //Te same informacje, które są wypisywane na ekran w punktach 2-5,
                    //zapisać do pliku statystyki.txt. Jeśli plik już istnieje - nadpisać.
                case exit:
                    deleteFile("plik.txt");
                    deleteFile("statystyki.txt");
                    System.out.println("You've deleted the file");
                    break;
                default:
                    System.out.println("Pick upper options");
            }
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file == null) {
            throw new NullPointerException("File not exist");
        }
        file.delete();
    }
}