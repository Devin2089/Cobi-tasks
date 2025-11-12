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
    System.out.println("After waking up you head to the Adventurers Guild");
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

    // Dragon encounter checkpoint (enhanced fight: telegraphed attacks, phases, minions)
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

        // Enhanced dragon fight variables
        int dragonMaxHp = 300;
        int dragonHp = dragonMaxHp;
        int dragonAttackBase = 35;
        System.out.println("The Ice Dragon has " + dragonHp + " HP. You must chip away at it.");

        if (success) {
          System.out.println("Your opening maneuver succeeds and your party lands a strong initial strike!");
          int openingBonus = 30;
          dragonHp -= openingBonus;
          System.out.println("You deal " + openingBonus + " bonus damage. Dragon HP: " + Math.max(0, dragonHp));
        } else {
          System.out.println("Your opening maneuver fails. The dragon strikes first and deals heavy damage.");
          for (Character c : party) c.takeDamage(80);
          System.out.println("After the strike, party status:");
          for (Character c : party) System.out.println(" - " + c);
        }

        boolean firstRound = true;
        boolean pendingAttack = false;
        String pendingAttackName = "";
        int pendingAttackDamage = 0;
        int minionTotalHp = 0; // combined HP of all minions
        int roundNum = 1;

        // Fight loop: each round party deals damage, then dragon acts (or telegraphs for next round)
        while (dragonHp > 0 && party.stream().anyMatch(Character::isAlive)) {
          System.out.println("\n--- Round " + roundNum + " ---");

          // Determine phase
          double hpPercent = 100.0 * dragonHp / dragonMaxHp;
          int phase = 1;
          if (hpPercent <= 20) phase = 3;
          else if (hpPercent <= 60) phase = 2;

          // If the dragon telegraphed an attack last round, the player can brace/dodge this round
          String playerAction = ""; // can be 'brace', 'dodge', or empty (attack)
          if (pendingAttack) {
            System.out.println("Warning: The dragon is preparing a " + pendingAttackName + "!\nType 'brace' to defend (reduce damage), 'dodge' to try to avoid, or press Enter to continue.");
            playerAction = scanner.nextLine().trim();
          }

          // calculate party damage (each character contributes; rogues get first-round backstab via firstRound flag)
          int partyDamage = 0;
          for (Character c : party) {
            if (!c.isAlive()) continue;
            int dmg = c.attackDamage(firstRound);
            if (c.isRogue() && Math.random() < 0.15) {
              dmg *= 2;
              System.out.println(c.getName() + " lands a critical strike!");
            }
            partyDamage += dmg;
            partyDamage += c.petDamage();
          }

          // If minions are present, party focuses them first
          if (minionTotalHp > 0) {
            int appliedToMinions = Math.min(minionTotalHp, partyDamage);
            minionTotalHp -= appliedToMinions;
            partyDamage -= appliedToMinions;
            System.out.println("Your party hits the minions for " + appliedToMinions + " damage.");
            if (minionTotalHp <= 0) {
              minionTotalHp = 0;
              System.out.println("All the minions have been defeated!");
            } else {
              System.out.println("Minions remaining HP: " + minionTotalHp);
            }
          }

          // Apply remaining damage to the dragon
          if (partyDamage > 0) {
            System.out.println("Your party deals " + partyDamage + " damage to the dragon.");
            dragonHp -= partyDamage;
            System.out.println("Dragon HP is now: " + Math.max(0, dragonHp));
          } else {
            System.out.println("Your party focused minions this round and dealt no damage to the dragon.");
          }

          if (dragonHp <= 0) {
            System.out.println("The dragon collapses — you've defeated it! Congratulations!");
            break;
          }

          // Resolve a pending attack (if any) after party action
          if (pendingAttack) {
            boolean avoided = false;
            int resolvedDamage = pendingAttackDamage;
            if (playerAction.equalsIgnoreCase("dodge")) {
              // dodge success uses same dodgeChance as earlier
              if (Math.random() < dodgeChance) {
                avoided = true;
                System.out.println("You successfully dodged the " + pendingAttackName + "!");
              } else {
                System.out.println("Your dodge attempt failed!");
              }
            } else if (playerAction.equalsIgnoreCase("brace")) {
              resolvedDamage = Math.max(1, resolvedDamage / 2);
              System.out.println("You brace yourself and reduce the incoming damage.");
            }

            if (!avoided) {
              System.out.println("The dragon's " + pendingAttackName + " slams into your party for " + resolvedDamage + " damage!");
              for (Character c : party) if (c.isAlive()) c.takeDamage(resolvedDamage);
            }
            pendingAttack = false;
            pendingAttackName = "";
            pendingAttackDamage = 0;
          }

          // Check minions attack (if any)
          if (minionTotalHp > 0) {
            int minionAttack = 8; // small damage
            System.out.println("Minions claw at your party for " + minionAttack + " damage each.");
            for (Character c : party) if (c.isAlive()) c.takeDamage(minionAttack);
          }

          // If no pending attack, dragon decides to attack or telegraph next turn
          if (!pendingAttack && dragonHp > 0) {
            int totalDefenseBonus = party.stream().mapToInt(Character::defenseBonus).sum();
            // telegraph probability scales by phase
            double telegraphChance = (phase == 1) ? 0.25 : (phase == 2) ? 0.35 : 0.45;
            if (Math.random() < telegraphChance) {
              // telegraphed heavy attack
              pendingAttack = true;
              pendingAttackName = (phase == 3) ? "Obsidian Dive" : "Freezing Breath";
              pendingAttackDamage = (phase == 1) ? 40 : (phase == 2) ? 55 : 85;
              System.out.println("The dragon snarls and begins to prepare a " + pendingAttackName + "! You feel the temperature drop...");
            } else {
              // immediate attack
              int dragonAttack = Math.max(5, dragonAttackBase + (phase - 1) * 8 - totalDefenseBonus);
              System.out.println("The dragon roars and lashes out in retaliation! (Attack: " + dragonAttack + ")");
              for (Character c : party) if (c.isAlive()) c.takeDamage(dragonAttack);

              // phase 2+ occasionally spawn minions
              if (phase >= 2 && Math.random() < 0.25) {
                int spawned = 1;
                int hpPerMinion = 30;
                minionTotalHp += spawned * hpPerMinion;
                System.out.println("The dragon summons " + spawned + " frosty minion(s) to aid it!");
              }
            }
          }

          // apply passive support abilities after the dragon actions (heals, auras)
          for (Character c : party) c.applyPassiveSupport(party);
          System.out.println("After the dragon's actions, party status:");
          for (Character c : party) System.out.println(" - " + c);

          if (!party.stream().anyMatch(Character::isAlive)) {
            System.out.println("Your entire party has fallen. Game Over.");
            break;
          }

          // after the first round, disable firstRound bonuses
          firstRound = false;
          roundNum++;

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

    System.out.println("Now that the dragon is defeated, you and your party return to the village as heroes.");
    System.out.println("But, this is not the end of your adventures in Frostholt...");
    System.out.println("Your party decides to try to find the source of the dark magic that corrupted the Ice Dragon.");
    System.out.println("Your party decides to look and ask around the town to maybe get a lead on the person it might be.");
    // After the boss fight: village questioning sequence with 15 NPCs (two helpful toward finding the dark wizard)
    System.out.println("After returning to the village you can ask around for leads about the dark magic.");
    List<NPC> villagers = new java.util.ArrayList<>();
    villagers.add(new NPC("Old Merek", "Innkeeper", new String[]{
        "Ah, travelers! Warm yourselves by the fire.",
        "I've heard whispers of a blizzard to the north, but that's all.",
        "If you want ale, ask for the winter brew."}, false, null));
    villagers.add(new NPC("Bryn the Miller", "Miller", new String[]{
        "Grain's been scarce this year, been having trouble with the roads.",
        "I saw lights on the ridge at night, thought it was hunters.",
        "Don't go poking around near the old tower."}, false, null));
    villagers.add(new NPC("Sera the Seamstress", "Seamstress", new String[]{
        "I've sewn many cloaks for the guards.",
        "They came through asking for warm clothes, three nights ago.",
        "One of them had a strange sigil, like a coiled frost."}, false, null));
    villagers.add(new NPC("Pip the Tinker", "Tinkerer", new String[]{
        "My clockwork wolf's been acting odd lately.",
        "I found a shard of something black in the snow.",
        "Might be nothing, but it hummed with cold."}, false, null));
    villagers.add(new NPC("Harrow", "Stablehand", new String[]{
        "Horses throw their shoes when the wind howls.",
        "I heard a chanting once, above the cliffs.",
        "It gave me the chills, I swear."}, false, null));
    villagers.add(new NPC("Lina the Herbalist", "Herbalist", new String[]{
        "I've been brewing salves for frostbite.",
        "Some herbs wilt near that eastern cave.",
        "If you go there, bring a torch."}, false, null));
    villagers.add(new NPC("Gunnar", "Blacksmith", new String[]{
        "Metal gets brittle in this cold.",
        "Strange armored riders passed through a fortnight ago.",
        "They left behind a banner with icy runes."}, false, null));
    villagers.add(new NPC("Maren the Scholar", "Scholar", new String[]{
        "I've studied old scripts about corruption.",
        "The runes you describe match a cult that worshipped the 'Dark Frost'.",
        "If you find a broken obsidian amulet it may be connected."}, true, "Broken obsidian amulet - cult of Dark Frost."));
    villagers.add(new NPC("Old Hest", "Fisherman", new String[]{
        "The lake froze over faster this year.",
        "I saw smoke rising from the mountain's mouth one dawn.",
        "Fisher nets came up frosted and useless."}, false, null));
    villagers.add(new NPC("Sibyl", "Fortune Teller", new String[]{
        "I see swirling snow and stubborn shadow.",
        "A figure wrapped in a dark robe walks where the wind does not touch.",
        "Seek the place where the mountain bleeds moonlight."}, false, null));
    villagers.add(new NPC("Tomas the Guard", "Guard", new String[]{
        "We've doubled patrols near the old quarry.",
        "There was a scuffle with some cloaked figures last week.",
        "They left behind scorch marks unlike any weapon I've seen."}, false, null));
    villagers.add(new NPC("Edda", "Baker", new String[]{
        "I baked a loaf for a cloaked man once, he left a coin carved with ice.",
        "He smelled of ash and mint.",
        "Not a man to cross, if you ask me."}, false, null));
    villagers.add(new NPC("Rolf the Youth", "Messenger", new String[]{
        "I run messages between the farms.",
        "I delivered a package to a tower at night — no one answered.",
        "I hid when I heard chanting from inside."}, false, null));
    villagers.add(new NPC("Eira the Hunter", "Hunter", new String[]{
        "Tracks don't match any deer I've seen.",
        "I followed them to an abandoned chapel on the ridge.",
        "There were symbols drawn in frost on the altar."}, false, null));
    villagers.add(new NPC("Old Hermit", "Hermit", new String[]{
        "I once chased a shadow into a hollow and barely escaped.",
        "It whispered of a wizard wrapped in midnight and snow.",
        "He was seen near the shattered spire at the mountain's heart."}, true, "Shattered spire at the mountain's heart - likely hideout."));

    System.out.println("There are several people you could question. You may choose up to 3 by number.");
    for (int i = 0; i < villagers.size(); i++) {
      NPC n = villagers.get(i);
      System.out.println((i + 1) + ") " + n.getName() + " - " + n.getRole());
    }
    System.out.println("Type numbers separated by spaces (e.g., 2 5 9) or press Enter to skip:");
    String talkInput = scanner.nextLine().trim();
    if (!talkInput.isEmpty()) {
      String[] picks = talkInput.split("\\s+");
      int helpfulFound = 0;
      java.util.List<String> clues = new java.util.ArrayList<>();
      int used = 0;
      for (String p : picks) {
        if (used >= 3) break;
        try {
          int idx = Integer.parseInt(p) - 1;
          if (idx < 0 || idx >= villagers.size()) {
            System.out.println("Skipping invalid selection: " + p);
            continue;
          }
          NPC npc = villagers.get(idx);
          npc.speak();
          if (npc.isHelpful()) {
            helpfulFound++;
            clues.add(npc.getClue());
          }
          used++;
        } catch (NumberFormatException nfe) {
          System.out.println("Skipping invalid input: " + p);
        }
      }
      if (helpfulFound == 0) {
        System.out.println("You didn't find any useful leads from those you questioned.");
      } else {
        System.out.println("You discovered " + helpfulFound + " lead(s):");
        for (String c : clues) System.out.println(" - " + c);
        if (helpfulFound >= 2) {
          System.out.println("Combined, the clues point to a likely hideout: the shattered spire at the mountain's heart.");
        } else {
          System.out.println("You have a partial lead. Question more villagers in future to get the full picture.");
        }
      }
    } else {
      System.out.println("You choose not to question anyone right now.");
    }

    System.out.println("Does your party split up to cover more ground or stay together? (Type split or together)");
    String partyDecision = scanner.nextLine();
    if (partyDecision.equalsIgnoreCase("split")) {
      System.out.println("You decide to split up and cover more ground. Be careful!");
    } else if (partyDecision.equalsIgnoreCase("together")) {
      System.out.println("You decide to stay together; safety in numbers.");
    } else {
      System.out.println("You hesitate and the party stays together by default.");
    }


    scanner.close();
  }
}