package com.github.server;

import com.github.client.DateCheckingService;
import com.github.date.DateDTO;
import com.github.date.DateFormats;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DateCheckingServiceImpl extends RemoteServiceServlet implements DateCheckingService {

    public DateDTO checkDate(DateDTO dateDTO){
        String inputData = dateDTO.getInputData();
        String dataFormat = dateDTO.getDataFormat();

        try {
            new SimpleDateFormat(dataFormat, Locale.ENGLISH).parse(inputData);
            dateDTO.setResult("Your date is correct.");
        } catch (ParseException e) {
            dateDTO.setResult("Your date is invalid.");
        }

        return dateDTO;
    }

    public List getDateFormats() {
        return new DateFormats().getAllAvailableFormats();
    }
}
