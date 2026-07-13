package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;

public interface State{

    void selectProduct(String slot);

    void insertCoin(Coin coin);

    void cancel();

    void dispense();

}
