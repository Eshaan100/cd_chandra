import java.util.Arrays;

class Spacecraft {
    private int[] pos;                                             //initialising two variables pos for position and dir for direction
    private String dir;

    public Spacecraft(int[] inipos, String inidir) {
        pos = inipos;
        dir = inidir;
    }

    public void fwd() {                                           //fwd is a function to move forward
        if (dir.equals("N")) {
            pos[1]++;
        } else if (dir.equals("S")) {
            pos[1]--;
        } else if (dir.equals("E")) {
            pos[0]++;
        } else if (dir.equals("W")) {
            pos[0]--;
        } else if (dir.equals("Up")) {
            pos[2]++;
        } else if (dir.equals("Down")) {
            pos[2]--;
        }
    }

    public void back() {                                         //back is a function to move backward
        if (dir.equals("N")) {
            pos[1]--;
        } else if (dir.equals("S")) {
            pos[1]++;
        } else if (dir.equals("E")) {
            pos[0]--;
        } else if (dir.equals("W")) {
            pos[0]++;
        } else if (dir.equals("Up")) {
            pos[2]--;
        } else if (dir.equals("Down")) {
            pos[2]++;
        }
    }

    public void left() {                                        //left is a function to turn left
        if (dir.equals("N")) {
            dir = "W";
        } else if (dir.equals("S")) {
            dir = "E";
        } else if (dir.equals("E")) {
            dir = "N";
        } else if (dir.equals("W")) {
            dir = "S";
        }
    }

    public void right() {                                      //right is a function to turn right
        if (dir.equals("N")) {
            dir = "E";
        } else if (dir.equals("S")) {
            dir = "W";
        } else if (dir.equals("E")) {
            dir = "S";
        } else if (dir.equals("W")) {
            dir = "N";
        }
    }

    public void up() {                                        //up is a function to turn upwards
        if (dir.equals("N") || dir.equals("S")) {
            dir = "Up";
        }
    }

    public void down() {                                      //down is a function to turn downwards
        if (dir.equals("N") || dir.equals("S")) {
            dir = "Down";
        }
    }

    public int[] getpos() {
        return pos;
    }

    public String getdir() {
        return dir;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] inipos = {0, 0, 0};                            // initial position of spacecraft 
        String inidir = "N";
        String[] cmd = {"f", "r", "u", "b", "l"};

        Spacecraft spacecraft = new Spacecraft(inipos, inidir);

        for (String command : cmd) {
            switch (command) {
                case "f":
                    spacecraft.fwd();
                    break;
                case "b":
                    spacecraft.back();
                    break;
                case "l":
                    spacecraft.left();
                    break;
                case "r":
                    spacecraft.right();
                    break;
                case "u":
                    spacecraft.up();
                    break;
                case "d":
                    spacecraft.down();
                    break;
            }
        }

        int[] finpos = spacecraft.getpos();
        String findir = spacecraft.getdir();

        System.out.println("Final pos: " + Arrays.toString(finpos));
        System.out.println("Final dir: " + findir);
    }
}
