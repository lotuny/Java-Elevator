import java.awt.*;

import javax.swing.*;

public class Outside implements Runnable{
    JPanel panel;
    JLabel[] floors;
    JButton[] updown;
    int[] floorTobutton;
    int[] stateTobutton;
    int[] pushed;
    int[] answerelevator;
    ButtonListener l;

    Outside(){
        panel = new JPanel();
        floors = new JLabel[Const.floornumber];
        updown = new JButton[Const.floornumber*2-2];
        pushed = new int[Const.floornumber*2-2];
        for(int i = 0; i < pushed.length; i++)
            pushed[i] = 0;

        floorTobutton = new int[Const.floornumber*2-2];
        for(int i = 0; i < floorTobutton.length; i++)
            if(i % 2 == 0)
                floorTobutton[i] = Const.floornumber-i/2;
            else
                floorTobutton[i] = Const.floornumber-(i+1)/2;

        stateTobutton = new int[Const.floornumber*2-2];
        for(int i = 0; i < stateTobutton.length; i++)
            if(i % 2 == 0)
                stateTobutton[i] = -1;
            else
                stateTobutton[i] = 1;

        answerelevator = new int[Const.floornumber*2-2];
        for(int i = 0; i < answerelevator.length; i++)
            answerelevator[i] = -1;

        l = new ButtonListener();
        layout();
    }

    private void layout(){
        panel.setLayout(null);

        for(int i = 0; i < floors.length; i++) {
            floors[i] = new JLabel(String.valueOf(i+1),JLabel.CENTER);
            floors[i].setBorder(BorderFactory.createLineBorder(Color.black));
            floors[i].setBackground(Color.white);
            floors[i].setForeground(Color.black);
            floors[i].setFont(Const.font);
            floors[i].setBounds(0, (Const.floornumber-i-1)*Const.floorsignsize, Const.floorsignsize, Const.floorsignsize);
            panel.add(floors[i]);
        }

        for(int i = 0; i < updown.length; i++) {
            if(i % 2 == 0) {
                updown[i] = new JButton("¨Œ");
                if(i == 0)
                    updown[i].setBounds(Const.floorsignsize*2, 0, Const.floorsignsize*2, Const.floorsignsize);
                else
                    updown[i].setBounds(Const.floorsignsize*3, (i/2)*Const.floorsignsize, Const.floorsignsize*2, Const.floorsignsize);
            }
            else {
                updown[i] = new JButton("¡÷");
                if(i == updown.length-1)
                    updown[i].setBounds(Const.floorsignsize*2, Const.floorsignsize*(Const.floornumber-1), Const.floorsignsize*2, Const.floorsignsize);
                else
                    updown[i].setBounds(Const.floorsignsize, (i/2+1)*Const.floorsignsize, Const.floorsignsize*2, Const.floorsignsize);
            }
            updown[i].addActionListener(l);
            updown[i].setBackground(Color.white);
            updown[i].setForeground(Color.black);
            updown[i].setFont(Const.font);
            panel.add(updown[i]);
        }
    }

    public void run() {
        while(true) {
            if(checkNewButton())
                try {
                    traverseButton();
                } catch(Exception e) {
                    System.exit(0);
                }
        }
    }

    private boolean checkNewButton() {
        for(int i = 0; i < updown.length; i++) {
            if(updown[i].getBackground()==Color.RED && pushed[i]==0)
                return true;
        }
        return false;
    }

    private void traverseButton() {
        for(int i = 0; i < updown.length; i++) {
            if(updown[i].getBackground()==Color.RED && pushed[i]==0)
                pushed[i] = 1;
        }
    }
}
