package com.work;
import java.util.Map;
import java.util.HashMap;


/*
 * 	Warehouse class, an instance of one warehouse and its inventory
 * 	Example: {name: owd, inventory: {apples: 5, oranges: 2}}
 * 	@author Ajit Jakasania
 *  @date   6/25/2020
 */

public class Warehouse {
    private String name;
    private Map<String, Integer> inventory;

    /*
     * Creates a Warehouse with a given name and an empty inventory
     * @param name
     */
    public Warehouse(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
    }

    /*
     * Creates a warehouse with a given name and inventory
     * @param name
     * @param inventory
     */
    public Warehouse(String name, Map<String, Integer> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    /*
     * Get name of the warehouse
     * @return name of the warehouse
     */
    public String getName() {
        return this.name;
    }

    /*
     * Set new name of the warehouse
     * @param newName name to set
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /*
     * Get inventory of the warehouse
     * @return inventory of the warehouse
     */
    public Map<String, Integer> getInventory() {
        return this.inventory;
    }

    /*
     * Add product quantity to inventory in the warehouse
     * @param productName
     * @param quantity
     */
    public void addToInventory(String productName, int quantity) {
        this.inventory.put(productName, this.inventory.getOrDefault(productName, 0) + quantity);
    }

    /*
     * Processing order from the warehouse
     * @param order
     */
    public Shipment processOrder(Order order) {
        Map<String, Integer> itemsToShip = new HashMap<>();
        Order orderTracker = new Order(order.order);
        for(String item: order.getItems()) {
            // If the order quantity is 0 or if the inventory does not have any of that item, go to next item.
            if(order.getQuantity(item) <= 0 || this.inventory.getOrDefault(item, 0) <= 0) {
                continue;
            }
            // Update items to ship with either the whole order, or however much the inventory has left (if the whole order cannot be completed)
            itemsToShip.put(item, Math.min(order.getQuantity(item), this.inventory.get(item)));
            // Update the order tracker with either the leftover amount this order needs, or 0 if the order was completed
            orderTracker.updateOrder(item, Math.max(order.getQuantity(item) - this.inventory.get(item), 0));
        }

        if(itemsToShip.isEmpty()) {
            // If there are no items to ship from this warehouse, return null
            return null;
        }
        else {
            // Update the order to reflect the items shipped
            order.setOrder(orderTracker.order);
            // Create a new shipment object for this warehouse with the appropriate items to ship
            return new Shipment(this.name, itemsToShip);
        }
    }
}

