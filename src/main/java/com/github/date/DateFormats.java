package com.github.date;

import java.util.ArrayList;
import java.util.List;

public class DateFormats  {
    private List<String> allAvailableFormats = new ArrayList<String>();

    public DateFormats() {
        allAvailableFormats.add("dd.mm.yy");
        allAvailableFormats.add("dd.mm.yyyy");
        allAvailableFormats.add("dd/mm/yy");
        allAvailableFormats.add("dd/mm/yyyy");
    }

    public List<String> getAllAvailableFormats() {
        return allAvailableFormats;
    }
}
