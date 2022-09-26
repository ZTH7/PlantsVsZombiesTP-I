package tp1.p1.control;
import tp1.p1.logic.Game;
import tp1.p1.view.Messages; 

public class Command {
	
	Game game;
	public Command();
	
	

	public void input(String[] input)
	{
		if(input[0].equalsIgnoreCase("a") || input[0].equalsIgnoreCase("add"))
		{
			if(input.length != 4)
			{
				System.out.printf(Messages.ERROR,"Missing parameters");
				return;
			}
			String name = input[1];
			int Col = Integer.parseInt(input[2]);
			int Rol = Integer.parseInt(input[3]);
			add(name,Col,Rol);
		}
		else if(input[0].equalsIgnoreCase("l") || input[0].equalsIgnoreCase("help"))
		{
			list();
		}
		else if(input[0].equalsIgnoreCase("r") || input[0].equalsIgnoreCase("reset"))
		{
			reset();
		}
		else if(input[0].equalsIgnoreCase("h") || input[0].equalsIgnoreCase("help"))
		{
			help();		
		}
		else if(input[0].equalsIgnoreCase("e") || input[0].equalsIgnoreCase("exit"))
		{
			exit();
		}
		else
		{
			none();
		}
	}
	
	public  void add(String name, int Col , int rol)
	{
		
	}
	
	public  void list()
	{
		System.out.println(Messages.LIST);
	}
	
	public  void reset()
	{
		
	}
	public  void help()
	{
		for(String str: Messages.HELP_LINES) {
			System.out.println(str);
		}
		
	}
	public void exit()
	{
		System.exit(0);
	}
	
	public void none()
	{
		game.update();
	}
}
