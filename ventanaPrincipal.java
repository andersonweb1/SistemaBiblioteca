import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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

    private void configurarEventos() {

        btnAgregar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        btnMostrarTodos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mostrarTodos();
            }
        });

        btnFiltrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                filtrarPorAutor();
            }
        });
    }

    private void agregarLibro() {

        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String isbn = txtIsbn.getText().trim();
        String genero = txtGenero.getText().trim();
        String anioTexto = txtAnio.getText().trim();
        String copiasTexto = txtCopias.getText().trim();

        if (titulo.isEmpty() || autor.isEmpty() || isbn.isEmpty() || genero.isEmpty() || anioTexto.isEmpty() || copiasTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this, "Todos los campos son obligatorios."
            );

            return;
        }

        try {

            int anio = Integer.parseInt(anioTexto);
            int copias = Integer.parseInt(copiasTexto);

            int anioActual = java.time.Year.now().getValue();

            if (anio > anioActual) {

                JOptionPane.showMessageDialog(
                        this, "El año no puede ser mayor al año actual."
                );

                return;
            }

            if (copias < 0) {

                JOptionPane.showMessageDialog(
                        this, "Las copias no pueden ser negativas."
                );

                return;
            }

            Libro nuevoLibro = new Libro(titulo, autor, isbn, genero, anio, copias
            );

            biblioteca.agregarLibro(nuevoLibro);

            JOptionPane.showMessageDialog(
                    this, "Libro agregado correctamente."
            );

            limpiarCampos();

            mostrarTodos();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this, "El año y las copias deben ser números enteros."
            );

        } catch (IllegalArgumentException ex) {

            JOptionPane.showMessageDialog(
                    this, ex.getMessage()
            );
        }
    }

    private void mostrarTodos() {

        ArrayList<Libro> libros = biblioteca.obtenerTodos();

        actualizarTabla(libros);
    }

    private void filtrarPorAutor() {

        String autor = txtBuscarAutor.getText().trim();

        if (autor.isEmpty()) {

            mostrarTodos();
            return;
        }

        ArrayList<Libro> resultados =
                biblioteca.filtrarPorAutor(autor);

        actualizarTabla(resultados);
    }

    private void actualizarTabla(ArrayList<Libro> libros) {

        modeloTabla.setRowCount(0);

        for (Libro libro : libros) {

            Object[] fila = {
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getIsbn(),
                    libro.getGenero(),
                    libro.getAnioPublicacion(),
                    libro.getCopiasDisponibles()
            };

            modeloTabla.addRow(fila);
        }
    }


