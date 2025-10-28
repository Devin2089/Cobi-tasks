import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

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
    String[] partyChoices = partyInput.trim().split("\\s+");
    if (partyChoices.length != 3) {
      System.out.println("You must choose exactly 3 party members. Game Over.");
      scanner.close();
      return;
    }

    List<Character> party = new ArrayList<>();
    Set<Integer> chosen = new HashSet<>();
    for (String choiceStr : partyChoices) {
      int choiceNum;
      try {
        choiceNum = Integer.parseInt(choiceStr);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter numbers only. Game Over.");
        scanner.close();
        return;
      }
      if (choiceNum < 1 || choiceNum > 5) {
        System.out.println("Invalid character choice: " + choiceNum + ". Game Over.");
        scanner.close();
        return;
      }
      if (chosen.contains(choiceNum)) {
        System.out.println("You chose the same character twice. Game Over.");
        scanner.close();
        return;
      }
      chosen.add(choiceNum);
      Character c = Character.createById(choiceNum);
      party.add(c);
    }

    System.out.println("Your party is ready for the next adventure!");
    for (Character c : party) System.out.println(" - " + c);

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

    // Apply initial blitz damage (modified by party composition)
    boolean hasPaladin = party.stream().anyMatch(Character::isPaladin);
    int blitzBase = 60;
    int appliedBlitz = hasPaladin ? (int)(blitzBase * 0.85) : blitzBase;
    for (Character c : party) {
      c.takeDamage(appliedBlitz);
    }
    System.out.println("After the Blitz, party status:");
    for (Character c : party) System.out.println(" - " + c);

    // If Elara (healer) present she heals everyone back to full
    boolean hasElara = party.stream().anyMatch(Character::isHealer);
    if (hasElara) {
      System.out.println("Elara the Mage steps forward and heals the party back to full health.");
      for (Character c : party) c.healFull();
    } else {
      System.out.println("You don't have a healer. Your party remains wounded.");
    }

    // Dragon encounter checkpoint
    boolean atDragonCheckpoint = true;
    while (atDragonCheckpoint) {
      System.out.println("The dragon rears back and swipes at you with its claws.");
      System.out.println("Do you want to attempt to parry the dragon or dodge? (Type parry or dodge)");
      String battleChoice = scanner.nextLine();

      boolean hasWarrior = party.stream().anyMatch(Character::isWarrior);
      boolean hasRogue = party.stream().anyMatch(Character::isRogue);
      boolean hasRanger = party.stream().anyMatch(Character::isRanger);

      double parryChance = 0.5;
      if (hasWarrior) parryChance += 0.2;
      if (hasPaladin) parryChance += 0.1;
      parryChance = Math.min(parryChance, 0.9);

      double dodgeChance = 0.6;
      if (hasRogue) dodgeChance += 0.15;
      if (hasRanger) dodgeChance += 0.1;
      dodgeChance = Math.min(dodgeChance, 0.95);

      if (battleChoice.equalsIgnoreCase("parry") || battleChoice.equalsIgnoreCase("dodge")) {
        boolean success = battleChoice.equalsIgnoreCase("parry") ? (Math.random() < parryChance) : (Math.random() < dodgeChance);
        if (battleChoice.equalsIgnoreCase("parry")) System.out.println("You attempt to parry the dragon's attack.");
        else System.out.println("You attempt to dodge the dragon's attack.");

        // Start a multi-round fight where the party chips away at the dragon's HP
        int dragonHp = 300;
        int dragonAttack = 35;
        System.out.println("The Ice Dragon has " + dragonHp + " HP. You must chip away at it.");

        if (success) {
          System.out.println("Your opening maneuver succeeds and your party lands a strong initial strike!");
          // initial extra damage on success
          int openingBonus = 30;
          dragonHp -= openingBonus;
          System.out.println("You deal " + openingBonus + " bonus damage. Dragon HP: " + Math.max(0, dragonHp));
        } else {
          System.out.println("Your opening maneuver fails. The dragon strikes first and deals heavy damage.");
          for (Character c : party) c.takeDamage(80);
          System.out.println("After the strike, party status:");
          for (Character c : party) System.out.println(" - " + c);
        }

        // Start with firstRound bonuses available
        boolean firstRound = true;

        // Fight loop: each round party deals damage, then dragon retaliates if still alive
        while (dragonHp > 0 && party.stream().anyMatch(Character::isAlive)) {
          // calculate party damage (each character contributes; rogues get first-round backstab via firstRound flag)
          int partyDamage = 0;
          for (Character c : party) {
            if (!c.isAlive()) continue;
            int dmg = c.attackDamage(firstRound);
            // small random crit for rogues in addition to backstab
            if (c.isRogue() && Math.random() < 0.15) {
              dmg *= 2;
              System.out.println(c.getName() + " lands a critical strike!");
            }
            partyDamage += dmg;
            // include pet damage (ranger wolf)
            partyDamage += c.petDamage();
          }

          System.out.println("Your party deals " + partyDamage + " damage to the dragon.");
          dragonHp -= partyDamage;
          System.out.println("Dragon HP is now: " + Math.max(0, dragonHp));

          if (dragonHp <= 0) {
            System.out.println("The dragon collapses — you've defeated it! Congratulations!");
            break;
          }

          // dragon retaliates
          // dragon retaliates; party defensive bonuses mitigate incoming damage
          int totalDefenseBonus = party.stream().mapToInt(Character::defenseBonus).sum();
          int effectiveDragonAttack = Math.max(5, dragonAttack - totalDefenseBonus);
          System.out.println("The dragon roars and lashes out in retaliation! (Attack: " + effectiveDragonAttack + ")");
          for (Character c : party) {
            if (!c.isAlive()) continue;
            c.takeDamage(effectiveDragonAttack);
          }
          // apply passive support abilities after the dragon attack (heals, auras)
          for (Character c : party) c.applyPassiveSupport(party);
          System.out.println("After the dragon's attack, party status:");
          for (Character c : party) System.out.println(" - " + c);

          if (!party.stream().anyMatch(Character::isAlive)) {
            System.out.println("Your entire party has fallen. Game Over.");
            break;
          }

          // after the first round, disable firstRound bonuses
          firstRound = false;

          System.out.println("Press Enter to continue the fight, or type 'flee' to retreat.");
          String next = scanner.nextLine();
          if (next.equalsIgnoreCase("flee")) {
            System.out.println("You choose to retreat from the battle to fight another day.");
            break;
          }
        }

        atDragonCheckpoint = false;
      } else {
        System.out.println("Invalid input. Please type 'parry' or 'dodge'.");
      }
    }

    scanner.close();
  }
}