public class VentanaPrincipal extends JFrame {

    private Biblioteca biblioteca;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtIsbn;
    private JTextField txtGenero;
    private JTextField txtAnio;
    private JTextField txtCopias;
    private JTextField txtBuscarAutor;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnMostrarTodos;
    private JButton btnFiltrar;

    public VentanaPrincipal() {

        biblioteca = new Biblioteca();

        configurarVentana();
        crearInterfaz();
    }

    private void configurarVentana() {

        setTitle("Sistema de Gestión de Biblioteca");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private void crearInterfaz() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        JPanel panelFormulario = new JPanel(
                new GridLayout(6, 2, 5, 5)
        );



