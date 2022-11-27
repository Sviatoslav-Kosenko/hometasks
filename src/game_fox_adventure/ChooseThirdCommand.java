package game_fox_adventure;

import java.awt.*;

public class ChooseThirdCommand implements Command{
    private Menu menu;

    public ChooseThirdCommand(Menu menu){
        this.menu = menu;
    }

    public void execute(){
        menu.slideThird();
    }
}