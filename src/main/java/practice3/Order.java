package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    private BigDecimal subTotal = new BigDecimal(0);

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = new BigDecimal(0.1);
    }

    public BigDecimal calculate() {

        TotalUpLineItems();
        SubtractDiscount();
        calculateTax();
        return subTotal ;
//        BigDecimal subTotal = new BigDecimal(0);
//
//        // Total up line items
//        for (OrderLineItem lineItem : orderLineItemList) {
//            subTotal = subTotal.add(lineItem.getPrice());
//        }
//
//        // Subtract discounts
//        for (BigDecimal discount : discounts) {
//            subTotal = subTotal.subtract(discount);
//        }
//
//        // calculate tax
//        BigDecimal tax = subTotal.multiply(this.tax);
//
//        // calculate GrandTotal
//        BigDecimal grandTotal = subTotal.add(tax);
//
//        return grandTotal;
    }

    private void TotalUpLineItems() {
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }

    private void SubtractDiscount() {
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }
    private void calculateTax() {
        BigDecimal totalTax = subTotal.multiply(this.tax);
        subTotal= subTotal.add(totalTax);
    }
}
