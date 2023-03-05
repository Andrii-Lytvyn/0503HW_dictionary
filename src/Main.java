/*
создание небольшого словаря сленговых программерских выражений,
чтобы она потом по запросу возвращала значения из этого словаря.

Формат входных данных
Файл dict.txt
В первой строке задано одно целое число n — количество слов в словаре.
В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.

Ввод с клавиатуры
В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
В следующих m строках записаны сами слова, по одному на строке.

Формат выходных данных
Для каждого слова, независимо от регистра символов, если оно присутствует в словаре, необходимо
вывести на экран его определение. Если слова в словаре нет, программа должна вывести "Не
найдено", без кавычек.

Вводные данные
5
Змея: язык программирования Python
Баг: от англ. bug — жучок, клоп, ошибка в программе
Конфа: конференция
Костыль: код, который нужен, чтобы исправить несовершенство ранее написанного кода
Бета: бета-версия, приложение на стадии публичного тестирования
3
Змея
Жаба
костыль

Пример выходных данных
язык программирования Python
Не найдено
код, который нужен, чтобы исправить несовершенство ранее написанного кода

Дебажить
Выпадашка
git
аутсорс
Бот

 */

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Map<String, String> dictionary = new HashMap<>();
    fillDictionary(dictionary);
    List<String> searchWords = new ArrayList<>();
    addSearchWords(searchWords);
    findPrintWords(dictionary, searchWords);
  }

  private static void findPrintWords(Map<String, String> dictionary, List<String> searchWords) {
    for (String searchWord : searchWords) {
      if (!(dictionary.get(searchWord) == null)) {
        System.out.println(dictionary.get(searchWord));
      } else {
        System.out.println("Не найдено");
      }
    }
  }

  private static void addSearchWords(List<String> searchWords) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      int m = Integer.parseInt(br.readLine());
      for (int i = 0; i < m; i++) {
        searchWords.add(br.readLine().toLowerCase());
      }
    } catch (NumberFormatException e) {
      System.err.println("Не корректный ввод");
    }
  }

  private static void fillDictionary(Map<String, String> dictionary) throws IOException {
    try {
      File inputFile = new File("Res/dict.txt");
      BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
      for (String line = fileReader.readLine(); line != null; line = fileReader.readLine()) {
        int space = line.indexOf(':');
        String term = line.substring(0, space);
        String meaning = line.substring(space + 2);
        dictionary.put(term.toLowerCase(), meaning);
      }
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
    } catch (StringIndexOutOfBoundsException m) {
      System.err.println("Ошибка форматирования файла" + m.getMessage());
    }
  }
}



