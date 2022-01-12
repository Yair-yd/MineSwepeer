
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import javax.accessibility.AccessibleContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author YAIR.D
 */
public class GUI extends JFrame {

    static String time2 = "";
    private int length;
    private int width;
    private int num_mines;
    private static int local_button_I = 0;
    private static int local_button_J = 0;
    private static int right_click = 0;
    private static int left_click = 0;
    private Board b1;
    private JFrame frame;
    private JPanel panel;

    private static boolean button_click = false;
    private static boolean game_over = false;

    public void GUI(int length, int width, int num_mines) {
        this.length = length;
        this.width = width;
        this.num_mines = num_mines;
    }
private void print_all_mines(){
      for (int i = 0; i < b1.getLength(); i++) {
                    for (int j = 0; j < b1.getWidth(); j++) {
                        if (b1.getboard()[i][j].isMine()) {
                           // icon = new ImageIcon("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\new boom.png");
                            b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                        }
                    }
                }
                                            System.out.println("game over!");

                return;
    
}
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    void match(Board b1) {
        for (int i = 0; i < b1.getLength(); i++) {
            for (int j = 0; j < b1.getWidth(); j++) {
                b1.getboard()[i][j].setI(i);
                b1.getboard()[i][j].setJ(j);
                //
                b1.getboard()[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseclikright(java.awt.event.MouseEvent evt) {
                        mouseclikright(evt);
                    }

                });
                b1.getboard()[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        button1MouseClicked(evt);
                    }
                });
                //

            }
        }
    }

    void printtwo(JPanel panel, JFrame frame, Board b1) {
        for (int i = 0; i < b1.getLength(); i++) {
            for (int j = 0; j < b1.getWidth(); j++) {
                b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                b1.getboard()[i][j].setBackground(new Color(204, 255, 153));
                panel.add(b1.getboard()[i][j]);   //add this button to panel

            }
        }
    }

    void print(JPanel panel, JFrame frame, Board b1) {
        Scanner str = new Scanner(System.in);
        ImageIcon icon = new ImageIcon();
        if ( b1.all_press()) {  //if all the local of flages is right and other button be pressing
            GUI.game_over = true;
        }
        if (b1.countmines == -1) { //if preesing on mine, print and finish
            if (b1.isShowall()) {
            print_all_mines();
            }
        } else {//if not pressing on mine!
            for (int i = 0; i < b1.getLength(); i++) {  //print all values on board
                for (int j = 0; j < b1.getWidth(); j++) {

                    if (b1.getboard()[i][j].isFlag()) {   //if this button have flag,print
                      //  icon = new ImageIcon("C:\\\\Users\\\\USER001\\\\Documents\\\\NetBeansProjects\\\\MineSweeper\\\\src\\\\main\\\\java\\\\Minesweeper_flag.svg.png");
                        b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                        b1.getboard()[i][j].setBackground(new Color(204, 255, 153));
                        panel.add(b1.getboard()[i][j]);
                    } else {
                        if (b1.getboard()[i][j].isSelect()) {  //if this button 'click' or 'open' so show like clicked,change color
                            b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                            b1.getboard()[i][j].setBackground(Color.DARK_GRAY);
                        } else {  // print this button clear
                            if (b1.getboard()[i][j].isMine()==false) {//print the 'wall' the end of open buttens
                                b1.getboard()[i][j].setIcon(resizeIcon(b1.getboard()[i][j].icon_button(), (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5, (int) sqrt(pow(b1.getLength() * 35, 2) / (b1.getLength() * b1.getWidth())) - 5));
                            b1.getboard()[i][j].setBackground(new Color(204, 255, 153));
                            }
                           b1.getboard()[i][j].setBackground(new Color(204, 255, 153));

                        }
                    }

                    panel.add(b1.getboard()[i][j]);   //add this button to panel
                }
            }
        }
    
        panel.setVisible(true);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Flage:" + b1.countflages);
        if (this.game_over == false) {
            //b1.Press(str.nextInt(), str.nextInt(), str.nextInt(), str.nextInt());

            if (button_click) {
                b1.Press(local_button_I, local_button_J, right_click, left_click);
                button_click = false;
                print(panel, frame, b1);
                if (GUI.game_over) {
                    print_all_mines();

                }

            }
            while (button_click == false) {
                System.out.print("");
            }

        }
        if (this.game_over == true) {
            print_all_mines();
            return;
        }
        print(panel, frame, b1);//recursi
    }

    public void New_Game() {

        b1 = new Board();
        b1.Board(this.length, this.width);
        match(b1);
        frame = new JFrame();
        frame.setTitle(" MineSweeper YAIR.D");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\USER001\\Documents\\NetBeansProjects\\MineSweeper\\src\\main\\java\\minelogo.jpg");
        frame.setIconImage(icon);
        panel = new JPanel();
        panel.setLayout(new GridLayout(b1.getLength(), b1.getWidth()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, b1.getLength() * 35, b1.getWidth() * 35);
        frame.add(panel);
        b1.Put_Mines(this.num_mines);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + b1.All_Mines());
        print(panel, frame, b1);
      //  System.out.println("game over!");

    }

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {
        this.button_click = true;

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (b1.getboard()[row][col] == evt.getSource()) {
                    if (evt.getButton() == 3) { // if right click
                        this.right_click = 1;
                        this.left_click = 0;
                        // button.setEnabled(true);
                    } else {
                        this.left_click = 1;
                        this.right_click = 0;
                        // button.setEnabled(false);
                    }
                    System.out.println(row + "," + col);
                    this.local_button_I = row;
                    this.local_button_J = col;

                }
            }
        }
    }

   
}
