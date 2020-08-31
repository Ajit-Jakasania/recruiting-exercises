package com.work;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/*
 * 	Order class 
 *  Example:	{ apple: 5, banana: 5, orange: 5 }
 * 	@author Ajit Jakasania
 *  @date   6/24/2020
 */

public class Order {
    Map<String, Integer> order;

    /*
     * Creates new empty order
     */
    public Order() {
        this.order = new HashMap<>();
    }

    /*
     * Creates new order with required HashMap
     *
     * @param order
     */
    public Order(Map<String, Integer> order) {
        this.order = new HashMap<>();
        for(String key : order.keySet()) {
            int val = order.get(key);
            this.order.put(key, val);
        }
    }
    
    /*
     * Get items from set
     */
    public Set<String> getItems() {
        return this.order.keySet();
    }

    /*
     * Get quantity of the item
     */
    public int getQuantity(String item) {
        return this.order.get(item);
    }

    /*
     * Add product quantity to order
     * @param productName
     * @param quantity
     */
    public void addToOrder(String productName, int quantity) {
        this.order.put(productName, this.order.getOrDefault(productName, 0) + quantity);
    }

    /*
     * Updates product quantity to order
     * @param productName
     * @param newAmount
     */
    public void updateOrder(String productName, int newAmount) {
        this.order.put(productName, newAmount);
    }

    /*
     * Set the new order
     * @param newOrder
     */
    public void setOrder(Map<String, Integer> newOrder) {
        this.order = newOrder;
    }

    /*
     * @returns if an order is completely allocated, meaning all the remaining quantities are 0
     */
    public boolean isOrderAllocated() {
        for(String s :this.order.keySet()) {
            if(this.order.get(s) != 0) {
                return false;
            }
        }
        return true;
    }
}
