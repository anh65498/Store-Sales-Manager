/*
Anh Pham
CIS D035A 61Y
Assignment #3
Due date: 		Thursday, Nov 1, 2018
Submit date: 	Thursday, Nov 1, 2018
*/

public class Franchise {
	private Store stores[]; // Franchise contain array of stores

	public Franchise() {
	}

	public Franchise(int num) { // constructor: create an array of stores
		stores = new Store[num];
	}

	public Store getStores(int i) {
		return stores[i];
	}

	public void setStores(Store stores, int i) {
		this.stores[i] = stores;
	}

	public int numberofstores() {
		return stores.length;
	}

	// Why do all the calculation before interacting with user? Easy for
	// maintenance. In case we replace UI with other platform then we don't have to
	// rewrite calculation for new UI.
	public void doCalculation() {

		for (int storeIndex = 0; storeIndex < numberofstores(); storeIndex++) {
			getStores(storeIndex).analyzeResult();

		}
	}

}
