package com.github.client;

import com.github.date.DateDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface DateCheckingServiceAsync {

    void checkDate(DateDTO aBunchOfDates, AsyncCallback<DateDTO> async);

    void getDateFormats(AsyncCallback<List> async);
}
