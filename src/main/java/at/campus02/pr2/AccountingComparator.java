package at.campus02.pr2;

import java.util.Comparator;

public class AccountingComparator implements Comparator<NFCTicket> {


    @Override
    public int compare(NFCTicket o1, NFCTicket o2) {
        int erg = Integer.compare(o1.getCategory(), (o2.getCategory()) );
        if (erg == 0) {
            erg = o1.getSecret().compareTo(o2.getSecret()) ;

        } return erg;


    }
}

