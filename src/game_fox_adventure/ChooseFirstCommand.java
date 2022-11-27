package game_fox_adventure;


public class ChooseFirstCommand implements Command{
    private Menu menu;

    public ChooseFirstCommand(Menu menu){
        this.menu = menu;
    }

    public void execute(){
        menu.slideFirst();
    }
}
