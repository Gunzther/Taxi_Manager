import java.util.Iterator;
import java.util.List;

public abstract class TaxiDriverCounter implements Iterator<TaxiDriver>{

    protected List<TaxiDriver> taxiDriverList;

    public void setTaxiDriverList(List<TaxiDriver> list) {
        this.taxiDriverList = list;
    }

}
