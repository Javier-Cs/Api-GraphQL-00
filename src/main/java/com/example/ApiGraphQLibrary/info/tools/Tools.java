package com.example.ApiGraphQLibrary.info.tools;

import java.time.LocalDate;

public final class Tools {

    public static LocalDate converStr_Date (String date){
        return LocalDate.parse(date);
    }
}
