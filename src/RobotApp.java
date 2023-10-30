import java.util.Scanner;

class Layout {
    private int width;
    private int height;
    private char emptyIcon;

    public Layout(int width, int height, char emptyIcon) {
        this.width = width;
        this.height = height;
        this.emptyIcon = emptyIcon;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getEmptyIcon() {
        return emptyIcon;
    }
}

class Robot {
    private int x;
    private int y;

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveLeft(int steps) {
        x -= steps;
    }

    public void moveRight(int steps) {
        x += steps;
    }

    public void moveUp(int steps) {
        y -= steps;
    }

    public void moveDown(int steps) {
        y += steps;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class RobotApp {
    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot(1, 1);
        this.scanner = new Scanner(System.in);
        String instruction = "";

        System.out.println("-------- Permainan Dimulai --------");

        do {
            draw();
            instruction = waitInstruction();
            executeInstruction(instruction);
        } while (!instruction.equals("x"));

        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'ke atas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");

        int width = layout.getWidth();
        int height = layout.getHeight();
        char emptyIcon = layout.getEmptyIcon();
        int robotX = robot.getX();
        int robotY = robot.getY();

        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                if (x == robotX && y == robotY) {
                    System.out.print("o");
                } else {
                    System.out.print(emptyIcon);
                }
            }
            System.out.println();
        }
    }

    private void executeInstruction(String instruction) {
        if (instruction.length() < 2) {
            System.out.println("Instruksi tidak valid.");
            return;
        }
    
        char direction = instruction.charAt(0);
    
        try {
            int steps = Integer.parseInt(instruction.substring(1));
            switch (direction) {
                case 'd':
                    robot.moveRight(steps);
                    break;
                case 'a':
                    robot.moveLeft(steps);
                    break;
                case 'w':
                    robot.moveUp(steps);
                    break;
                case 's':
                    robot.moveDown(steps);
                    break;
                default:
                    System.out.println("Instruksi tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Instruksi tidak valid.");
        }
    }
    

    public static void main(String[] args) {
        new RobotApp();
    }
}
