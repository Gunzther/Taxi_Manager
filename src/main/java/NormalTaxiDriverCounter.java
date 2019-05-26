public class NormalTaxiDriverCounter extends TaxiDriverCounter{

    private int index;

    @Override
    public boolean hasNext() {
        return index < taxiDriverList.size();
    }

    @Override
    public TaxiDriver next() {
        return taxiDriverList.get(index++);
    }


}
