package com.github.client;

import com.github.date.DateDTO;
import com.github.date.DateFormats;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class GwtNewScreen implements EntryPoint {

    private final DateCheckingServiceAsync dateCheckingService = GWT.create(DateCheckingService.class);

    private ListBox formatList;
    private TextBox dateInputBox;
    private Button checkIfDateIsValidButton;
    private Label outputLabel;
    private DateFormats allAvailableFormats;

    public void onModuleLoad() {

        allAvailableFormats = new DateFormats();
        outputLabel = new Label("");
        formatList = new ListBox();
        dateInputBox = new TextBox();
        checkIfDateIsValidButton = new Button("Push ME!");

        for (String format : allAvailableFormats.getAllAvailableFormats()) {
             formatList.addItem(format);
        }


        RootPanel.get("dateFormatListBox").add(formatList);
        RootPanel.get("dateInputTextBox").add(dateInputBox);
        RootPanel.get("checkIfValidDateButton").add(checkIfDateIsValidButton);
        RootPanel.get("outputLabel").add(outputLabel);

        ClickHandler sendToServerHandler = new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {

                outputLabel.setText("");

                int selectedIndexFromFormatList = formatList.getSelectedIndex();
                DateDTO dateDTO = new DateDTO();

                dateDTO.setInputData(dateInputBox.getText());
                dateDTO.setDataFormat(formatList.getItemText(selectedIndexFromFormatList));

                dateCheckingService.checkDate(dateDTO , new AsyncCallback<DateDTO>(){

                    public void onFailure(Throwable throwable) {
                       //TODO: global error Message
                    }

                    public void onSuccess(DateDTO dataDTO) {
                       outputLabel.setText(dataDTO.getResult());
                    }
                });
            }
        };

        checkIfDateIsValidButton.addClickHandler(sendToServerHandler);

    }
}
