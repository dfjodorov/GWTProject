package com.github.date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class DateDTO implements IsSerializable {
    private String inputData;
    private String dataFormat;
    private String result;

    public DateDTO() {
        this.inputData = "";
        this.dataFormat = "";
        this.result = "";
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
