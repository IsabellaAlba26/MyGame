//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class GameLand implements Runnable, KeyListener {

    //Variable Declaration Section
    //Declare the variables used in the program
    //You can set their initial values here if you want

    //Sets the width and height of the program/game window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    //
    public boolean startScreen = true;
    public boolean level1Screen = false;
    public boolean level1PlayingScreen;
    public boolean level2Screen;
    public boolean level2PlayingScreen;
    public boolean level3Screen;
    public boolean level3PlayingScreen;
    public boolean level4Screen;
    public boolean level4PlayingScreen;
    public boolean level5Screen;
    public boolean level5PlayingScreen;
    public boolean gameOver = false;
    public boolean showWinningScreen;


    //Declare the objects used in the program below
    /**
     * STEP 1: Declare your object and give it a name
     **/
    public Hero cat;
    public RegularMice[] mouse;
    public Hero goldenMouse;

    public int score;
    public long startTime;
    public long currentTime;
    public long elapsedTime;


    /**
     * STEP 2: Declare an image for your object
     **/
    public Image homescreen;
    public Image catPic;
    public Image mousePic;
    public Image goldenMousePic;
    public Image attic;
    public Image bathroom;
    public Image bedroom;
    public Image kitchen;
    public Image livingRoom;
    public Image level1screen;
    public Image level2screen;
    public Image level3screen;
    public Image level4screen;
    public Image level5screen;
    public Image losingScreen;
    public Image winningScreen;

    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
        // ex.run();
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
        //for each object that has a picture, load in images as well
        /**STEP 3: construct a specific Hero**/


        /**STEP 4: load in the image for your object**/
        homescreen = Toolkit.getDefaultToolkit().getImage("Homescreen.png");
        catPic = Toolkit.getDefaultToolkit().getImage("cat.png");
        mousePic = Toolkit.getDefaultToolkit().getImage("mouse.png");
        goldenMousePic = Toolkit.getDefaultToolkit().getImage("golden mouse.png");
        attic = Toolkit.getDefaultToolkit().getImage("attic.jpeg");
        bathroom = Toolkit.getDefaultToolkit().getImage("bathroom.jpeg");
        bedroom = Toolkit.getDefaultToolkit().getImage("bedroom.jpeg");
        kitchen = Toolkit.getDefaultToolkit().getImage("kitchen.jpeg");
        livingRoom = Toolkit.getDefaultToolkit().getImage("living room.jpeg");
        level1screen = Toolkit.getDefaultToolkit().getImage("LEVEL 1 screen.png");
        level2screen = Toolkit.getDefaultToolkit().getImage("Level 2 screen.png");
        level3screen = Toolkit.getDefaultToolkit().getImage("Level 3 screen.png");
        level4screen = Toolkit.getDefaultToolkit().getImage("Level 4 screen.png");
        level5screen = Toolkit.getDefaultToolkit().getImage("Level 5 screen.png");
        losingScreen = Toolkit.getDefaultToolkit().getImage("Losing screen.png");
        winningScreen = Toolkit.getDefaultToolkit().getImage("winning screen.png");


    }// GameLand()

    public void runCorrectLevel() {
        // call levels based on booleans
        if (startScreen) {
            startScreen = false;
            level1Screen = true;
            System.out.println("go from start screen to level 1 screen");
        }
        if (level1Screen) {
            level1Screen = false;
            startLevel1();
            System.out.println("level 1 is playing");
            level1PlayingScreen = true;
        }
        if (level1PlayingScreen && score == 30) {
            level2Screen = true;
        }
        if (level2Screen) {
            level2Screen = false;
            level2PlayingScreen = true;
            startLevel2();
        }
        if (level2PlayingScreen && score == 30) {
            level3Screen = true;
        }
        if (level3Screen) {
            level3Screen = false;
            level3PlayingScreen = true;
            startLevel3();
        }
        if (level3PlayingScreen && score == 30) {
            level4Screen = true;
        }
        if (level4Screen) {
            level4Screen = false;
            level4PlayingScreen = true;
            startLevel4();
        }
        if (level4PlayingScreen && score == 30) {
            level5Screen = true;
        }
        if (level5Screen) {
            level5Screen = false;
            level5PlayingScreen = true;
            startLevel5();
        }
        if (level5PlayingScreen && score == 30) {
            showWinningScreen = true;
        }
    }

    public void startLevel1() {
        cat = new Hero(200, 400, 20, 20, 250, 166, true);
        //the start time will need to move to when levels start
        startTime = System.currentTimeMillis();
        mouse = new RegularMice[75];
        for (int x = 0; x < mouse.length; x = x + 1) {
            mouse[x] = new RegularMice((int) (Math.random() * 2100), (int) (Math.random() * 1801), (int) (Math.random() * 5.1), (int) (Math.random() * 5.1), 100, 71, true);
        }
        goldenMouse = new Hero((int) (Math.random() * 2100), (int) (Math.random() * 1801), (int) (Math.random() * 5.1), (int) (Math.random() * 5.1), 100, 71, true);
    }

    public void startLevel2() {
        //reset time
        startTime = System.currentTimeMillis();
        //reset score
        score = 0;
    }

    public void startLevel3() {
        //reset time
        startTime = System.currentTimeMillis();
        //reset score
        score = 0;
        //new mice
        mouse = new RegularMice[100];
        for (int x = 0; x < mouse.length; x = x + 1) {
            mouse[x] = new RegularMice((int) (Math.random() * 2100), (int) (Math.random() * 1801), (int) (Math.random() * 5.1), (int) (Math.random() * 5.1), 100, 71, true);
        }
    }

    public void startLevel4() {
        //reset time
        startTime = System.currentTimeMillis();
        //reset score
        score = 0;
        //new mice
        mouse = new RegularMice[125];
        for (int x = 0; x < mouse.length; x = x + 1) {
            mouse[x] = new RegularMice((int) (Math.random() * 2100), (int) (Math.random() * 1801), (int) (Math.random() * 5.1), (int) (Math.random() * 5.1), 100, 71, true);
        }
    }

    public void startLevel5() {
        //reset time
        startTime = System.currentTimeMillis();
        //reset score
        score = 0;
        //new mice
        mouse = new RegularMice[135];
        for (int x = 0; x < mouse.length; x = x + 1) {
            mouse[x] = new RegularMice((int) (Math.random() * 2100), (int) (Math.random() * 1801), (int) (Math.random() * 5.1), (int) (Math.random() * 5.1), 100, 71, true);
        }
    }

    public void timer() {
        //getting current time`
        currentTime = System.currentTimeMillis();
        //calculate elapsed time
        if (level1PlayingScreen) {
            elapsedTime = (int) (50 - (currentTime - startTime) * .001);
        }
        if (level1PlayingScreen && score < 30 && elapsedTime < 0) {
            gameOver = true;
        }
        if (level2PlayingScreen) {
            elapsedTime = (int) (45 - (currentTime - startTime) * .001);
        }
        if (level2PlayingScreen && score < 30 && elapsedTime < 0) {
            gameOver = true;
        }
        if (level3PlayingScreen) {
            elapsedTime = (int) (40 - (currentTime - startTime) * .001);
        }
        if (level3PlayingScreen && score < 30 && elapsedTime < 0) {
            gameOver = true;
        }
        if (level4PlayingScreen) {
            elapsedTime = (int) (30 - (currentTime - startTime) * .001);
        }
        if (level4PlayingScreen && score < 30 && elapsedTime < 0) {
            gameOver = true;
        }
        if (level5PlayingScreen) {
            elapsedTime = (int) (20 - (currentTime - startTime) * .001);
        }
        if (level5PlayingScreen && score < 30 && elapsedTime < 0) {
            gameOver = true;
        }
    }
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            collisions(); //checks for rec intersectiohns
            timer();
            render();  // paint the graphics
            pause(20); // sleep for 20 ms

        }
    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        if (startScreen) {
            g.drawImage(homescreen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level1Screen) {
            g.drawImage(level1screen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level1PlayingScreen) {
            g.drawImage(livingRoom, 0, 0, WIDTH, HEIGHT, null);
            g.drawString("Mice Killed: " + score, 100, 100);
            g.drawString("Time left:" + elapsedTime, 900, 100);
        }
        if (level2Screen) {
            g.drawImage(level2screen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level2PlayingScreen) {
            g.drawImage(kitchen, 0, 0, WIDTH, HEIGHT, null);
            g.drawString("Mice Killed: " + score, 100, 100);
            g.drawString("Time left:" + elapsedTime, 900, 100);
        }
        if (level3Screen) {
            g.drawImage(level3screen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level3PlayingScreen) {
            g.drawImage(bathroom, 0, 0, WIDTH, HEIGHT, null);
            g.drawString("Mice Killed: " + score, 100, 100);
            g.drawString("Time left:" + elapsedTime, 900, 100);
        }
        if (level4Screen) {
            g.drawImage(level4screen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level4PlayingScreen) {
            g.drawImage(bedroom, 0, 0, WIDTH, HEIGHT, null);
            g.drawString("Mice Killed: " + score, 100, 100);
            g.drawString("Time left:" + elapsedTime, 900, 100);
        }
        if (level5Screen) {
            g.drawImage(level5screen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (level5PlayingScreen) {
            g.drawImage(attic, 0, 0, WIDTH, HEIGHT, null);
            g.drawString("Mice Killed: " + score, 100, 100);
            g.drawString("Time left:" + elapsedTime, 900, 100);
        }

        //draw the image of your objects below:
        /** STEP 5: draw the image of your object on the screen**/
        if (cat != null && !level2Screen && !level3Screen && !level4Screen && !level5Screen) {
            g.drawImage(catPic, cat.xpos, cat.ypos, cat.width, cat.height, null);
        }
        if (goldenMouse != null && goldenMouse.isAlive) {
            g.drawImage(goldenMousePic, goldenMouse.xpos, goldenMouse.ypos, goldenMouse.width, goldenMouse.height, null);
        }
        if (mouse != null && !level2Screen && !level3Screen && !level4Screen && !level5Screen) {
            for (int x = 0; x < mouse.length; x = x + 1) {
                if (mouse[x].isAlive == true) {
                    g.drawImage(mousePic, mouse[x].xpos, mouse[x].ypos, mouse[x].width, mouse[x].height, null);
                }
            }
        }


        if (gameOver) {
            g.drawImage(losingScreen, 0, 0, WIDTH, HEIGHT, null);
        }
        if (showWinningScreen) {
            g.drawImage(winningScreen, 0, 0, WIDTH, HEIGHT, null);
        }


        //dispose the images each time(this allows for the illusion of movement).
        g.dispose();

        bufferStrategy.show();
    }

    public void moveThings() {
        //call the move() method code from your object class
        if (cat != null) { //cat!=null means if cat is not empty
            cat.move(5);
        }
        if (mouse != null) {
            for (int x = 0; x < mouse.length; x = x + 1) {
                mouse[x].bouncingMove();
            }
        }
    }

    public void collisions() {
        if (mouse != null && cat != null) {
            for (int x = 0; x < mouse.length; x = x + 1) {
                if (mouse[x].rec.intersects(cat.rec) && mouse[x].isAlive == true) {
                    mouse[x].isAlive = false;
                    score = score + 1;
                }
            }
        }

        if (cat != null && goldenMouse != null && goldenMouse.isAlive == true) {
            if (goldenMouse.rec.intersects(cat.rec) && level5PlayingScreen == true) {
                showWinningScreen = true;
                goldenMouse.isAlive = false;
            } else if (goldenMouse.rec.intersects(cat.rec)) {
                level5Screen = true;
                goldenMouse.isAlive = false;
            }
        }

        /** LEVEL STUFF/BOOLEANS **/

        //level 1 stuff
        if (level1PlayingScreen && score == 30) {
            level1PlayingScreen = false;
            level2Screen = true;
        }
        //level 2 stuff
        if (level2PlayingScreen && score == 30) {
            level2PlayingScreen = false;
            level3Screen = true;
        }
        //level 3 stuff
        if (level3PlayingScreen && score == 30) {
            level3PlayingScreen = false;
            level4Screen = true;
        }
        //level 4 stuff
        if (level4PlayingScreen && score == 30) {
            level4PlayingScreen = false;
            level5Screen = true;
        }
        //level 5 stuff
        if (level5PlayingScreen && score == 30) {
            level5PlayingScreen = false;
            showWinningScreen = true;
        }


    }


    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.addKeyListener(this);
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }


    //all three key Listener methods must be included in the code to avoid errors
    @Override
    public void keyTyped(KeyEvent e) {
        //leave empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        System.out.println("Key Character: " + key + " KeyCode: " + keyCode);

        if (keyCode == 40) {
            System.out.println("down");
            cat.downIsPressed = true;

        }
        if (keyCode == 38) {
            System.out.println("up");
            cat.upIsPressed = true;
        }
        if (keyCode == 39) {
            System.out.println("right");
            cat.rightIsPressed = true;
        }
        if (keyCode == 37) {
            System.out.println("left");
            cat.leftIsPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        System.out.println("Key Character: " + key + " KeyCode: " + keyCode);

        //user control
        if (keyCode == 40) {
            System.out.println("down");
            cat.downIsPressed = false;

        }
        if (keyCode == 38) {
            System.out.println("up");
            cat.upIsPressed = false;
        }

        if (keyCode == 39) {
            System.out.println("right");
            cat.rightIsPressed = false;
        }
        if (keyCode == 37) {
            System.out.println("left");
            cat.leftIsPressed = false;
        }

        if (keyCode == 10) { //keyCode 10 is enter/return key
            runCorrectLevel();
            System.out.println("10 is pressed");
            if (gameOver == true) {
                gameOver = false;
                startScreen = true;
            }
        }


    }
}
