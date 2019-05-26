public class ReverseTaxiDriverCounter extends TaxiDriverCounter{

    private int index;

    @Override
    public boolean hasNext() {
        return index < taxiDriverList.size();
    }

    @Override
    public TaxiDriver next() {
        index++;
        return taxiDriverList.get(taxiDriverList.size() - index);
    }


}
