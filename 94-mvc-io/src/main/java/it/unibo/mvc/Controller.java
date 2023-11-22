package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    
    void setNextString(String nexString);

    String getNextString();

    List<String> getPrintedStrings();

    void printCurrentString();

}
