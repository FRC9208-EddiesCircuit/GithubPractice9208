import java.util.Scanner;

public class Project4
{
    public static void main(String[] args)
    {
        int max = 9;
        for (int i = max; i >= 0; i--)
        {
            for (int j = i; j >= 0; j--)
            {
                System.out.print(j + " ");
            }
            for (int j = (max - i); j > 0; j--)
            {
                System.out.print("    ");
            }
            for (int j = 0; j <= i; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = 0; i <= max; i++)
        {
            for (int j = i; j >= 0; j--)
            {
                System.out.print(j + " ");
            }
            for (int j = (max - i); j > 0; j--)
            {
                System.out.print("    ");
            }
            for (int j = 0; j <= i; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
