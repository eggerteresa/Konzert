package at.campus02.pr2;

import java.util.Locale;

public class AppTicket implements NFCTicket {
    
    protected String ownerName;
    protected double ticketPrice;
    protected String systemName;

    protected String secret;

    public AppTicket(String ownerName, double ticketPrice, String systemName) {
        this.ownerName = ownerName;
        this.ticketPrice = ticketPrice;
        this.systemName = systemName;
        this.secret = TicketFraudSystem.createNewTicket("app");
    }

    @Override
    public String getTicketOwner() {
        return this.ownerName;
    }

    @Override
    public double getProfit() {
        double profit = 0;
        systemName = systemName.toLowerCase();
        if (systemName.equals("ios")) {
            profit = ticketPrice/100*70;
        }
        if (systemName.equals("android")) {
            profit = ticketPrice/100*75;
        }
        else { profit = ticketPrice/100*80; }
        return profit;
    }

    @Override
    public int getCategory() {
        int ticketCategory = 3;
        if (ticketPrice >=100){
            ticketCategory = 1;
        }
        if (ticketPrice >= 50 && ticketPrice <100) {
            ticketCategory = 2;
        }
//        else {ticketCategory= 3;}

        return ticketCategory;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    @Override
    public String toString() {
        return"AppTicket, Kategorie: " + getCategory() + ", Sicherheitscode: " + getSecret()+ '\n';

    }
}
