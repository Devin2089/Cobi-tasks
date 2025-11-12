import java.util.List;

public class NPC {
    private final String name;
    private final String role;
    private final String[] dialogue;
    private final boolean helpful;
    private final String clue; // short clue if helpful

    public NPC(String name, String role, String[] dialogue, boolean helpful, String clue) {
        this.name = name;
        this.role = role;
        this.dialogue = dialogue;
        this.helpful = helpful;
        this.clue = clue;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public boolean isHelpful() { return helpful; }
    public String getClue() { return clue; }

    public void speak() {
        System.out.println("You talk to " + name + " (" + role + "):");
        for (String line : dialogue) {
            System.out.println("  \"" + line + "\"");
        }
    }
}
