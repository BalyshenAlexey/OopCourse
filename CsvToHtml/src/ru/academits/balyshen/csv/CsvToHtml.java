package ru.academits.balyshen.csv;

import java.io.*;

public class CsvToHtml {
    public static String replaceSpecialCharacter(char c) {
        return switch (c) {
            case '&' -> "&amp;";
            case '<' -> "&lt;";
            case '>' -> "&gt;";
            default -> String.valueOf(c);
        };
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ошибка! Некорректные аргументы. Введите 2 аргумента:");
            System.out.println("аргумент 1 - путь к файлу формата СSV;");
            System.out.println("аргумент 2 - путь к файлу формата HTML.");

            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(outputFilePath)) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("\t<style>table, th, td {border:1px solid black;}</style>");
            writer.println("\t<meta charset=\"utf-8\">");
            writer.println("\t<title>Перевод из формата CSV в HTML</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table>");

            int c;
            boolean isInQuotes = false;
            boolean isNextEmptyLine = true;
            boolean isNewLine = true;

            while ((c = bufferedReader.read()) != -1) {
                if (isNewLine) {
                    writer.println("\t<tr>");
                    writer.print("\t\t<td>");
                }

                isNewLine = false;

                char symbol = (char) c;

                if (symbol == '"') {
                    if (!isInQuotes) {
                        isInQuotes = true;
                        continue;
                    }

                    if ((c = bufferedReader.read()) == -1) {
                        break;
                    }

                    symbol = (char) c;

                    if (symbol != '"') {
                        isInQuotes = false;
                    }
                }

                if (symbol == ',' && !isInQuotes) {
                    writer.println("</td>");
                    writer.print("\t\t<td>");

                    isNextEmptyLine = false;

                    continue;
                }

                if (symbol == '\r') {
                    continue;
                }

                if (symbol == '\n') {
                    if (!isInQuotes) {
                        if (isNextEmptyLine) {
                            continue;
                        }

                        writer.println("</td>");
                        writer.println("\t</tr>");

                        isNewLine = true;
                        isNextEmptyLine = true;
                    } else {
                        writer.print("<br/>");
                    }

                    continue;
                }

                writer.print(replaceSpecialCharacter(symbol));
            }

            if (!isNewLine) {
                writer.println("</td>");
                writer.println("\t</tr>");
            }

            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Исходный файл с данными отсутствует");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода!");
            e.printStackTrace();
        }
    }
}
