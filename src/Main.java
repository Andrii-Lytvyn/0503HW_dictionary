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
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Map<String, String> dictionary = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      int space = line.indexOf(':');
      String term = line.substring(0, space);
      String meaning = line.substring(space+2);
      dictionary.put(term, meaning);
    }

    for (Map.Entry<String, String> entry : dictionary.entrySet()) {
      //System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
      System.out.println( entry.getKey());
      System.out.println(entry.getValue());
    }
  }
  // dictionary.values().forEach(System.out::println);

}
