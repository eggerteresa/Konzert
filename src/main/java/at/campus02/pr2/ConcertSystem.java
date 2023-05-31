package at.campus02.pr2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class ConcertSystem  {

    ArrayList<NFCTicket> ticketliste;

    public ConcertSystem() {
        this.ticketliste = new ArrayList<>();
    }

    public boolean addTicket(NFCTicket ticket) { //muss man upcasten zum interface siehe häschenbespiel
        boolean ticketAdded;
        if (!ticketliste.contains(ticket) && (TicketFraudSystem.checkTicket(ticket) == true)) {
            ticketliste.add(ticket);
            ticketAdded = true;
        } else {
            ticketAdded = false;
        }
        return ticketAdded;
    }

    public double profitPerCategory(int category) {
        double profitPerCatogory = 0;
        int ticketcount = 0;

        for (NFCTicket ticket : ticketliste) {
            if (ticket.getCategory() == category) {
                profitPerCatogory = profitPerCatogory + ticket.getProfit();
                ticketcount = ticketcount + 1;
            }
        }
        profitPerCatogory = profitPerCatogory / ticketcount;
        return profitPerCatogory;

    }


    public ArrayList<String> invitedToStage() {
        ArrayList<String> ergebnis = new ArrayList<>();

        for (NFCTicket ticket : ticketliste) {
            String secret = ticket.getSecret();
            //secret = secret.toUpperCase();

            if (secret.startsWith("M") == true) {
                ergebnis.add(ticket.getTicketOwner());

            }
            if (secret.startsWith("A") == true && ticket.getCategory() == 1) {
                ergebnis.add(ticket.getTicketOwner());

            }
        }
        return ergebnis;

    }


    public HashMap<Integer, Double> donationPerCategory() {

        HashMap<Integer, Double> ergebnis = new HashMap<>();

        int categoryKEY = 0;
        double donationsVALUE = 0;
        double sum = 0;

        ergebnis.put(1, donationsVALUE);
        ergebnis.put(2, donationsVALUE);
        ergebnis.put(3, donationsVALUE);






        for (NFCTicket ticket : ticketliste) {
            if (ticket.getCategory() == 1) {
                categoryKEY = 1;

                donationsVALUE = ticket.getProfit() / 100 * 30;
                ergebnis.put(categoryKEY, ergebnis.get(categoryKEY) + donationsVALUE);
            }
            if (ticket.getCategory() == 2) {
                categoryKEY = 2;


                donationsVALUE = ticket.getProfit() / 100 * 20;
                ergebnis.put(categoryKEY, ergebnis.get(categoryKEY) + donationsVALUE);
            }
            if (ticket.getCategory() == 3) {
                categoryKEY = 3;


                donationsVALUE =ticket.getProfit() / 100 * 10;
                ergebnis.put(categoryKEY, ergebnis.get(categoryKEY) + donationsVALUE);
            }

        }


        return ergebnis;
    }

    public void sortAndPrintForAccounting() {
        Collections.sort(ticketliste, new AccountingComparator());
        System.out.println(ticketliste);

    }



}
