package com.work;
import java.util.Map;
import java.util.HashMap;

/*
 * 	Shipment class from one warehouse
 * 	Example : { owd: { apple: 1 } }
 * 	@author Ajit Jakasania
 *  @date   6/25/2020
 */

public class Shipment {
    
	private String warehouseName;
    private Map<String, Integer> shipment;

    /*
     * Creates an empty shipment from a given warehouse name
     * @param warehouseName
     */
    public Shipment(String warehouseName) {
        this.warehouseName = warehouseName;
        this.shipment = new HashMap<>();
    }
    
    /*
     * Creates a shipment from a given warehouse with a given shipment amount
     * @param warehouseName
     * @param shipment
     */
    public Shipment(String warehouseName, Map<String, Integer> shipment) {
        this.warehouseName = warehouseName;
        this.shipment = shipment;
    }

    /*
     * @return warehouse name
     */
    public String getWarehouseName() {
        return this.warehouseName;
    }

    /*
     * Updates product and quantity for a shipment, add shipment to the HashMap
     * @param productName
     * @param quantity
     */
    public void addToShipment(String productName, int quantity) {
        this.shipment.put(productName, this.shipment.getOrDefault(productName, 0) + quantity);
    }

    /*
     * @return Prints and formats the shipment receipt
     */
    @Override
    public String toString() {
        String shipmentQuantities = "";
        int item = 0;
        for (String products : this.shipment.keySet()) {
            if(item != 0){
                shipmentQuantities += ", ";
            }
            shipmentQuantities = shipmentQuantities + products + ": " + this.shipment.get(products);
            item++;
        }
        return String.format("Warehouse Name ”- " + this.warehouseName + "\n Shipment ”- " + shipmentQuantities + "\n \n");
    }
}