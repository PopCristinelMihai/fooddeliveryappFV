package com.example.fooddelivery.Common;

import com.example.fooddelivery.Model.User;

import org.jetbrains.annotations.NotNull;

public class Common {
    public static User currentUser;
    public static String convertCodeToStatus(@NotNull String status) {
        if (status.equals("0"))
            return "Placed";
        else if (status.equals("1"))
            return "Delivering";
        else
            return "Delivered";
    }
}

