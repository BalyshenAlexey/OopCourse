import java.io.*;
import java.util.Scanner;

public class CsvToHtml {
    private static boolean isHaveBreak(String str) {
        int length = str.length();
        boolean isHaveBreak = false;
        int quotCount = 0;

        for (int i = length - 1; i > 1; i--) {
            char c = str.charAt(i);

            if (c == '"') {
                quotCount += 1;
            }

            isHaveBreak = quotCount % 2 != 0;

            if (c == ',') {
                break;
            }
        }

        return isHaveBreak;
    }

    public static String replaceSpecialCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            switch (c) {
                case '&' -> sb.append("&amp;");
                case '<' -> sb.append("&lt;");
                case '>' -> sb.append("&gt;");
                default -> sb.append(c);
            }
        }

        return sb.toString();
    }

    private static String[] splitIntoDetails(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int quotCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {
                quotCount += 1;
            }

            if (chars[i] == ',' && quotCount % 2 == 0) {
                chars[i] = '\n';
            }

            sb.append(chars[i]);
        }

        return sb.toString().split("\n");
    }

    public static String removeQuot(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();

        if (chars[0] != '"') {
            return str;
        }

        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == '"' && chars[i + 1] == '"') {
                i++;
            }

            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static void printTable(PrintWriter writer, String[] columns) {
        writer.print("<tr>");

        for (String column : columns) {
            writer.print("<td>");
            writer.print(removeQuot(column));
            writer.print("</td>");
        }

        writer.println("</tr>");
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream("CsvToHtml\\input.txt"));
             PrintWriter writer = new PrintWriter("CsvToHtml\\output.txt")) {
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();

                if (isHaveBreak(row)) {
                    sb.append(replaceSpecialCharacters(row)).append("<br/>");
                } else {
                    sb.append(replaceSpecialCharacters(row)).append('\n');
                }
            }

            String[] rows = sb.toString().split("\n");

            writer.println("<table>");

            for (String row : rows) {
                printTable(writer, splitIntoDetails(row));
            }

            writer.print("</table>");
        }
    }
}
