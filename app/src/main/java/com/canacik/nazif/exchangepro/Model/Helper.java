package com.canacik.nazif.exchangepro.Model;

import java.util.List;

/**
 * Created by Nazif ÇANACIK on 2.12.2016.
 */

public final class Helper {
    private static int  UserId;
    private static operation  Data;
    private static List<operation> DataList;
    public static int getUserId() {
        return UserId;
    }

    public static void setUserId(int userId) {
        UserId = userId;
    }

    public static operation GetData() {
        return Data;
    }

    public static void SetData(operation data) {Data=data; }

    public static List<operation> getDataList() {
        return DataList;
    }

    public static void setDataList(List<operation> dataList) {
        DataList = dataList;
    }
}
