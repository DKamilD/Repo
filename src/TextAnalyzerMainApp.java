import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TextAnalyzerMainApp {
    private static void downloadFile() throws MalformedURLException {

        URL website = new URL("https://s3.zylowski.net/public/input/7.txt");
        try (InputStream in = website.openStream()) {
            Files.copy(in, Path.of("D:\\Users\\oem\\ProjektZGita\\plik.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws MalformedURLException {
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
        /*
        Pobieranie pliku z internetu.
         */
        downloadFile();
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
                    //Zad 1 TODO:[Student B] Pobieranie pliku z internetu
                    //Każda grupa otrzyma adres pliku tekstowego. Adres ten ma zostać
                    //‘zahardkodowany’ w aplikacji i aplikacja ma pobierać ten plik przy

                    break;
                case countNumberOfLetters:
                    //Zad 2 TODO:[Student A] Liczba liter
                    //Wypisać na ekran ile liter znajduje się w pobranym pliku. Jeśli plik nie
                    //został pobrany, zwrócić błąd.
                    break;
                case countNumberOfWords:
                    //zad 3 TODO 3. [Student B] Liczba wyrazów
                    //Wypisać na ekran ile wyrazów znajduje się w pobranym pliku. Jeśli plik
                    //nie został pobrany, zwrócić błąd.
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
                    //zad 6 TODO 6. [Student A] Wygeneruj raport o ilości poszczególnych liter w
                    //pliku
                    //Wypisać na ekran listę:
                    //A: 13
                    //B: 124
                    //C: ..
                    break;
                case saveStats:
                    //zad 7 TODO 7. [Student C] Zapisać plik ze statystykami.
                    //Te same informacje, które są wypisywane na ekran w punktach 2-5,
                    //zapisać do pliku statystyki.txt. Jeśli plik już istnieje - nadpisać.
                case exit:
                    //zad 8 TODO [Student B] Wyjście
                    //Zakończyć program, usunąć plik tekstowy z punktu 1. (o ile był zapisany)
                    //i usunąć plik statystyki.txt (o ile był zapisany).


            }
        }
    }
}