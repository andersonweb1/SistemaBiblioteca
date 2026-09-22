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

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 5, 5)

        );

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtIsbn = new JTextField();
        txtGenero = new JTextField();
        txtAnio = new JTextField();
        txtCopias = new JTextField();

        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("ISBN / Código:"));
        panelFormulario.add(txtIsbn);

        panelFormulario.add(new JLabel("Género:"));
        panelFormulario.add(txtGenero);

        panelFormulario.add(new JLabel("Año de publicación:"));
        panelFormulario.add(txtAnio);

        panelFormulario.add(new JLabel("Copias disponibles:"));
        panelFormulario.add(txtCopias);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();

        btnAgregar = new JButton("Agregar libro");
        btnEliminar = new JButton("Eliminar libro");
        btnMostrarTodos = new JButton("Mostrar todos");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrarTodos);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        JPanel panelBusqueda = new JPanel();

        txtBuscarAutor = new JTextField(20);
        btnFiltrar = new JButton("Filtrar por autor");

        panelBusqueda.add(new JLabel("Buscar autor:"));
        panelBusqueda.add(txtBuscarAutor);
        panelBusqueda.add(btnFiltrar);

        panelPrincipal.add(panelBusqueda, BorderLayout.SOUTH);

        crearTabla(panelPrincipal);

        configurarEventos();

        add(panelPrincipal);
    }

    private void crearTabla(JPanel panelPrincipal) {

        String[] columnas = {"Título", "Autor", "ISBN", "Género", "Año", "Copias"
        
        };

        modeloTabla = new DefaultTableModel(columnas, 0);

        tabla = new JTable(modeloTabla);

        JScrollPane scroll = new JScrollPane(tabla);

        panelPrincipal.add(scroll, BorderLayout.EAST);
    }

