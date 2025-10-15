class Main {
  public static void main(String[] args) {
    System.out.println("Hello and welcome to Frostholt");
    System.out.println("This is a place that has gone through a ice age.");
    System.out.println("The people of this world are suffering and need the coal so that they are able to keep warm and cook food.");
    System.out.println("After waking up you head to the Adventurers Guild");
    System.out.println("Your Guild Master approaches you and gives you two options for todays mission")
    System.out.println("Option 1: Go to the Ice Caves and collect 10 pieces of coal");
    System.out.println("Option 2: Go to the Abandoned Mine and collect 10 gold ores");
    System.out.println("Which option do you choose? (Type 1 or 2)");
    Scanner answer = new Scanner(System.in);
    int choice = answer.nextInt();
    if (choice == 1)  {
      System.out.println("You have chosen to go to the Ice Caves");
      System.out.println("You head to the Ice Caves and come upon a fork in the road");
      System.out.println("Do you want to go left or right? (Type left or right)");
      Scanner direction = new Scanner(System.in);
      String dir = direction.nextLine();
      if (dir.equals("left")) {
        System.out.println("You have chosen to go left");
        System.out.println("You head down the left path and come upon a group of ice goblins");
        System.out.println("The ice goblins attack you!");
        System.out.println("You died. Game Over.");
        System.out.println("Reset to last checkpoint? (Type yes or no)");
        Scanner reset = new Scanner(System.in);
        String res = reset.nextLine();
        if (res.equals("yes")) {
          System.out.println("You have chosen to reset to the last checkpoint");
          System.out.println("You head to the Ice Caves and come upon a fork in the road");
            System.out.println("Do you want to go left or right? (Type left or right)");
            }
      if (choice == 2) {
        System.out.println("You have chosen to go to the Abandoned Mine");
        System.out.println("You head to the Abandoned Mine");
        System.out.println("You come upon a group of cave trolls");
        System.out.println("The cave trolls attack you!");
        System.out.println("You fend them off and collect 10 gold ores");
        System.out.println("You head back to the Adventurers Guild and give the gold ores to your Guild Master");
        System.out.println("Your Guild Master thanks you and gives you 50 gold coins as a reward");
        System.out.println("You have completed your mission. Congratulations!");
        System.out.println("Do you want to play again? (Type yes or no)");
          }
        }
      }  
  }
}