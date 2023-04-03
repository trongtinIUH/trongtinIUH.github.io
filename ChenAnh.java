package nghienCuu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
public class ChenAnh {
 
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
 
    public ChenAnh(){
       prepareGUI();
    }
 
    public static void main(String[] args) {
        ChenAnh swingControlDemo = new ChenAnh();
        swingControlDemo.showImageIconDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame("Vi du ImageIcon - Java Swing");
        mainFrame.setSize(1000, 2000);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(1000, 1000);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
 
    private void showImageIconDemo() {
        headerLabel.setText("Control in action: ImageIcon");
        ImageIcon icon = new ImageIcon("D:/Code_JavaJF/src/dhktpm17c_tuan4/matcuoi.png", "Lock");
        JLabel commentlabel = new JLabel("This is lock icon", icon, JLabel.CENTER);
        
       
        controlPanel.add(commentlabel);
        mainFrame.setVisible(true);
    }
}
