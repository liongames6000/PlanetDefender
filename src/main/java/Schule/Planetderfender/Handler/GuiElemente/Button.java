package Schule.Planetderfender.Handler.GuiElemente;
//NICHT FERTIG NUR ZUM TEST//
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Button extends JFrame implements ActionListener {

    private static final long serialVersionUID = 6813784118231602778L;
    private int zahl = 0;
    private JButton dec, inc, close;
    private JLabel anzeigerZahl = new JLabel(Integer.toString(zahl));

    public Button(){
        this.setTitle("JButton im JFrame");
        this.setBounds(100, 100, 300, 200);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        Container pane = this.getContentPane();

        // Das Label packe ich auf in mein BorderLayout
        pane.add(anzeigerZahl, BorderLayout.CENTER);

        // Button fürs Runterzählen
        this.dec = new JButton("dec");
        this.dec.setActionCommand("dec");
        this.dec.addActionListener(this);
        pane.add(this.dec, BorderLayout.LINE_START);

        // Button fürs rauszählen
        this.inc = new JButton("inc");
        this.inc.setActionCommand("inc");
        this.inc.addActionListener(this);
        pane.add(this.inc, BorderLayout.LINE_END);

        this.close = new JButton("Programm schließen");
        this.close.setActionCommand("close");
        this.close.addActionListener(this);
        pane.add(this.close, BorderLayout.PAGE_END);

        // Zum Vorführen baue ich noch eine JMenuBar
        JMenuBar menu = new JMenuBar();
        JMenu hier = new JMenu("Hier");
        JMenuItem exit = new JMenuItem("schließen");
        exit.setActionCommand("close");
        exit.addActionListener(this);
        hier.add(exit);
        menu.add(hier);
        this.setJMenuBar(menu);
    }

    @Override
    public void actionPerformed(ActionEvent action) {

        String ac =  action.getActionCommand().toString().toLowerCase();
        if(ac.equals("DEC")){
            this.zahl = zahl - 1;
            this.anzeigerZahl.setText(Integer.toString(this.zahl));
        }
        if(ac.equals("INC")){
            this.zahl = zahl + 1;
            this.anzeigerZahl.setText(Integer.toString(this.zahl));
        }
        if(ac.equalsIgnoreCase("close")){
            System.exit(0);
        }
    }
}