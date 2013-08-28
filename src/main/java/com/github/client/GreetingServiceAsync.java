package com.github.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {

    void greetServer(String name, AsyncCallback<String> async);

}
