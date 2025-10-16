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
    System.out.println("You wake up the next day and today you want to go to the Adventurers Guild again.");
    System.out.println("Today you decide you want to have a party of 3 people to go with.");
    System.out.println("Your party are the following characters:");
    System.out.println("1. Bronn the Warrior, This is the tank of the group weilding a large battleaxe");
    System.out.println("2. Elara the Mage, She is a healer and a backline support");
    System.out.println("3. Dain the Rogue, He is short and sneaky with a sharp dagger.");
    System.out.println("4. Thalia the Ranger, She is an archer with a pet wolf.");
    System.out.println("5. Kael the Paladin, He is a holy knight with a big sword and shield.");
    System.out.println("Choose 3 party members by typing their numbers separated by spaces (e.g., 1 3 5):");
    String partyInput = scanner.nextLine();
    String[] partyChoices = partyInput.split(" ");
    if (partyChoices.length != 3) {
      System.out.println("You must choose exactly 3 party members. Game Over.");
    }
      for (String choiceStr : partyChoices) {
        int choiceNum;
        try {
          choiceNum = Integer.parseInt(choiceStr);
        } catch (NumberFormatException e) {
          System.out.println("Invalid input. Please enter numbers only. Game Over.");
          return;
        }
      }
      System.out.println("Your party is ready for the next adventure!");
      System.out.println("You decide to go to the Ice Dragons Lair.");
      System.out.println("On your way there you and your party stop by a village to rest."); 
      System.out.println("While you are resting a villager approaches you and asks if you want to hear their story of the Ice Dragon.");
      System.out.println("Do you want to hear the villager's story? (Type yes or no)");
      String hearStory = scanner.nextLine();
      if (hearStory.equalsIgnoreCase("yes")) {
        System.out.println("The villager tells you that the Ice Dragon was once a guardian of the land, but was corrupted by dark magic.");
        System.out.println("The villager warns you that the Ice Dragon is very powerful and you should be prepared for a tough battle.");
      } else {
        System.out.println("You decide not to hear the villager's story and continue on your way.");
      }
      System.out.println("You and your party arrive at the Ice Dragon's Lair.");
      System.out.println("The Ice Dragon appears from a seemingly infinitely deep hole in the mountain.");
      System.out.println("The Ice Dragon Blitz attacks you and your party, dealing massive damage to everyone.");
      System.out.println("The battle begins!");
      System.out.println("If you have Elara the Mage in your party, she heals everyone back to full health.");
      System.out.println("But if you don't have her, you and your party remain on low health.");
      // Dragon encounter checkpoint
      boolean atDragonCheckpoint = true;
      while (atDragonCheckpoint) {
        System.out.println("The dragon rears back and swipes at you with its claws.");
        System.out.println("Do you want to attempt to parry the dragon or dodge? (Type parry or dodge)");
        String battleChoice = scanner.nextLine();
        if (battleChoice.equalsIgnoreCase("parry")) {
          System.out.println("You attempt to parry the dragon's attack.");
          if (Math.random() < 0.5) {
            System.out.println("You successfully parry the attack and counter with a powerful strike, severely wounding the dragon!");
            System.out.println("If you have Bronn the Warrior in your party, he lands the final blow to the dragon.");
            System.out.println("You have defeated the Ice Dragon! Congratulations!");
            atDragonCheckpoint = false; // victory, leave checkpoint
          } else {
            System.out.println("You fail to parry the attack and are hit, taking massive damage.");
            System.out.println("You must retreat and regroup. Game Over.");
            System.out.println("Reset to last checkpoint before the dragon? (Type yes or no)");
            String resetDragon = scanner.nextLine();
            if (resetDragon.equalsIgnoreCase("yes")) {
              System.out.println("You awaken back at the entrance to the dragon's chamber, ready to try again.");
              // loop continues, keeping atDragonCheckpoint = true
            } else {
              System.out.println("You leave the dragon's lair to live another day.");
              atDragonCheckpoint = false; // exit loop and end
            }
          }
        } else if (battleChoice.equalsIgnoreCase("dodge")) {
          System.out.println("You attempt to dodge the dragon's attack.");
          if (Math.random() < 0.6) {
            System.out.println("You evade the blow and your party counterattacks, wounding the dragon considerably.");
            System.out.println("Your party finishes the dragon. Victory!");
            atDragonCheckpoint = false;
          } else {
            System.out.println("You fail to dodge and are struck heavily. Game Over.");
            System.out.println("Reset to last checkpoint before the dragon? (Type yes or no)");
            String resetDragon = scanner.nextLine();
            if (resetDragon.equalsIgnoreCase("yes")) {
              System.out.println("You awaken back at the entrance to the dragon's chamber, ready to try again.");
              // loop continues, keeping atDragonCheckpoint = true
            } else {
              System.out.println("You retreat from the lair to recover.");
              atDragonCheckpoint = false;
            }
          }
        } else {
          System.out.println("Invalid input. Please type 'parry' or 'dodge'.");
        }
      }
    
    scanner.close();
  }
}