package game_fox_adventure;

public class ChooseSecondCommand implements Command{
    private Menu menu;

    public ChooseSecondCommand(Menu menu){
        this.menu = menu;
    }

    public void execute(){
        menu.slideSecond();
    }
}