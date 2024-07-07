package com.javatest.leetcode;

public class AirportPickup {

    public static void main(String[] args) {
        String[] PickUp = new String[]{
                "p_order1,1,2022-02-11 12:20:00,airport1",
                "p_order2,2,2022-02-11 14:30:00,airport1",
                "p_order3,2,2022-02-12 12:45:00,airport2",
                "p_order4,2,2022-02-12 12:15:00,airport2",
                "p_order5,2,2022-02-12 19:20:00,airport2",
                "p_order6,2,2022-02-12 20:30:00,airport2",
                "p_order7,2,2022-02-12 20:00:00,airport2"};
        String[] SendOrder = new String[]{
                "s_order1,1,2022-02-11 12:00:00,airport1",
                "s_order2,1,2022-02-11 12:30:00,airport1",
                "s_order3,1,2022-02-11 12:10:00,airport1",
                "s_order4,2,2022-02-12 12:30:00,airport2",
                "s_order5,2,2022-02-12 18:27:00,airport2",
                "s_order6,1,2022-02-12 19:30:00,airport2",
                "s_order7,2,2022-02-12 20:15:00,airport2"};
    }
}

class Airport {
    String type;

}
