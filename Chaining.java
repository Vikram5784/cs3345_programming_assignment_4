import java.util.LinkedList;

public class Chaining
{
    private LinkedList<String>[] table = new LinkedList[50];
    private int size = 50;
    private int collisions;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < size; i++)
            table[i] = new LinkedList<>();

        loadFile();
        menu();
    }

    private int hash(String key)
    {
        int sum = 0;
        for(char c : key.toCharArray())
            sum += c;
        return sum % size;
    }

    private void insert(String key) {
        int index = hash(key);

        if (!table[index].isEmpty()) {
            System.out.println("Collision at index " + index + " for key " + key);
            collisions++;
        }

        table[index].add(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (String key : table[i]) {
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
        System.out.println("Total Collisions: " + collisions);
    }

    public void menu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Display\n2.Rehash\n3.Quit");
            int choice = input.nextInt();

            if (choice == 1)
                display();
            else if (choice == 2)
                rehash();
            else
                break;
        }
    }

    public void loadFile() throws Exception {
        Scanner file = new Scanner(new File("patient.txt"));

        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] parts = line.split(",");
            String lastName = parts[1].trim();
            insert(lastName);
        }

        file.close();
        System.out.println("Total Collisions: " + collisions);
    }
}
