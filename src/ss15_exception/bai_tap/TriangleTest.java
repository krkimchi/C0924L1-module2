package ss15_exception.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            double side1 = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ hai: ");
            double side2 = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ ba: ");
            double side3 = scanner.nextDouble();

            checkTriangle(side1, side2, side3);

            System.out.println("Tam giác hợp lệ với các cạnh: " + side1 + ", " + side2 + ", " + side3);
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số thực.");
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void checkTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác không thể là số âm hoặc bằng 0.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
