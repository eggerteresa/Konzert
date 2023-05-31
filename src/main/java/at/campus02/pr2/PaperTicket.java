package at.campus02.pr2;

public class PaperTicket implements NFCTicket {

    protected String ownerName;
    protected double ticketPrice;
    protected double discount;
    protected boolean winner;
    protected String secret;

    //+ Sicherheitscode im Konstruktor


    public PaperTicket(String ownerName, double ticketPrice, double discount, boolean winner) {
        this.ownerName = ownerName;
        this.ticketPrice = ticketPrice;
        this.discount = discount;
        this.winner = winner;
        this.secret = TicketFraudSystem.createNewTicket("paper");


    }

    @Override
    public String getTicketOwner() {

        return this.ownerName;
    }

    @Override
    public double getProfit() {
        double profit = 0;

        profit = (ticketPrice - 20) /100 * (100-discount);

        return profit;
    }

    @Override
    public int getCategory() {
        int ticketCategory;

        if (ticketPrice >= 80){
            ticketCategory = 2;
        }
        else {ticketCategory = 3;}

        if (winner == true){
            ticketCategory= ticketCategory-1;
        }


        return ticketCategory;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    @Override
    public String toString() {
        return "PaperTicket, Kategorie: " + getCategory() + ", Sicherheitscode: " + getSecret()+ '\n';
    }
}
