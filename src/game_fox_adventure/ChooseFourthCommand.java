package game_fox_adventure;

public class ChooseFourthCommand implements Command{
            private Menu menu;

            public ChooseFourthCommand(Menu menu){
                this.menu = menu;
            }
       public void execute(){
                menu.slideFourth();
       }
}