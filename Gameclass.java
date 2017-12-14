 import java.util.Random;
 import java.util.Scanner;
 
 //Game is Pokemon-Java version!
 public class Gameclass {
 static String u,e;               //user name and enemy name
 static int php=26,ehp,eatt;		 //player's hp and enemy's hp, attacks
 static int evolve;				 //counter for 1 time evolution.
 static Random rand=new Random();
 static Scanner m;
 public static void main(String[] args) {
 System.out.println("Player is advised to maximise the console screen");
 System.out.println("Welcome to the world of POKEMON.....");
 System.out.println("A wild Pokemon appears!");
 wildpokemonappears();
 chooseyourstarter();
 battle();
 }
 static void wildpokemonappears()
 {
 	int a=rand.nextInt(7);
 	switch(a)
 	{
 	case 0:
 		e="Pikachu";
 		System.out.println("It is a "+e+"!");
 		ehp=17;
 		eatt=4;
 		break;
 	case 1:
 		e="Meowth";
 		System.out.println("It is a "+e+"!");
 		ehp=15;
 		eatt=3;
 		break;
 	case 2:
 		e="Magikarp";
 		System.out.println("It is a "+e+"! (lol)");
 		ehp=10;
 		eatt=1;
 		break;
 	case 3:
 		e="Mewtwo";
 		System.out.println("It is the legendary "+e+"!!");
 		ehp=40;
 		eatt=9;
 		break;
 	case 4:
 		e="Magmar";
 		System.out.println("It is a "+e+"!");
 		ehp=25;
 		eatt=5;
 		break;
 	case 5:
 		e="Pidgeotto";
 		System.out.println("It is a "+e+"!");
 		ehp=25;
 		eatt=4;
 		break;
 	case 6:
 		e="Butterfree";
 		System.out.println("It is a "+e+"!");
 		ehp=28;
 		eatt=5;
 		break;
 		
 	}
 }
 static void chooseyourstarter()
 {
 	m = new Scanner(System.in);
 	int pok;				//Starter Pokemon
 	System.out.println();
 	System.out.println("Choose the pokemon you will like as starter");
 	System.out.println("1.Charmander 2.Bulbasaur 3.Squirtel");
 	System.out.println("Choose the no. beside anyone");
 	pok=m.nextInt();
 	System.out.println("You chose........ ");
 	switch(pok) 
 	{
 	case 1:
 		u="Charmander";
 		System.out.println(u);
 		break;
 	case 2:
 		u="Bulbasaur";
 		System.out.println(u);
 		break;
 	case 3:
 		u="Squirtel";
 		System.out.println(u);
 		break;
 	default:
 		System.out.println("NONE!!  You valiantly fought against a pokemon without any pokemon....But it was not a very good idea....");
 		System.out.println("YOU LOSE!");
 		System.exit(0);
 	}
 	
 }
 static void battle()
 {
 	int counter=1;
 	m=new Scanner(System.in);
 	System.out.println("Do you know the rules? (YES/NO)");
 	String rule=m.nextLine();
	if(rule.equals("NO")||rule.equals("No")||rule.equals("no"))
 	{
 		System.out.println("OK Here you go- You will fight against the wild Pokemon. For fighting you have three options");
 		System.out.println("1.Heavy Attack 2.Light Attack 3.Run 4.Try to be friendly");
 		System.out.println("Heavy attacks take 8 HP down but renders the user unable to attack for 1 extra turn");
 		System.out.println("Light attacks take 5 HP down with no side effects");
 		System.out.println("Run is basically running away from the battle- May or may not be successful");
 		System.out.println("Try to be friendly: Self explanatory- May or may not be successful");
 		System.out.println("Battle about to begin..");
 	}
 	else
 		System.out.println("Fair Enough");
 	System.out.println("BATTLE BEGINS!");
 	System.out.println(u+"'s hp is "+php);
 	System.out.println(e+"'s hp is "+ehp+" and attack is "+eatt);
 	do
 	{
 		System.out.println("Your turn........Choose- 1.Heavy Attack 2.Light Attack 3.Run 4.Try to be friendly");
 		int runfri=rand.nextInt(4);			//for Run and friendly.
 		int choice=m.nextInt();
 		if(choice==1)
 		{
			System.out.println(u+" attacked "+e+" heavily");
 			ehp-=8;
 			if(ehp>0&&php>0)
 			{
 			enemyattack();
 			if(php>=0)
 			System.out.println(u+"'s hp is "+php);
 			else
 				System.out.println(u+ "'s hp is 0");
 			}
 		}
 		else if(choice==2)
 			{
 			System.out.println(u+" attacked "+ e);
 			ehp-=5;
 			}
 		else if(choice==3)
 		{
 			System.out.println("You attempted to run!");
 			if(runfri==0)
 				{
				System.out.println("You Successfully Ran away!!");
 				counter=0;
 				break;
 				}
 			else
 				System.out.println("You have been caught.....");
 		}
 		else if(choice==4)
 			{
 			System.out.println("You are attempting to be friends with "+e);
 			if(runfri==2)
 				{
 				System.out.println(e+" doesnot attack you!");
 				counter=0;
 				break;
 				}
			else
 				System.out.println(e+" is unperturbed!");
 			}
 		else
 			System.out.println(u+" is confused what to do ");
 		if(ehp>0&&php>0)
 		{
 		enemyattack();
 		if(php>=0)
 			System.out.println(u+"'s hp is "+php);
 			else
 				System.out.println(u+ "'s hp is 0");
 		}
 	}while(ehp>0&&php>0);
 	if(ehp<=0)
 		{
 		System.out.println(e+" has fainted!!!");
 		System.out.println("----------------YOU BEAT THE GAME--------------------");
 		}
 	else if(php<=0)
 	{
 		System.out.println(u+" has fainted.....");
 		System.out.println("xxxxxxxxxxxxxxxxYOU LOST THE GAMExxxxxxxxxxxxxxxxxxxxxx");
 	}
 	else if(counter==0)
 		System.out.println("You forfeitted the match");
 }
 static void enemyattack()
 {	
 	System.out.println(e+"'s hp is "+ehp+" and attack is "+eatt);
 	int m2=rand.nextInt(3);
 	if(ehp<10&&m2==0&&evolve==0)
 	{
 			evolve++;
 			eatt+=5;
 			ehp+=10;
			System.out.println(e+" has evolved!!!!!!!!!!!!!!!!!!");
 			System.out.println("new hp= "+ehp+" new attack "+eatt);
 			
 	}
 	System.out.println(e+" 's turn");
 	System.out.println(e+" attacked "+u);
 		php-=eatt;
 	 }
 }