import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Itx1300Quiz  extends JFrame implements ActionListener   {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    Itx1300Quiz(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Which one among these is not a car brand?");
            jb[0].setText("Nissan");
            jb[1].setText("Suzuki");
            jb[2].setText("Toyota");
            jb[3].setText("Cherry");
        }
        if (current == 1) {
            l.setText("Que2: Which car has the highest horsepower among these?");
            jb[0].setText("Patrol");
            jb[1].setText("GTR");
            jb[2].setText("Corolla");
            jb[3].setText("Qx50");
        }
        if (current == 2) {
            l.setText("Que3: Which car has panaromic view ?");
            jb[0].setText("RollsRoyce");
            jb[1].setText("Mercedes benz");
            jb[2].setText("BMW");
            jb[3].setText("Koeniggseg");
        }
        if (current == 3) {
            l.setText("Que4: Which car comes in with a refrigerator ?");
            jb[0].setText("LandCruiser");
            jb[1].setText("Infinityqx50");
            jb[2].setText("corolla");
            jb[3].setText("none of the above");
        }
        if (current == 4) {
            l.setText("Que5: Where is Middlesex university dubai located?");
            jb[0].setText("Knowledge park");
            jb[1].setText("Al qusais");
            jb[2].setText("Al quoz");
            jb[3].setText("Downtown");
        }
        if (current == 5) {
            l.setText("Que6: How many blocks does Middlesex university have?");
            jb[0].setText("five");
            jb[1].setText("six");
            jb[2].setText("dont know");
            jb[3].setText("eight");
        }
        if (current == 6) {
            l.setText("Que7: How many libraries does block sixteen have? ");
            jb[0].setText("one only");
            jb[1].setText("two");
            jb[2].setText("three");
            jb[3].setText("none");
        }
        if (current == 7) {
            l.setText("Que8: How far is metro station from Middlesex university dubai?");
            jb[0].setText("walking distance");
            jb[1].setText("need a cab");
            jb[2].setText("really near");
            jb[3].setText("i dont know");
        }
        if (current == 8) {
            l.setText("Que9: where is the tram located near Middlesex university?");
            jb[0].setText("near block 2b");
            jb[1].setText("i dont know");
            jb[2].setText("near block16");
            jb[3].setText("none of the above");
        }
        if (current == 9) {
            l.setText("Que10: Which one among these is not a bike company?");
            jb[0].setText("suzuki");
            jb[1].setText("toyota");
            jb[2].setText("infinity");
            jb[3].setText("none of the above");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[3].isSelected());
        if (current == 3)
            return (jb[0].isSelected());
        if (current == 4)
            return (jb[2].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[1].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[1].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new Itx1300Quiz("Itx1300Quiz of Java");
    }
}