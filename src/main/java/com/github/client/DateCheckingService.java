package com.github.client;

import com.github.date.DateDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("dateCheck")
public interface DateCheckingService extends RemoteService {

    DateDTO checkDate(DateDTO aBunchOfDates);
    List getDateFormats();
}
