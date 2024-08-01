package org.student.backend.pojo.enumeration;

/**
 * @author Student
 */
public enum ORDER_STATUS {
    NEW(0, "New"),
    IN_PROGRESS(1, "In progress"),
    SHIPPED(2, "Shipped"),
    DELIVERED(3, "Delivered"),
    CANCELED(4, "Canceled");

    ORDER_STATUS(int i, String canceled) {

    }
}
