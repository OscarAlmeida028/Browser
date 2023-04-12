import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfazBrowser interfaz = new InterfazBrowser();
                interfaz.setContentPane(interfaz.DarPanel());
                interfaz.setTitle("Browser");
                interfaz.setBounds(500,500,500,500);
                interfaz.setVisible(true);
                interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}