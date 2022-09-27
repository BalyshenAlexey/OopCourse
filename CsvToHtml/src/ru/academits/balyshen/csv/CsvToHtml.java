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

    public static boolean isPathToCsv(String path) {
        return path.contains(".csv");
    }

    public static boolean isPathToHtml(String path) {
        return path.contains(".html");
    }

    public static void main(String[] args) {
        if (args.length <= 1 || !isPathToCsv(args[0]) || !isPathToHtml(args[1])) {
            System.out.println("Ошибка! Некорректные аргументы. Введите 2 аргумета:");
            System.out.println("аргумент 1 - путь к файлу формата СSV;");
            System.out.println("аргумент 2 - путь к файлу формата HTML.");
        } else {
            String inputFilePath = args[0];
            String outputFilePath = args[1];

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath));
                 PrintWriter writer = new PrintWriter(outputFilePath)) {
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<style>table, th, td {border:1px solid black;}</style>");
                writer.println("<head>");
                writer.println("<meta charset=\"utf-8\">");
                writer.println("<title>Перевод из формата CSV в HTML</title>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<table>");
                writer.println("<tr>");
                writer.print("<td>");

                int c;
                boolean isInQuotes = false;
                boolean isNextEmptyLine = true;

                while ((c = bufferedReader.read()) != -1) {
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
                        writer.print("<td>");
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
                            writer.println("</tr>");
                            writer.println("<tr>");
                            writer.print("<td>");

                            isNextEmptyLine = true;
                        } else {
                            writer.print("<br/>");
                        }
                        continue;
                    }

                    isNextEmptyLine = false;

                    writer.print(replaceSpecialCharacter(symbol));
                }

                writer.println("</td>");
                writer.println("</tr>");
                writer.println("</table>");
                writer.println("</body>");
                writer.println("</html>");
            } catch (IOException e) {
                System.out.println("Ошибка! Файлы отсутствуют");
            }
        }
    }
}
