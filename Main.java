class Main {
  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    System.out.println("Hello and welcome to Frostholt");
    System.out.println("This is a place that has gone through a ice age.");
    System.out.println("The people of this world are suffering and need the coal so that they are able to keep warm and cook food.");
    System.out.println("After waking up you head to the Adventurers Guild");
    System.out.println("Your Guild Master approaches you and gives you two options for todays mission");
    System.out.println("Option 1: Go to the Ice Caves and collect 10 pieces of coal");
    System.out.println("Option 2: Go to the Abandoned Mine and collect 10 gold ores");
    System.out.println("Which option do you choose? (Type 1 or 2)");
    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline
    if (choice == 1) {
      boolean atCheckpoint = true;
      while (atCheckpoint) {
        System.out.println("You have chosen to go to the Ice Caves");
        System.out.println("You head to the Ice Caves and come upon a fork in the road");
        System.out.println("Do you want to go left or right? (Type left or right)");
        String dir = scanner.nextLine();
        if (dir.equalsIgnoreCase("left")) {
          System.out.println("You have chosen to go left");
          System.out.println("You head down the left path and come upon a group of ice goblins");
          System.out.println("The ice goblins attack you!");
          System.out.println("You died. Game Over.");
          System.out.println("Reset to last checkpoint? (Type yes or no)");
          String res = scanner.nextLine();
          if (!res.equalsIgnoreCase("yes")) {
            atCheckpoint = false;
          }
        } else if (dir.equalsIgnoreCase("right")) {
          System.out.println("You have chosen to go right");
          System.out.println("You head down the right path and find 10 pieces of coal!");
          System.out.println("You collect the coal and return to the Adventurers Guild.");
          System.out.println("Your Guild Master thanks you and gives you 50 gold coins as a reward");
          System.out.println("You have completed your mission. Congratulations!");
          atCheckpoint = false;
        } else {
          System.out.println("Invalid input. Please type 'left' or 'right'.");
        }
      }
    } else if (choice == 2) {
      System.out.println("You have chosen to go to the Abandoned Mine");
      System.out.println("You head to the Abandoned Mine");
      System.out.println("You come upon a group of cave trolls");
      System.out.println("The cave trolls attack you!");
      boolean validAction = false;
      while (!validAction) {
        System.out.println("What do you choose to do? (Type fight or flee)");
        String action = scanner.nextLine();
        if (action.equalsIgnoreCase("fight")) {
          validAction = true;
          // Simple random outcome for fight
          if (Math.random() < 0.5) {
            System.out.println("You bravely fight the trolls but are overwhelmed and perish. Game Over.");
          } else {
            System.out.println("You fight valiantly and defeat the trolls!");
            System.out.println("You collect 10 gold ores and return to the Adventurers Guild.");
            System.out.println("Your Guild Master thanks you and gives you 50 gold coins as a reward");
            System.out.println("You have completed your mission. Congratulations!");
          }
        } else if (action.equalsIgnoreCase("flee")) {
          validAction = true;
          System.out.println("You fled back to the Adventurers Guild.");
          System.out.println("Your Guild Master is disappointed.");
          System.out.println("He tells you to go to the Ice Caves instead.");
          // Send player to the Ice Caves checkpoint loop
          boolean atCheckpoint = true;
          while (atCheckpoint) {
            System.out.println("You have chosen to go to the Ice Caves");
            System.out.println("You head to the Ice Caves and come upon a fork in the road");
            System.out.println("Do you want to go left or right? (Type left or right)");
            String dir = scanner.nextLine();
            if (dir.equalsIgnoreCase("left")) {
              System.out.println("You have chosen to go left");
              System.out.println("You head down the left path and come upon a group of ice goblins");
              System.out.println("The ice goblins attack you!");
              System.out.println("You died. Game Over.");
              System.out.println("Reset to last checkpoint? (Type yes or no)");
              String res = scanner.nextLine();
              if (!res.equalsIgnoreCase("yes")) {
                atCheckpoint = false;
              }
            } else if (dir.equalsIgnoreCase("right")) {
              System.out.println("You have chosen to go right");
              System.out.println("You head down the right path and find 10 pieces of coal!");
              System.out.println("You collect the coal and return to the Adventurers Guild.");
              System.out.println("Your Guild Master thanks you and gives you 50 gold coins as a reward");
              System.out.println("You have completed your mission. Congratulations!");
              atCheckpoint = false;
            } else {
              System.out.println("Invalid input. Please type 'left' or 'right'.");
            }
          }
        } else {
          System.out.println("Invalid input. Please type 'fight' or 'flee'.");
        }
      }
    } else {
      System.out.println("Invalid input. Please type 1 or 2.");
    }
    scanner.close();
  }
}