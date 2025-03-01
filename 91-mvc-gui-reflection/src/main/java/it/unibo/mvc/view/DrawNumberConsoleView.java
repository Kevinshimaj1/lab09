package it.unibo.mvc.view;


import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView {

    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
        System.out.println("Starting DrawNumber..");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription()); 
    }
    
}
