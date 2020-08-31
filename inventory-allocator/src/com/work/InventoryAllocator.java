package com.work;
import java.util.List;
import java.util.ArrayList;

/*
 * The InventoryAllocator class calculates the optimal way to produce  the cheapest shipment from a given inventory across a set of warehouses.
 * 
 * @author Ajit Jakasania
 *  @date   6/25/2020
 */

public class InventoryAllocator {
	
	/*
    *
    * @param order
    * @return list of most cost effective shipments fulfill order, [] if not enough inventory
    */
    public List<Shipment> allocateShipments(Order order, List<Warehouse> inventoryDistribution) {
        List<Shipment> ticket = new ArrayList<>();
        for(Warehouse w : inventoryDistribution) {
            Shipment ship = (w != null) ? w.processOrder(order) : null;
            if(ship != null) {
                // If this Warehouse has anything to ship, add it to the ticket
                ticket.add(ship);
            }
        }
        // If this order is completely allocated, return the ticket. otherwise, return an empty ArrayList
        return (order != null && order.isOrderAllocated()) ? ticket :  new ArrayList<>();
    }
}
