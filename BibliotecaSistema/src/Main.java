import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ventanaPrincipal ventana = new ventanaPrincipal();

            ventana.setVisible(true);
        });
    }
}