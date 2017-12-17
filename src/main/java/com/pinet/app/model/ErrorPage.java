package com.pinet.app.model;

public class ErrorPage {
    private String errorMessage;
    private String suggestionMessage;

    public ErrorPage(String errorMessage, String suggestionMessage) {
        this.errorMessage = errorMessage;
        this.suggestionMessage = suggestionMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuggestionMessage() {
        return suggestionMessage;
    }

    public void setSuggestionMessage(String suggestionMessage) {
        this.suggestionMessage = suggestionMessage;
    }
}
