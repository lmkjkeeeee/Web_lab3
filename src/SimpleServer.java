import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Сервер запущено, очікую підключення клієнту...");

            while (true) {
                // Приймаємо підключення клієнта
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клієнт підключився.");

                // Читаємо дані від клієнта
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Отримуємо масив чисел
                String input = in.readLine(); // Читаємо рядок
                String[] numbersStr = input.split(",");
                int sum = 0;

                // Обчислюємо суму
                for (String num : numbersStr) {
                    sum += Integer.parseInt(num.trim());
                }

                // Відправляємо результат клієнту
                out.println(sum);
                System.out.println("Оброблено запит, сума: " + sum);

                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Помилка сервера: " + e.getMessage());
        }
    }
}
