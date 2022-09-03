package ru.academits.balyshen.csv;

import java.io.*;

public class CsvToHtml {
    public static String replaceSpecialCharacters(char c) {
        switch (c) {
            case '&' -> {
                return "&amp;";
            }
            case '<' -> {
                return "&lt;";
            }
            case '>' -> {
                return "&gt;";
            }
            default -> {
                return String.valueOf(c);
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            PrintWriter writer = new PrintWriter(args[1]);

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

            while ((c = br.read()) != -1) {
                char symbol = (char) c;

                if (symbol == '"') {
                    if (!isInQuotes) {
                        isInQuotes = true;
                        continue;
                    } else {
                        symbol = (char) br.read();

                        if (symbol != '"') {
                            isInQuotes = false;
                        }
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
                        writer.println("</td>");
                        writer.println("</tr>");
                        writer.println("<tr>");
                        writer.print("<td>");
                    } else {
                        writer.print("<br/>");
                    }
                    continue;
                }

                writer.print(replaceSpecialCharacters(symbol));
            }

            writer.println("</td>");
            writer.println("</tr>");
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка! Файл отсутствует");
        }
    }
}
