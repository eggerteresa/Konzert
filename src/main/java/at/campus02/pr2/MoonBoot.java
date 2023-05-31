package at.campus02.pr2;

public class MoonBoot implements NFCTicket {
    protected String ownerName;
    protected boolean bootsColor;
    protected String secret;

    public MoonBoot(String ownerName, boolean bootsColor) {
        this.ownerName = ownerName;
        this.bootsColor = bootsColor;
        this.secret = TicketFraudSystem.createNewTicket("moonboot");
    }

    @Override
    public String getTicketOwner() {
        return this.ownerName;
    }

    @Override
    public double getProfit() {
        double profit = 0;
        if (bootsColor==true){
            profit = 250;
        }
        if (bootsColor==false){
            profit=200;
        }
        return profit;
    }

    @Override
    public int getCategory() {
        int ticketCategory;
        if (bootsColor==true){
            ticketCategory=1;
        }
        else {ticketCategory=2;}

        return ticketCategory;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    @Override
    public String toString() {
        return "Moonboot, Kategorie: " + getCategory() + ", Sicherheitscode: " + getSecret()+ '\n';
    }


}
