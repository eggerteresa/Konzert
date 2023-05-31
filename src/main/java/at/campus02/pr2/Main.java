package at.campus02.pr2;

public class Main {

    public static void main(String[] args) {
        // ABSEITS DER ANGABE KÖNNEN SIE HIER NATÜRLICH AUCH NOCH WEITER TESTEN BZW. ERGEBNISSE AUSGEBEN

        PaperTicket p1 = new PaperTicket("Susi", 100, 10, false);
        PaperTicket p2 = new PaperTicket("Herbert", 130, 0, true);
        AppTicket a1 = new AppTicket("Caroline", 120, "ios"); //Kategorie 1 wäre Bühneneinladung
        AppTicket a2 = new AppTicket("Stefan", 120, "android");
        MoonBoot m1 = new MoonBoot("Heribert", false);
        MoonBoot m2 = new MoonBoot("Gabriele", true);

        System.out.println("Test getProfit");
        System.out.println("PaperTicket 1: " + p1.getProfit());
        System.out.println("Paper Ticket 2: " + p2.getProfit());
        System.out.println("App Ticket 1: " + a1.getProfit());
        System.out.println("App Ticket 2: " +a2.getProfit());
        System.out.println("Moonboot 1: " +m1.getProfit());
        System.out.println("Moonboot 2: " +m2.getProfit());
        System.out.println("-------------------------------------");

        System.out.println("Test getCategory");
        System.out.println("Kategorie von PaperTicket 1: " + p1.getCategory());
        System.out.println("Kategorie von PaperTicket 2: "+ p2.getCategory());
        System.out.println("Kategorie von AppTicket 1: " + a1.getCategory());
        System.out.println("Kategorie von AppTicket 2: " + a2.getCategory());
        System.out.println("Kategorie von Moonboot 1: " + m1.getCategory());
        System.out.println("Kategorie von Moonboot 2: " +m2.getCategory());
        System.out.println("-------------------------------------");

        ConcertSystem kartensystem = new ConcertSystem();

        kartensystem.addTicket(p1);
        kartensystem.addTicket(p2);
        kartensystem.addTicket(a1);
        kartensystem.addTicket(a2);
        kartensystem.addTicket(m1);
        kartensystem.addTicket(m2);

        System.out.println("Spenden pro Kategorie");
        System.out.println(kartensystem.donationPerCategory());
        System.out.println("-------------------------------------");

        System.out.println("Auf die Buehne eingeladen");
        System.out.println(kartensystem.invitedToStage());
        System.out.println("-------------------------------------");

        System.out.println("Profit per Kategorie, durchschnittlich pro Ticket");
        System.out.println("Kategorie 1: " + kartensystem.profitPerCategory(1));
        System.out.println("Kategorie 2: " + kartensystem.profitPerCategory(2));
        System.out.println("Kategorie 3: " + kartensystem.profitPerCategory(3));
        System.out.println("-------------------------------------");

        System.out.println("Sortiert nach Kategorie und Sicherheitscode; und Ausgeben:");
      kartensystem.sortAndPrintForAccounting();




    }
}

