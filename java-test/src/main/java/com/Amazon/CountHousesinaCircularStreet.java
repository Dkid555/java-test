package com.Amazon;

public class CountHousesinaCircularStreet {
      private  static class Street {
          public Street(int[] doors) {

          }

          public void openDoor() {

          }

          public void closeDoor() {

          }

          public boolean isDoorOpen() {
              return false;
          }

          public void moveRight() {

          }

          public void moveLeft() {

          }
      }
    public int houseCount(Street street, int k) {
        while (k-- > 0) {
            street.openDoor();
            street.moveLeft();
        }
        int ans = 0;
        while (street.isDoorOpen()) {
            ++ans;
            street.closeDoor();
            street.moveLeft();
        }
        return ans;
    }
}
//You are given an object street of
// class Street that represents a circular
// street and a positive integer k which represents
// a maximum bound for the number of houses in that street
// (in other words, the number of houses is less than or equal to k). Houses' doors could be open or closed initially.
//
//Initially, you are standing in front of a door to a house on this street.
// Your task is to count the number of houses in the street.