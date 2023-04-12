import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class InterfazBrowser extends JFrame {
    private JPanel Panel;
    private JTextArea AreaTexto;
    private JButton BotonBuscar;
    private JButton BotonAtras;
    private JButton BotonAdelante;
    private JTextField TextoURL;

    private Stack<String> pilaPrincipal = new Stack<>();
    private Stack<String> pilaRespaldo = new Stack<>();


    public InterfazBrowser() {

        BotonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarURL();
                MostrarTexto();
            }
        });

        BotonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Atras();
                MostrarTexto();
            }
        });

        BotonAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Adelante();
                MostrarTexto();
            }
        });
    }

    public JPanel DarPanel(){
        return Panel;
    }

    private void AgregarURL (){
        pilaPrincipal.push(TextoURL.getText());
        pilaRespaldo.clear();
        TextoURL.setText("");
    }

    private void MostrarTexto(){
        AreaTexto.setText(pilaPrincipal.toString());
    }

    private void Atras() {
        if (pilaPrincipal.isEmpty()) {
            BotonAtras.setEnabled(false);
            return;
        } else{
            pilaRespaldo.push(pilaPrincipal.pop());
        }
        BotonAdelante.setEnabled(true);
    }

    private void Adelante(){
        if (pilaRespaldo.isEmpty()) {
            BotonAdelante.setEnabled(false);
            return;
        }else {
            pilaPrincipal.push(pilaRespaldo.pop());
        }
        BotonAtras.setEnabled(true);
    }
}

