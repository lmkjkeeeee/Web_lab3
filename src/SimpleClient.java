import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Підключено до сервера.");

            // Відправляємо масив чисел
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Масив чисел для відправки
            String numbers = "10,20,30, 40"; 
            out.println(numbers);

            // Отримуємо відповідь від сервера
            String response = in.readLine();
            System.out.println("Сума чисел: " + response);
        } catch (IOException e) {
            System.err.println("Помилка клієнта: " + e.getMessage());
        }
    }
}
