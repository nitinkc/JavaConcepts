package nitin;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    private static final List<String> PURE_TX_ORDERS = Lists.newArrayList("CAPD_ORDER", "CCPD_ORDER", "HHD_ORDER");


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 1; i < list.size(); i = i + 2) {
            Collections.swap(list, i - 1, i);
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

//        Collections.emptyList();
//        Collections.binarySearch();
//        Collections.min();
//        Collections.max()


        String str = "Nitin";
        List<Order> activeOrders = new ArrayList<>();
        activeOrders.add(new Order(1, "OrderType", "CAPD_ORDER"));
        activeOrders.add(new Order(2, "OrderType", "HHD_ORDERw"));
        activeOrders.add(new Order(3, "OrderType", "HHD_ORDER"));
        activeOrders.add(new Order(4, "OrderType", "CCPD_ORDER"));
        activeOrders.add(new Order(5, "OrderType", "CCPD_ORDER"));

        activeOrders.stream().filter(order -> PURE_TX_ORDERS.contains(order.getOrderableItemDisplay()))
                .forEach(order -> {
                    System.out.println(order);
                });

    }
}

@AllArgsConstructor
@Data
@ToString
class Order {
    int id;
    String orderType;
    String orderableItemDisplay;
}