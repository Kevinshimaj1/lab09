package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> historyStrings = new LinkedList<>();


    @Override
    public void setNextString(final String nexString) {
        this.nextString = Objects.requireNonNull(nexString, "Null values are not accetable");
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedStrings() {
        return new LinkedList<>(historyStrings); 
    }

    @Override
    public void printCurrentString() {
        if(this.nextString.isBlank()){
            throw new IllegalStateException("The string must not be unset");
        }
        this.historyStrings.add(this.nextString);
        System.out.println(this.nextString);
    }
    
}
