package src;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class TextAnalyzerMainApp {
    private static void downloadFile() throws MalformedURLException {

        URL website = new URL("https://s3.zylowski.net/public/input/7.txt");
        try (InputStream in = website.openStream()) {
            Files.copy(in, Path.of("plik.txt"));
        } catch (IOException e) {
            e.printStackTrace();
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

    private static void generateLettersRaport() {
        final int MAX_CHAR = 256;
        String file = "plik.txt";
        String worlds = null;
        try {
            worlds = new String(Files.readAllBytes(Path.of(file)));
        } catch (IOException e) {
            throw new NullPointerException("File not found");
        }
        char[] array = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        System.out.println("Please enter a sentence to parse.");
        String userString = worlds;

        HashMap<Character, Integer> charint = new HashMap<>();

        for (Character c : userString.toCharArray()){
            if (charint.containsKey(c)) charint.replace(c, charint.get(c).intValue() + 1);
            else charint.put(c, 1);
        }

        for (int i = 0 ; i < array.length ; i++){
            System.out.println(array[i] + " : " + (charint.get(array[i]) == null ? "0" : charint.get(array[i])));
        }
    }

    public static void main(String[] args) throws IOException {
        final int downloadFile = 1;
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
            System.out.println("1 - Download file from Internet");
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
                case downloadFile:
                    downloadFile();
                    break;
                case countNumberOfLetters:
                    System.out.println(countChars());
                    break;
                case countNumberOfWords:
                    System.out.println(countWords());
                    break;
                case countNumberOfPunctuationMarks:
                    //zad 4 TODO 4. [Student C] Liczba znaków interpunkcyjnych
                    //Wypisać na ekran ile znaków interpunkcyjnych znajduje się w pobranym
                    //pliku. Jeśli plik nie został pobrany, zwrócić błąd.
                    break;
                case countNumberOfPhrases:
                    //zad 5 TODO 5. [Student C] Liczba zdań w pliku
                    //Wypisać na ekran ile zdań znajduje się w pobranym pliku. Jeśli plik nie
                    //został pobrany, zwrócić błąd.
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