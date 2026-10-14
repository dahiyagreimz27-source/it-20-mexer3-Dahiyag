/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication33;

/**
 *
 * @author admin
 */
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
public class JavaApplication33 {

    /**
     * @param args the command line arguments
     */
    static class Ticket {
        String name;
        int urgency;
        int arrivalOrder;

        Ticket(String name, int urgency, int arrivalOrder) {
            this.name = name;
            this.urgency = urgency;
            this.arrivalOrder = arrivalOrder;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Ticket> queue = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                .thenComparingInt(t -> t.arrivalOrder)
        );

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Input tickets
        for (int i = 0; i < n; i++) {
            System.out.println("\nTicket " + (i + 1));

            System.out.print("Enter ticket name: ");
            String name = sc.nextLine();

            System.out.print("Enter urgency (lower = higher priority): ");
            int urgency = sc.nextInt();
            sc.nextLine(); // Consume newline

            queue.offer(new Ticket(name, urgency, i));
        }

        // Display tickets in priority order
        System.out.println("\nTicket poll order:");

        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll();

            System.out.println(
                ticket.name + " (Urgency: " + ticket.urgency + ")"
            );
        }

        sc.close();
    }
}  
