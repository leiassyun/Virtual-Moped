/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and MUST be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {
    private int[] location = {10,5};
    private String orientation = "south";
    private int gas = 100;

    
    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return orientation; // placeholder only... delete this!        
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        String st = String.valueOf(location[0]);
        String ave = String.valueOf(location[1]);

        String [] sts = st.split("");
        String n1 = sts[sts.length-1];
        String [] aves = ave.split("");
        String n2 = aves[aves.length-1];

        String upper  = Character.toUpperCase(getOrientation().charAt(0)) + getOrientation().substring(1);
        System.out.println("Now at " + st+suff(n1) + " St. and " + ave+suff(n2)+" Ave, facinig "+ upper+". "+ adCheck());

    }
    
    public String suff(String num){
        if (num.equals("1") ){
            return "st";
        }
        else if (num.equals("2")){
            return "nd";
        }
        else if (num.equals("3")){
            return "rd";
        }
        else {
            return "th";
        }
    }

    public String adCheck(){
        int[] currentL = getLocation();
        if (currentL[0] == 79 && currentL[1]==8){
            return "Did you know American Museum of Natural history has an exhibition called Discover the world of SharksNow open?";
        }
        else if (currentL[0] == 74 && currentL[1]==1){
            return "Did you know Memorial Sloan Kettering was founded in 1884 and today is a world leader in patient care, research, and educational programs?";
        }
        else if (currentL[0] == 56 && currentL[1]==3){
            return "Did you know Tina's Cuban Cuisine uses the most natural ingredients that are always freshly prepared?";
        }
        else if (currentL[0] == 12 && currentL[1]==4){
            return "Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";
        }
        else{
            return "";
        }

    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        int[] currentL = getLocation();
        if (gas>0){
            switch(getOrientation()){
                case "north":
                    setOrientation("west");
                    if (currentL[1]<10){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] +1}); 
                    }
                    break;
                case "south":
                    setOrientation("east");
                      if (currentL[1]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] -1});   
                    }
                    break;
                case "west":
                    setOrientation("south");
                    if (currentL[0]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]-1, currentL[1]});
                    }
                    break;
                case "east":
                    setOrientation("north");
                    if (currentL[0]<200){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]+1, currentL[1]});
                    }
                    break;
            }
        }
        else{
            System.out.println("We have run out of gas. Byb bye!");
            System.exit(0);
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        int[] currentL = getLocation();
        if (gas>0){
            switch(getOrientation()){
                case "south":
                    setOrientation("west");
                    if (currentL[1]<10){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1]+1});
                    }
                    break;
                case "north":
                    setOrientation("east");
                    if (currentL[1]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1]-1});
                    }
                    break;
                case "east":
                    setOrientation("south");
                    if (currentL[0]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]-1, currentL[1]});
                    }
                    break;
                case "west":
                    setOrientation("north");
                    if (currentL[0]<200){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]+1, currentL[1]});
                    }
                    break;
            }
        }
        else{
            System.out.println("We have run out of gas. Byb bye!");
            System.exit(0);
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        int[] currentL = getLocation();
        if (gas>0){
            switch(getOrientation()){
                case "west":
                    if (currentL[1]<10){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] +1});
                    }
                    break;
                case "east":
                      if (currentL[1]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] -1});
                    }
                    break;
                case "south":
                    if (currentL[0]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]-1, currentL[1]});
                    }
                    break;
                case "north":
                    if (currentL[0]<200){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]+1, currentL[1]});
                    }
                    break;
            }
        }
        else{
            System.out.println("We have run out of gas. Byb bye!");
            System.exit(0);
        }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        int[] currentL = getLocation();
        if (gas>0){
            switch(getOrientation()){
                case "east":
                    if (currentL[1]<10){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] +1});
                    }
                break;
                case "west":
                      if (currentL[1]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0], currentL[1] -1});
                    }
                break;
                case "north":
                    if (currentL[0]>1){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]-1, currentL[1]});
                    }
                break;
                case "south":
                    if (currentL[0]<200){
                        setGasLevel(getGasLevel()-5);
                        setLocation(new int[]{currentL[0]+1, currentL[1]});
                    }
                break;
            }
        }
        else{
            System.out.println("We have run out of gas. Byb bye!");
            System.exit(0);
        }
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return gas; // placeholder only... delete this!
    }

    public void setGasLevel(int gas) {
        this.gas=gas;
    }
    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        if (getGasLevel()>0){
            System.out.println("The gas tank is currently " + getGasLevel() + "% full.");
        }
        else {
            System.out.println("We have run out of gas. Bye bye!");
            park();
        }
    }
    
    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        setGasLevel(100);
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We have parked");
        System.exit(0);

    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        int[] currentL = getLocation();
  
        while (currentL[1] !=8){
            if (currentL[1]<8){
                setOrientation("west");
            }
            else if (currentL[1]>8){
                setOrientation("east");
            }
            printLocation();
            goStraight();
            currentL = getLocation();

            if (getGasLevel() == 5){
                fillGas();
            }
        
        }

        while (currentL[1] == 8 && currentL[0] !=15){
            if (currentL[0]<15){
                setOrientation("north");
            }
            else if (currentL[0]>15){
                setOrientation("south");
            }
            printLocation();
            goStraight();
            currentL = getLocation();
            if (getGasLevel() == 5){
                fillGas();
            }
        }
        printLocation();
        System.out.println("We have reached Xi'an Famous Foods. Enjoy your noodles.");
    }
    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        return "go left, go right, stright on, back up, how we doin'?, fill it up, park, go to Xi'an Famous Foods, help";
    }; // placeholder only... delete thiss!        

    public void printHelp(){
        System.out.println(getHelp());
    }
    

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.location = location;
    }


    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        return location;

        /*
        // the following two lines are placeholder... delete them and return this moped's correct coordinates.
        int[] location = {3, 4}; // an example array at 3rd st and 4th Ave.... placeholder only... delete this!
        return location;
         */
    }

}
