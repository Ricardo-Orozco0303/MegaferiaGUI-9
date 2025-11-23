/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package core.views;

import core.controllers.ResponseProcessor;
import core.controllers.dto.AuthorRankingDto;
import core.controllers.dto.BookCreationRequest;
import core.controllers.dto.BookTableDto;
import core.controllers.dto.BookType;
import core.controllers.dto.PersonCreationRequest;
import core.controllers.dto.PersonRole;
import core.controllers.dto.PersonTableDto;
import core.controllers.dto.PublisherCreationRequest;
import core.controllers.dto.PublisherTableDto;
import core.controllers.dto.SelectionOptionDto;
import core.controllers.dto.StandCreationRequest;
import core.controllers.dto.StandPurchaseRequest;
import core.controllers.dto.StandTableDto;
import core.controllers.handlers.ErrorHandler;
import core.controllers.handlers.FormHandler;
import core.controllers.handlers.MessageHandler;
import core.controllers.handlers.SelectionHandler;
import core.controllers.handlers.RefreshDataHandler;
import core.controllers.interfaces.IBookController;
import core.controllers.interfaces.IPersonController;
import core.controllers.interfaces.IPublisherController;
import core.controllers.interfaces.IPurchaseController;
import core.controllers.interfaces.IQueryController;
import core.controllers.interfaces.IStandController;
import core.controllers.utils.Response;
import core.controllers.utils.ResponseKeys;
import core.observer.DataChangeEvent;
import core.observer.DataChangeNotifier;
import core.observer.DataChangeType;
import core.observer.IObserver;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jjlora
 * @author edangulo
 */
public class MegaferiaFrame extends javax.swing.JFrame implements IObserver {

    private final IStandController standController;
    private final IPersonController personController;
    private final IPublisherController publisherController;
    private final IBookController bookController;
    private final IPurchaseController purchaseController;
    private final IQueryController queryController;
    private final DataChangeNotifier notifier;

    private final Set<String> selectedAuthorIds = new LinkedHashSet<>();
    private final Set<String> selectedStandIds = new LinkedHashSet<>();
    private final Set<String> selectedPublisherNits = new LinkedHashSet<>();

    private List<SelectionOptionDto> authorOptions = new ArrayList<>();
    private List<SelectionOptionDto> managerOptions = new ArrayList<>();
    private List<SelectionOptionDto> narratorOptions = new ArrayList<>();
    private List<SelectionOptionDto> publisherOptions = new ArrayList<>();
    private List<SelectionOptionDto> standOptions = new ArrayList<>();

    private final ButtonGroup bookTypeGroup = new ButtonGroup();
    private final MessageHandler messageHandler;
    private final ErrorHandler errorHandler;
    private final FormHandler formHandler;
    private final RefreshDataHandler refreshDataHandler;
    private final SelectionHandler selectionHandler;
    private final ResponseProcessor responseProcessor;

    /**
     * Creates new form MegaferiaFrame
     */
    public MegaferiaFrame(
            IStandController standController,
            IPersonController personController,
            IPublisherController publisherController,
            IBookController bookController,
            IPurchaseController purchaseController,
            IQueryController queryController,
            DataChangeNotifier notifier,
            ErrorHandler errorHandler,
            MessageHandler messageHandler,
            FormHandler formHandler,
            RefreshDataHandler refreshDataHandler,
            ResponseProcessor responseProcessor,
            SelectionHandler selectionHandler) {
        this.standController = standController;
        this.personController = personController;
        this.publisherController = publisherController;
        this.bookController = bookController;
        this.purchaseController = purchaseController;
        this.queryController = queryController;
        this.notifier = notifier;
        this.notifier.addObserver(this);
        this.errorHandler = errorHandler;
        this.messageHandler = messageHandler;
        this.formHandler = formHandler;
        this.refreshDataHandler = refreshDataHandler;
        this.responseProcessor = responseProcessor;
        this.selectionHandler = selectionHandler;
        initComponents();
        setLocationRelativeTo(null);
        configureRadioButtons();
        loadInitialCombos();
        registerRefreshTasks();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tabbedModuloPrincipal = new javax.swing.JTabbedPane();
        panelStand = new javax.swing.JPanel();
        lblPrecioStand = new javax.swing.JLabel();
        lblIdStand = new javax.swing.JLabel();
        txtStandPrice = new javax.swing.JTextField();
        txtStandId = new javax.swing.JTextField();
        btnRegistrarStand = new javax.swing.JButton();
        panelPersona = new javax.swing.JPanel();
        lblNombrePersona = new javax.swing.JLabel();
        lblIdPersona = new javax.swing.JLabel();
        txtPersonId = new javax.swing.JTextField();
        txtPersonName = new javax.swing.JTextField();
        btnRegistrarAutor = new javax.swing.JButton();
        txtPersonLastName = new javax.swing.JTextField();
        lblApellidoPersona = new javax.swing.JLabel();
        btnRegistrarGerente = new javax.swing.JButton();
        btnRegistrarNarrador = new javax.swing.JButton();
        panelEditorial = new javax.swing.JPanel();
        lblNitEditorial = new javax.swing.JLabel();
        txtPublisherNit = new javax.swing.JTextField();
        txtPublisherName = new javax.swing.JTextField();
        lblNombreEditorial = new javax.swing.JLabel();
        lblDireccionEditorial = new javax.swing.JLabel();
        txtPublisherAddress = new javax.swing.JTextField();
        btnRegistrarEditorial = new javax.swing.JButton();
        lblGerenteEditorial = new javax.swing.JLabel();
        cmbGerenteEditorial = new javax.swing.JComboBox<>();
        panelLibro = new javax.swing.JPanel();
        lblTituloLibro = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        lblAutoresLibro = new javax.swing.JLabel();
        lblIsbnLibro = new javax.swing.JLabel();
        txtBookIsbn = new javax.swing.JTextField();
        lblGeneroLibro = new javax.swing.JLabel();
        cmbGeneroLibro = new javax.swing.JComboBox<>();
        btnRegistrarLibro = new javax.swing.JButton();
        cmbAutoresDisponibles = new javax.swing.JComboBox<>();
        lblTipoLibro = new javax.swing.JLabel();
        rbtnLibroImpreso = new javax.swing.JRadioButton();
        rbtnLibroDigital = new javax.swing.JRadioButton();
        rbtnLibroAudio = new javax.swing.JRadioButton();
        lblFormatoLibro = new javax.swing.JLabel();
        cmbFormatoLibro = new javax.swing.JComboBox<>();
        lblValorLibro = new javax.swing.JLabel();
        txtBookPrice = new javax.swing.JTextField();
        lblEditorialLibro = new javax.swing.JLabel();
        cmbEditorialLibro = new javax.swing.JComboBox<>();
        lblCopiasLibro = new javax.swing.JLabel();
        txtCopiasLibro = new javax.swing.JTextField();
        lblPaginasLibro = new javax.swing.JLabel();
        txtPaginasLibro = new javax.swing.JTextField();
        lblHipervinculoLibro = new javax.swing.JLabel();
        txtHipervinculoLibro = new javax.swing.JTextField();
        txtDuracionLibro = new javax.swing.JTextField();
        lblDuracionLibro = new javax.swing.JLabel();
        lblNarradorLibro = new javax.swing.JLabel();
        cmbNarradoresLibro = new javax.swing.JComboBox<>();
        btnAgregarAutorLibro = new javax.swing.JButton();
        btnEliminarAutorLibro = new javax.swing.JButton();
        scrollAutoresLibro = new javax.swing.JScrollPane();
        txaAutoresLibro = new javax.swing.JTextArea();
        panelCompraStand = new javax.swing.JPanel();
        cmbStandCompra = new javax.swing.JComboBox<>();
        cmbEditorialCompra = new javax.swing.JComboBox<>();
        lblEditorialesCompra = new javax.swing.JLabel();
        lblStandsCompra = new javax.swing.JLabel();
        btnAgregarEditorialCompra = new javax.swing.JButton();
        btnConfirmarCompraStand = new javax.swing.JButton();
        btnEliminarEditorialCompra = new javax.swing.JButton();
        scrollEditorialesCompra = new javax.swing.JScrollPane();
        txaEditorialesCompra = new javax.swing.JTextArea();
        btnAgregarStandCompra = new javax.swing.JButton();
        btnEliminarStandCompra = new javax.swing.JButton();
        scrollStandsCompra = new javax.swing.JScrollPane();
        txaStandsCompra = new javax.swing.JTextArea();
        panelTablaEditoriales = new javax.swing.JPanel();
        scrollTablaEditoriales = new javax.swing.JScrollPane();
        tblEditoriales = new javax.swing.JTable();
        btnActualizarTablaEditoriales = new javax.swing.JButton();
        panelTablaPersonas = new javax.swing.JPanel();
        scrollTablaPersonas = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnActualizarTablaPersonas = new javax.swing.JButton();
        panelTablaStands = new javax.swing.JPanel();
        scrollTablaStands = new javax.swing.JScrollPane();
        tblStands = new javax.swing.JTable();
        btnActualizarTablaStands = new javax.swing.JButton();
        panelTablaLibros = new javax.swing.JPanel();
        scrollTablaLibros = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnFiltrarLibrosPorTipo = new javax.swing.JButton();
        cmbFiltroTipoLibro = new javax.swing.JComboBox<>();
        lblFiltroTipoLibros = new javax.swing.JLabel();
        panelConsultas = new javax.swing.JPanel();
        lblConsultasTitulo = new javax.swing.JLabel();
        cmbFiltroAutor = new javax.swing.JComboBox<>();
        lblConsultaAutor = new javax.swing.JLabel();
        btnBuscarLibrosPorAutor = new javax.swing.JButton();
        scrollTablaConsultasLibros = new javax.swing.JScrollPane();
        tblConsultasLibros = new javax.swing.JTable();
        lblConsultaFormato = new javax.swing.JLabel();
        cmbFiltroFormato = new javax.swing.JComboBox<>();
        btnBuscarLibrosPorFormato = new javax.swing.JButton();
        lblAutoresDestacadosTitulo = new javax.swing.JLabel();
        scrollTablaAutoresDestacados = new javax.swing.JScrollPane();
        tblAutoresDestacados = new javax.swing.JTable();
        btnBuscarAutoresDestacados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelStand.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrecioStand.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblPrecioStand.setText("Precio");
        panelStand.add(lblPrecioStand, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        lblIdStand.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblIdStand.setText("ID");
        panelStand.add(lblIdStand, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        txtStandPrice.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtStandPrice.setToolTipText("");
        txtStandPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStandPriceActionPerformed(evt);
            }
        });
        panelStand.add(txtStandPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 150, 30));

        txtStandId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtStandId.setToolTipText("");
        txtStandId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStandIdActionPerformed(evt);
            }
        });
        panelStand.add(txtStandId, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 150, 30));

        btnRegistrarStand.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarStand.setText("Crear");
        btnRegistrarStand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarStandActionPerformed(evt);
            }
        });
        panelStand.add(btnRegistrarStand, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 90, 40));

        tabbedModuloPrincipal.addTab("Stand", panelStand);

        lblNombrePersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombrePersona.setText("Nombre");

        lblIdPersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblIdPersona.setText("ID");

        txtPersonId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPersonId.setToolTipText("");
        txtPersonId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonIdActionPerformed(evt);
            }
        });

        txtPersonName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPersonName.setToolTipText("");
        txtPersonName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonNameActionPerformed(evt);
            }
        });

        btnRegistrarAutor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarAutor.setText("Crear Autor");
        btnRegistrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAutorActionPerformed(evt);
            }
        });

        txtPersonLastName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPersonLastName.setToolTipText("");
        txtPersonLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPersonLastNameActionPerformed(evt);
            }
        });

        lblApellidoPersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblApellidoPersona.setText("Apellido");

        btnRegistrarGerente.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarGerente.setText("Crear Gerente");
        btnRegistrarGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarGerenteActionPerformed(evt);
            }
        });

        btnRegistrarNarrador.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarNarrador.setText("Crear Narrador");
        btnRegistrarNarrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNarradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPersonaLayout = new javax.swing.GroupLayout(panelPersona);
        panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(
            panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonaLayout.createSequentialGroup()
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonaLayout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPersonaLayout.createSequentialGroup()
                                .addComponent(lblApellidoPersona)
                                .addGap(21, 21, 21)
                                .addComponent(txtPersonLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPersonaLayout.createSequentialGroup()
                                    .addComponent(lblIdPersona)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPersonId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPersonaLayout.createSequentialGroup()
                                    .addComponent(lblNombrePersona)
                                    .addGap(21, 21, 21)
                                    .addComponent(txtPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelPersonaLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnRegistrarAutor)
                        .addGap(56, 56, 56)
                        .addComponent(btnRegistrarGerente)
                        .addGap(54, 54, 54)
                        .addComponent(btnRegistrarNarrador)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        panelPersonaLayout.setVerticalGroup(
            panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonaLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPersona)
                    .addComponent(txtPersonId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombrePersona)
                    .addComponent(txtPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoPersona)
                    .addComponent(txtPersonLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarNarrador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        tabbedModuloPrincipal.addTab("Persona", panelPersona);

        lblNitEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNitEditorial.setText("NIT");

        txtPublisherNit.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPublisherNit.setToolTipText("");
        txtPublisherNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherNitActionPerformed(evt);
            }
        });

        txtPublisherName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPublisherName.setToolTipText("");
        txtPublisherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherNameActionPerformed(evt);
            }
        });

        lblNombreEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombreEditorial.setText("Nombre");

        lblDireccionEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDireccionEditorial.setText("Dirección");

        txtPublisherAddress.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPublisherAddress.setToolTipText("");
        txtPublisherAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherAddressActionPerformed(evt);
            }
        });

        btnRegistrarEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarEditorial.setText("Crear");
        btnRegistrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEditorialActionPerformed(evt);
            }
        });

        lblGerenteEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblGerenteEditorial.setText("Gerente");

        cmbGerenteEditorial.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbGerenteEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione un gerente...") }));

        javax.swing.GroupLayout panelEditorialLayout = new javax.swing.GroupLayout(panelEditorial);
        panelEditorial.setLayout(panelEditorialLayout);
        panelEditorialLayout.setHorizontalGroup(
            panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorialLayout.createSequentialGroup()
                .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditorialLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccionEditorial)
                            .addComponent(lblNitEditorial)
                            .addComponent(lblNombreEditorial)
                            .addComponent(lblGerenteEditorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPublisherNit)
                            .addComponent(txtPublisherName)
                            .addComponent(txtPublisherAddress)
                            .addComponent(cmbGerenteEditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEditorialLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(285, Short.MAX_VALUE))
        );
        panelEditorialLayout.setVerticalGroup(
            panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorialLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditorialLayout.createSequentialGroup()
                        .addComponent(lblNitEditorial)
                        .addGap(15, 15, 15)
                        .addComponent(lblNombreEditorial)
                        .addGap(20, 20, 20)
                        .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccionEditorial)
                            .addComponent(txtPublisherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEditorialLayout.createSequentialGroup()
                        .addComponent(txtPublisherNit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtPublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbGerenteEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGerenteEditorial))
                .addGap(46, 46, 46)
                .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        tabbedModuloPrincipal.addTab("Editorial", panelEditorial);

        lblTituloLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTituloLibro.setText("Titulo");

        txtBookTitle.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtBookTitle.setToolTipText("");
        txtBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookTitleActionPerformed(evt);
            }
        });

        lblAutoresLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblAutoresLibro.setText("Autores");

        lblIsbnLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblIsbnLibro.setText("ISBN");

        txtBookIsbn.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtBookIsbn.setToolTipText("");
        txtBookIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookIsbnActionPerformed(evt);
            }
        });

        lblGeneroLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblGeneroLibro.setText("Genero");

        cmbGeneroLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbGeneroLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno...", "Fantasía urbana", "Ciencia ficción distópica", "Realismo mágico", "Romance histórico", "Thriller psicológico", "Ficción filosófica", "Aventura steampunk", "Terror gótico", "No ficción narrativa", "Ficción postapocalíptica" }));

        btnRegistrarLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegistrarLibro.setText("Crear");
        btnRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLibroActionPerformed(evt);
            }
        });

        cmbAutoresDisponibles.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbAutoresDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione un autor...") }));

        lblTipoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTipoLibro.setText("Tipo");

        rbtnLibroImpreso.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rbtnLibroImpreso.setText("Impreso");
        rbtnLibroImpreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLibroImpresoActionPerformed(evt);
            }
        });

        rbtnLibroDigital.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rbtnLibroDigital.setText("Digital");
        rbtnLibroDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLibroDigitalActionPerformed(evt);
            }
        });

        rbtnLibroAudio.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        rbtnLibroAudio.setText("Audio Libro");
        rbtnLibroAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLibroAudioActionPerformed(evt);
            }
        });

        lblFormatoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFormatoLibro.setText("Formato");

        cmbFormatoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbFormatoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno..." }));

        lblValorLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblValorLibro.setText("Valor");

        txtBookPrice.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtBookPrice.setToolTipText("");
        txtBookPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookPriceActionPerformed(evt);
            }
        });

        lblEditorialLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblEditorialLibro.setText("Editorial");

        cmbEditorialLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbEditorialLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione una editorial...") }));

        lblCopiasLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCopiasLibro.setText("Nro. Ejemplares");

        txtCopiasLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtCopiasLibro.setToolTipText("");
        txtCopiasLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCopiasLibroActionPerformed(evt);
            }
        });

        lblPaginasLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblPaginasLibro.setText("Nro. Paginas");

        txtPaginasLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtPaginasLibro.setToolTipText("");
        txtPaginasLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaginasLibroActionPerformed(evt);
            }
        });

        lblHipervinculoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblHipervinculoLibro.setText("Hipervinculo");

        txtHipervinculoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtHipervinculoLibro.setToolTipText("");
        txtHipervinculoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHipervinculoLibroActionPerformed(evt);
            }
        });

        txtDuracionLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txtDuracionLibro.setToolTipText("");
        txtDuracionLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionLibroActionPerformed(evt);
            }
        });

        lblDuracionLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDuracionLibro.setText("Duracion");

        lblNarradorLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNarradorLibro.setText("Narrador");

        cmbNarradoresLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbNarradoresLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione un narrador...") }));

        btnAgregarAutorLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAgregarAutorLibro.setText("Agregar Autor");
        btnAgregarAutorLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutorLibroActionPerformed(evt);
            }
        });

        btnEliminarAutorLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnEliminarAutorLibro.setText("Eliminar Autor");
        btnEliminarAutorLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAutorLibroActionPerformed(evt);
            }
        });

        txaAutoresLibro.setColumns(20);
        txaAutoresLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaAutoresLibro.setRows(5);
        txaAutoresLibro.setEnabled(false);
        scrollAutoresLibro.setViewportView(txaAutoresLibro);

        javax.swing.GroupLayout panelLibroLayout = new javax.swing.GroupLayout(panelLibro);
        panelLibro.setLayout(panelLibroLayout);
        panelLibroLayout.setHorizontalGroup(
            panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibroLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(btnRegistrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLibroLayout.createSequentialGroup()
                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCopiasLibro)
                            .addComponent(lblPaginasLibro))
                        .addGap(20, 20, 20)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCopiasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaginasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(lblHipervinculoLibro)
                        .addGap(16, 16, 16)
                        .addComponent(txtHipervinculoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNarradorLibro)
                            .addComponent(lblDuracionLibro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNarradoresLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLibroLayout.createSequentialGroup()
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIsbnLibro)
                                    .addComponent(lblTituloLibro)
                                    .addComponent(lblAutoresLibro)
                                    .addComponent(lblGeneroLibro)
                                    .addComponent(lblTipoLibro)
                                    .addComponent(lblFormatoLibro)
                                    .addComponent(lblValorLibro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLibroLayout.createSequentialGroup()
                                        .addComponent(txtBookPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelLibroLayout.createSequentialGroup()
                                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cmbFormatoLibro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLibroLayout.createSequentialGroup()
                                                    .addComponent(rbtnLibroImpreso)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rbtnLibroDigital)))
                                            .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtBookTitle)
                                                .addComponent(txtBookIsbn)
                                                .addComponent(cmbGeneroLibro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbAutoresDisponibles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(28, 28, 28)
                                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rbtnLibroAudio)
                                            .addComponent(btnEliminarAutorLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAgregarAutorLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(scrollAutoresLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
                            .addGroup(panelLibroLayout.createSequentialGroup()
                                .addComponent(lblEditorialLibro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEditorialLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelLibroLayout.setVerticalGroup(
            panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLibroLayout.createSequentialGroup()
                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLibroLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTituloLibro)
                                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAutoresLibro)
                                    .addComponent(cmbAutoresDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblIsbnLibro)
                                    .addComponent(txtBookIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGeneroLibro)
                                    .addComponent(cmbGeneroLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelLibroLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnAgregarAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarAutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoLibro)
                            .addComponent(rbtnLibroImpreso)
                            .addComponent(rbtnLibroDigital)
                            .addComponent(rbtnLibroAudio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormatoLibro)
                            .addComponent(cmbFormatoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorLibro)
                            .addComponent(txtBookPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEditorialLibro)
                            .addComponent(cmbEditorialLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(scrollAutoresLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCopiasLibro)
                            .addComponent(lblHipervinculoLibro)
                            .addComponent(txtHipervinculoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblPaginasLibro))
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addComponent(txtPaginasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCopiasLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDuracionLibro)))
                    .addGroup(panelLibroLayout.createSequentialGroup()
                        .addGroup(panelLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNarradorLibro)
                            .addComponent(cmbNarradoresLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtDuracionLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnRegistrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        tabbedModuloPrincipal.addTab("Libro", panelLibro);

        cmbStandCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbStandCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione un stand...") }));

        cmbEditorialCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbEditorialCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione una editorial...") }));

        lblEditorialesCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblEditorialesCompra.setText("Editoriales");

        lblStandsCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblStandsCompra.setText("ID Stands");

        btnAgregarEditorialCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAgregarEditorialCompra.setText("Agregar Editorial");
        btnAgregarEditorialCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditorialCompraActionPerformed(evt);
            }
        });

        btnConfirmarCompraStand.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnConfirmarCompraStand.setText("Comprar");
        btnConfirmarCompraStand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCompraStandActionPerformed(evt);
            }
        });

        btnEliminarEditorialCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnEliminarEditorialCompra.setText("Eliminar Editorial");
        btnEliminarEditorialCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEditorialCompraActionPerformed(evt);
            }
        });

        txaEditorialesCompra.setColumns(20);
        txaEditorialesCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaEditorialesCompra.setRows(5);
        txaEditorialesCompra.setEnabled(false);
        scrollEditorialesCompra.setViewportView(txaEditorialesCompra);

        btnAgregarStandCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAgregarStandCompra.setText("Agregar Stand");
        btnAgregarStandCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarStandCompraActionPerformed(evt);
            }
        });

        btnEliminarStandCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnEliminarStandCompra.setText("Eliminar Stand");
        btnEliminarStandCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarStandCompraActionPerformed(evt);
            }
        });

        txaStandsCompra.setColumns(20);
        txaStandsCompra.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txaStandsCompra.setRows(5);
        txaStandsCompra.setEnabled(false);
        scrollStandsCompra.setViewportView(txaStandsCompra);

        javax.swing.GroupLayout panelCompraStandLayout = new javax.swing.GroupLayout(panelCompraStand);
        panelCompraStand.setLayout(panelCompraStandLayout);
        panelCompraStandLayout.setHorizontalGroup(
            panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraStandLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraStandLayout.createSequentialGroup()
                        .addComponent(btnConfirmarCompraStand)
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompraStandLayout.createSequentialGroup()
                        .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollEditorialesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCompraStandLayout.createSequentialGroup()
                                .addComponent(lblEditorialesCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEditorialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarEditorialCompra)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarEditorialCompra)))
                        .addGap(189, 189, 189))))
            .addGroup(panelCompraStandLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblStandsCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbStandCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollStandsCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCompraStandLayout.createSequentialGroup()
                        .addComponent(btnAgregarStandCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarStandCompra)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCompraStandLayout.setVerticalGroup(
            panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompraStandLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompraStandLayout.createSequentialGroup()
                        .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStandsCompra)
                            .addComponent(cmbStandCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(226, 226, 226)
                        .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEditorialesCompra)
                            .addComponent(cmbEditorialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCompraStandLayout.createSequentialGroup()
                        .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarStandCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarStandCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollStandsCompra)
                        .addGap(8, 8, 8)
                        .addGroup(panelCompraStandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarEditorialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarEditorialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollEditorialesCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmarCompraStand, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        tabbedModuloPrincipal.addTab("Comprar Stand", panelCompraStand);

        tblEditoriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIT", "Nombre", "Dirección", "Nombre Gerente", "Nro. Stands"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaEditoriales.setViewportView(tblEditoriales);

        btnActualizarTablaEditoriales.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnActualizarTablaEditoriales.setText("Consultar");
        btnActualizarTablaEditoriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaEditorialesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaEditorialesLayout = new javax.swing.GroupLayout(panelTablaEditoriales);
        panelTablaEditoriales.setLayout(panelTablaEditorialesLayout);
        panelTablaEditorialesLayout.setHorizontalGroup(
            panelTablaEditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEditorialesLayout.createSequentialGroup()
                .addGroup(panelTablaEditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaEditorialesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scrollTablaEditoriales, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaEditorialesLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnActualizarTablaEditoriales)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelTablaEditorialesLayout.setVerticalGroup(
            panelTablaEditorialesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEditorialesLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollTablaEditoriales, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarTablaEditoriales, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        tabbedModuloPrincipal.addTab("Show Editoriales", panelTablaEditoriales);

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Completo", "Tipo", "Editorial", "Nro. Libros"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaPersonas.setViewportView(tblPersonas);

        btnActualizarTablaPersonas.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnActualizarTablaPersonas.setText("Consultar");
        btnActualizarTablaPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaPersonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaPersonasLayout = new javax.swing.GroupLayout(panelTablaPersonas);
        panelTablaPersonas.setLayout(panelTablaPersonasLayout);
        panelTablaPersonasLayout.setHorizontalGroup(
            panelTablaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaPersonasLayout.createSequentialGroup()
                .addGroup(panelTablaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaPersonasLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scrollTablaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaPersonasLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnActualizarTablaPersonas)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelTablaPersonasLayout.setVerticalGroup(
            panelTablaPersonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaPersonasLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollTablaPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarTablaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        tabbedModuloPrincipal.addTab("Show Personas", panelTablaPersonas);

        tblStands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Precio", "Comprado", "Editoriales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaStands.setViewportView(tblStands);

        btnActualizarTablaStands.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnActualizarTablaStands.setText("Consultar");
        btnActualizarTablaStands.setToolTipText("");
        btnActualizarTablaStands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTablaStandsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaStandsLayout = new javax.swing.GroupLayout(panelTablaStands);
        panelTablaStands.setLayout(panelTablaStandsLayout);
        panelTablaStandsLayout.setHorizontalGroup(
            panelTablaStandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaStandsLayout.createSequentialGroup()
                .addGroup(panelTablaStandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaStandsLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scrollTablaStands, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaStandsLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnActualizarTablaStands)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelTablaStandsLayout.setVerticalGroup(
            panelTablaStandsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaStandsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrollTablaStands, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarTablaStands, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        tabbedModuloPrincipal.addTab("Show Stands", panelTablaStands);

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Autores", "ISBN", "Genero", "Formato", "Valor", "Editorial", "Nro. Ejem", "Nro. Pag", "URL", "Narrador", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaLibros.setViewportView(tblLibros);

        btnFiltrarLibrosPorTipo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnFiltrarLibrosPorTipo.setText("Consultar");
        btnFiltrarLibrosPorTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarLibrosPorTipoActionPerformed(evt);
            }
        });

        cmbFiltroTipoLibro.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbFiltroTipoLibro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno...", "Libros Impresos", "Libros Digitales", "Audiolibros", "Todos los Libros" }));
        cmbFiltroTipoLibro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroTipoLibroItemStateChanged(evt);
            }
        });

        lblFiltroTipoLibros.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFiltroTipoLibros.setText("Libros");

        javax.swing.GroupLayout panelTablaLibrosLayout = new javax.swing.GroupLayout(panelTablaLibros);
        panelTablaLibros.setLayout(panelTablaLibrosLayout);
        panelTablaLibrosLayout.setHorizontalGroup(
            panelTablaLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLibrosLayout.createSequentialGroup()
                .addGroup(panelTablaLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLibrosLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnFiltrarLibrosPorTipo))
                    .addGroup(panelTablaLibrosLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(scrollTablaLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaLibrosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblFiltroTipoLibros)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFiltroTipoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelTablaLibrosLayout.setVerticalGroup(
            panelTablaLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLibrosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelTablaLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFiltroTipoLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFiltroTipoLibros))
                .addGap(18, 18, 18)
                .addComponent(scrollTablaLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrarLibrosPorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tabbedModuloPrincipal.addTab("Show Libros", panelTablaLibros);

        lblConsultasTitulo.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        lblConsultasTitulo.setText("Busqueda Libros");

        cmbFiltroAutor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbFiltroAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new SelectionOptionDto[] { new SelectionOptionDto("", "Seleccione un autor...") }));

        lblConsultaAutor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblConsultaAutor.setText("Autor");

        btnBuscarLibrosPorAutor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnBuscarLibrosPorAutor.setText("Consultar");
        btnBuscarLibrosPorAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibrosPorAutorActionPerformed(evt);
            }
        });

        tblConsultasLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Autores", "ISBN", "Genero", "Formato", "Valor", "Editorial", "Nro. Ejem", "Nro. Pag", "URL", "Narrador", "Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaConsultasLibros.setViewportView(tblConsultasLibros);

        lblConsultaFormato.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblConsultaFormato.setText("Formato");

        cmbFiltroFormato.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cmbFiltroFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno...", "Pasta dura", "Pasta blanda", "EPUB", "PDF", "MOBI/AZW", "MP3", "MP4", "WAV", "WMA", "Otro" }));

        btnBuscarLibrosPorFormato.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnBuscarLibrosPorFormato.setText("Consultar");
        btnBuscarLibrosPorFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibrosPorFormatoActionPerformed(evt);
            }
        });

        lblAutoresDestacadosTitulo.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        lblAutoresDestacadosTitulo.setText("Autores con más Libros en Diferentes Editoriales");

        tblAutoresDestacados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaAutoresDestacados.setViewportView(tblAutoresDestacados);

        btnBuscarAutoresDestacados.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnBuscarAutoresDestacados.setText("Consultar");
        btnBuscarAutoresDestacados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutoresDestacadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultasLayout = new javax.swing.GroupLayout(panelConsultas);
        panelConsultas.setLayout(panelConsultasLayout);
        panelConsultasLayout.setHorizontalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addComponent(lblConsultasTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addComponent(lblConsultaAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFiltroAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibrosPorAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(lblConsultaFormato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFiltroFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibrosPorFormato)
                        .addGap(40, 40, 40))))
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTablaConsultasLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelConsultasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollTablaAutoresDestacados, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAutoresDestacadosTitulo)))))
                    .addGroup(panelConsultasLayout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(btnBuscarAutoresDestacados)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelConsultasLayout.setVerticalGroup(
            panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConsultasTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultaAutor)
                    .addComponent(cmbFiltroAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibrosPorAutor)
                    .addComponent(lblConsultaFormato)
                    .addComponent(cmbFiltroFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibrosPorFormato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTablaConsultasLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAutoresDestacadosTitulo)
                .addGap(18, 18, 18)
                .addComponent(scrollTablaAutoresDestacados, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarAutoresDestacados)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tabbedModuloPrincipal.addTab("Consultas Adicionales", panelConsultas);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedModuloPrincipal)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedModuloPrincipal)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configureRadioButtons() {
        bookTypeGroup.add(rbtnLibroImpreso);
        bookTypeGroup.add(rbtnLibroDigital);
        bookTypeGroup.add(rbtnLibroAudio);
        applyBookTypeState(BookType.PRINTED);
    }

    private void applyBookTypeState(BookType type) {
        rbtnLibroImpreso.setSelected(type == BookType.PRINTED);
        rbtnLibroDigital.setSelected(type == BookType.DIGITAL);
        rbtnLibroAudio.setSelected(type == BookType.AUDIOBOOK);

        boolean isPrinted = type == BookType.PRINTED;
        boolean isDigital = type == BookType.DIGITAL;
        boolean isAudio = type == BookType.AUDIOBOOK;

        txtCopiasLibro.setEnabled(isPrinted);
        txtPaginasLibro.setEnabled(isPrinted);
        txtHipervinculoLibro.setEnabled(isDigital);
        txtDuracionLibro.setEnabled(isAudio);
        cmbNarradoresLibro.setEnabled(isAudio);

        cmbFormatoLibro.removeAllItems();
        cmbFormatoLibro.addItem("Seleccione uno...");
        if (isPrinted) {
            cmbFormatoLibro.addItem("Pasta dura");
            cmbFormatoLibro.addItem("Pasta blanda");
        } else if (isDigital) {
            cmbFormatoLibro.addItem("EPUB");
            cmbFormatoLibro.addItem("PDF");
            cmbFormatoLibro.addItem("MOBI/AZW");
            cmbFormatoLibro.addItem("Otro");
        } else if (isAudio) {
            cmbFormatoLibro.addItem("MP3");
            cmbFormatoLibro.addItem("MP4");
            cmbFormatoLibro.addItem("WAV");
            cmbFormatoLibro.addItem("WMA");
            cmbFormatoLibro.addItem("Otro");
        }
    }

    private void loadInitialCombos() {
        refreshStandOptions(false);
        refreshAuthorOptions(false);
        refreshManagerOptions(false);
        refreshNarratorOptions(false);
        refreshPublisherOptions(false);
        refreshStandTable(false);
        refreshPersonTable(false);
        refreshPublisherTable(false);
        if (cmbFiltroTipoLibro.getItemCount() > 0) {
            cmbFiltroTipoLibro.setSelectedIndex(cmbFiltroTipoLibro.getItemCount() - 1);
        }
        executeBookFilter(false);
        selectedAuthorIds.clear();
        selectedStandIds.clear();
        selectedPublisherNits.clear();
        refreshSelectedAuthorsArea();
        refreshSelectedStandsArea();
        refreshSelectedPublishersArea();
    }

    private void registerRefreshTasks() {
        refreshDataHandler.register(DataChangeType.STANDS, () -> {
            refreshStandOptions(false);
            refreshStandTable(false);
        });
        refreshDataHandler.register(DataChangeType.PERSONS, () -> {
            refreshAuthorOptions(false);
            refreshManagerOptions(false);
            refreshNarratorOptions(false);
            refreshPersonTable(false);
        });
        refreshDataHandler.register(DataChangeType.PUBLISHERS, () -> {
            refreshPublisherOptions(false);
            refreshPublisherTable(false);
        });
        refreshDataHandler.register(DataChangeType.BOOKS, () -> executeBookFilter(false));
        refreshDataHandler.register(DataChangeType.PURCHASES, () -> {
            refreshStandTable(false);
            refreshPublisherTable(false);
            refreshStandOptions(false);
            refreshPublisherOptions(false);
        });
    }

    private void refreshStandOptions(boolean notifySuccess) {
        Response response = standController.getStandOptions();
        ResponseProcessor.ProcessingResult<List<SelectionOptionDto>> result
                = processResponse(response, notifySuccess, resp -> getData(resp, ResponseKeys.OPTIONS));
        if (!result.isSuccess()) {
            return;
        }
        List<SelectionOptionDto> options = result.getData();
        standOptions = options != null ? options : new ArrayList<>();
        selectionHandler.updateCombo(cmbStandCompra, standOptions, "Seleccione un stand...");
        selectionHandler.cleanupSelections(selectedStandIds, standOptions);
        refreshSelectedStandsArea();
    }

    private void refreshAuthorOptions(boolean notifySuccess) {
        Response response = personController.getAuthorOptions();
        ResponseProcessor.ProcessingResult<List<SelectionOptionDto>> result
                = processResponse(response, notifySuccess, resp -> getData(resp, ResponseKeys.OPTIONS));
        if (!result.isSuccess()) {
            return;
        }
        List<SelectionOptionDto> options = result.getData();
        authorOptions = options != null ? options : new ArrayList<>();
        selectionHandler.updateCombo(cmbAutoresDisponibles, authorOptions, "Seleccione un autor...");
        selectionHandler.updateCombo(cmbFiltroAutor, authorOptions, "Seleccione un autor...");
        selectionHandler.cleanupSelections(selectedAuthorIds, authorOptions);
        refreshSelectedAuthorsArea();
    }

    private void refreshManagerOptions(boolean notifySuccess) {
        Response response = personController.getManagerOptions();
        ResponseProcessor.ProcessingResult<List<SelectionOptionDto>> result
                = processResponse(response, notifySuccess, resp -> getData(resp, ResponseKeys.OPTIONS));
        if (!result.isSuccess()) {
            return;
        }
        List<SelectionOptionDto> options = result.getData();
        managerOptions = options != null ? options : new ArrayList<>();
        selectionHandler.updateCombo(cmbGerenteEditorial, managerOptions, "Seleccione un gerente...");
    }

    private void refreshNarratorOptions(boolean notifySuccess) {
        Response response = personController.getNarratorOptions();
        ResponseProcessor.ProcessingResult<List<SelectionOptionDto>> result
                = processResponse(response, notifySuccess, resp -> getData(resp, ResponseKeys.OPTIONS));
        if (!result.isSuccess()) {
            return;
        }
        List<SelectionOptionDto> options = result.getData();
        narratorOptions = options != null ? options : new ArrayList<>();
        selectionHandler.updateCombo(cmbNarradoresLibro, narratorOptions, "Seleccione un narrador...");
    }

    private void refreshPublisherOptions(boolean notifySuccess) {
        Response response = publisherController.getPublisherOptions();
        ResponseProcessor.ProcessingResult<List<SelectionOptionDto>> result
                = processResponse(response, notifySuccess, resp -> getData(resp, ResponseKeys.OPTIONS));
        if (!result.isSuccess()) {
            return;
        }
        List<SelectionOptionDto> options = result.getData();
        publisherOptions = options != null ? options : new ArrayList<>();
        selectionHandler.updateCombo(cmbEditorialLibro, publisherOptions, "Seleccione una editorial...");
        selectionHandler.updateCombo(cmbEditorialCompra, publisherOptions, "Seleccione una editorial...");
        selectionHandler.cleanupSelections(selectedPublisherNits, publisherOptions);
        refreshSelectedPublishersArea();
    }

    private void refreshSelectedAuthorsArea() {
        txaAutoresLibro.setText(selectionHandler.buildSelectionText(selectedAuthorIds, authorOptions));
    }

    private void refreshSelectedStandsArea() {
        txaStandsCompra.setText(selectionHandler.buildSelectionText(selectedStandIds, standOptions));
    }

    private void refreshSelectedPublishersArea() {
        txaEditorialesCompra.setText(selectionHandler.buildSelectionText(selectedPublisherNits, publisherOptions));
    }

    private boolean handleResponse(Response response, boolean notifySuccess) {
        return responseProcessor.handle(this, response, notifySuccess);
    }

    private <T> ResponseProcessor.ProcessingResult<T> processResponse(Response response, boolean notifySuccess, java.util.function.Function<Response, T> extractor) {
        return responseProcessor.process(this, response, notifySuccess, extractor);
    }

    @SuppressWarnings("unchecked")
    private <T> T getData(Response response, String key) {
        if (response == null || response.getData() == null) {
            return null;
        }
        Object payload = response.getData();
        if (!(payload instanceof java.util.Map<?, ?> dataMap)) {
            return null;
        }
        return (T) dataMap.get(key);
    }

    private void showError(String message) {
        errorHandler.showWarning(this, message);
    }


    private void clearStandForm() {
        formHandler.resetTextFields(txtStandId, txtStandPrice);
    }

    private void clearPersonForm() {
        formHandler.resetTextFields(txtPersonId, txtPersonName, txtPersonLastName);
    }

    private void clearPublisherForm() {
        formHandler.resetTextFields(txtPublisherNit, txtPublisherName, txtPublisherAddress);
        formHandler.selectFirstOption(cmbGerenteEditorial);
    }

    private void clearBookForm() {
        formHandler.resetTextFields(
                txtBookTitle,
                txtBookIsbn,
                txtBookPrice,
                txtCopiasLibro,
                txtPaginasLibro,
                txtHipervinculoLibro,
                txtDuracionLibro
        );
        formHandler.selectFirstOption(cmbGeneroLibro);
        formHandler.selectFirstOption(cmbFormatoLibro);
        formHandler.selectFirstOption(cmbEditorialLibro);
        formHandler.selectFirstOption(cmbNarradoresLibro);
        selectedAuthorIds.clear();
        refreshSelectedAuthorsArea();
        formHandler.selectDefault(bookTypeGroup, rbtnLibroImpreso);
        applyBookTypeState(BookType.PRINTED);
    }

    private SelectionOptionDto getSelectedOption(javax.swing.JComboBox<SelectionOptionDto> combo) {
        Object selected = combo.getSelectedItem();
        if (selected instanceof SelectionOptionDto option) {
            String value = option.getValue();
            if (value != null && !value.isBlank()) {
                return option;
            }
        }
        return null;
    }

    private String getSelectedText(javax.swing.JComboBox<String> combo) {
        Object selected = combo.getSelectedItem();
        if (selected instanceof String value) {
            if (value.startsWith("Seleccione")) {
                return null;
            }
            return value;
        }
        return null;
    }

    private boolean createPerson(PersonRole role) {
        String firstName = txtPersonName.getText().trim();
        String lastName = txtPersonLastName.getText().trim();
        Response response = personController.createPerson(
                new PersonCreationRequest(txtPersonId.getText(), firstName, lastName, role)
        );
        return responseProcessor.handleAndRun(this, response, true, this::clearPersonForm);
    }

    private void populatePublisherTable(List<PublisherTableDto> rows) {
        DefaultTableModel model = (DefaultTableModel) tblEditoriales.getModel();
        model.setRowCount(0);
        if (rows == null) {
            return;
        }
        for (PublisherTableDto dto : rows) {
            model.addRow(new Object[]{
                dto.getNit(),
                dto.getName(),
                dto.getAddress(),
                dto.getManagerName(),
                dto.getStandQuantity()
            });
        }
    }

    private void populatePersonTable(List<PersonTableDto> rows) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            DefaultTableModel model = (DefaultTableModel) tblPersonas.getModel();
            model.setRowCount(0);
            if (rows != null) {
                for (PersonTableDto dto : rows) {
                    model.addRow(new Object[]{
                        dto.getId(),
                        dto.getFullName(),
                        dto.getRole(),
                        dto.getDetail(),
                        dto.getExtraCount()
                    });
                }
            }
            model.fireTableDataChanged();
            tblPersonas.revalidate();
            tblPersonas.repaint();
        });
    }

    private void populateStandTable(List<StandTableDto> rows) {
        DefaultTableModel model = (DefaultTableModel) tblStands.getModel();
        model.setRowCount(0);
        if (rows == null) {
            return;
        }
        for (StandTableDto dto : rows) {
            model.addRow(new Object[]{
                dto.getId(),
                dto.getPrice(),
                dto.isPurchased() ? "Sí" : "No",
                dto.getPublishers()
            });
        }
    }

    private void populateBookTable(List<BookTableDto> rows) {
        DefaultTableModel model = (DefaultTableModel) tblLibros.getModel();
        model.setRowCount(0);
        if (rows == null) {
            return;
        }
        for (BookTableDto dto : rows) {
            model.addRow(new Object[]{
                dto.getTitle(),
                dto.getAuthors(),
                dto.getIsbn(),
                dto.getGenre(),
                dto.getFormat(),
                dto.getPrice(),
                dto.getPublisher(),
                dto.getCopies(),
                dto.getPages(),
                dto.getHyperlink(),
                dto.getNarrator(),
                dto.getDuration()
            });
        }
    }

    private void populateConsultationTable(List<BookTableDto> rows) {
        DefaultTableModel model = (DefaultTableModel) tblConsultasLibros.getModel();
        model.setRowCount(0);
        if (rows == null) {
            return;
        }
        for (BookTableDto dto : rows) {
            model.addRow(new Object[]{
                dto.getTitle(),
                dto.getAuthors(),
                dto.getIsbn(),
                dto.getGenre(),
                dto.getFormat(),
                dto.getPrice(),
                dto.getPublisher(),
                dto.getCopies(),
                dto.getPages(),
                dto.getHyperlink(),
                dto.getNarrator(),
                dto.getDuration()
            });
        }
    }

    private void populateAuthorsRankingTable(List<AuthorRankingDto> rows) {
        DefaultTableModel model = (DefaultTableModel) tblAutoresDestacados.getModel();
        model.setRowCount(0);
        if (rows == null) {
            return;
        }
        for (AuthorRankingDto dto : rows) {
            model.addRow(new Object[]{
                dto.getId(),
                dto.getFullName(),
                dto.getPublisherCount()
            });
        }
    }

    private void refreshPublisherTable(boolean showMessage) {
        Response response = publisherController.getPublisherTable();
        ResponseProcessor.ProcessingResult<List<PublisherTableDto>> result
                = processResponse(response, showMessage, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populatePublisherTable(result.getData());
    }

    private void refreshPersonTable(boolean showMessage) {
        Response response = personController.getPersonTable();
        ResponseProcessor.ProcessingResult<List<PersonTableDto>> result
                = processResponse(response, showMessage, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populatePersonTable(result.getData());
    }

    private void refreshStandTable(boolean showMessage) {
        Response response = standController.getStandTable();
        ResponseProcessor.ProcessingResult<List<StandTableDto>> result
                = processResponse(response, showMessage, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populateStandTable(result.getData());
    }

    private void executeBookFilter(boolean showMessage) {
        String selection = (String) cmbFiltroTipoLibro.getSelectedItem();
        if (selection == null || selection.startsWith("Seleccione")) {
            int defaultIndex = findDefaultBookFilterIndex();
            if (defaultIndex >= 0) {
                cmbFiltroTipoLibro.setSelectedIndex(defaultIndex);
                selection = (String) cmbFiltroTipoLibro.getSelectedItem();
            } else {
                if (showMessage) {
                    showError("Debes escoger una opción de búsqueda");
                }
                return;
            }
        }
        Response response;
        switch (selection) {
            case "Libros Impresos" ->
                response = bookController.getBooksByType(BookType.PRINTED);
            case "Libros Digitales" ->
                response = bookController.getBooksByType(BookType.DIGITAL);
            case "Audiolibros" ->
                response = bookController.getBooksByType(BookType.AUDIOBOOK);
            case "Todos los Libros" ->
                response = bookController.getAllBooks();
            default -> {
                if (showMessage) {
                    showError("Filtro desconocido");
                }
                return;
            }
        }
        ResponseProcessor.ProcessingResult<List<BookTableDto>> result
                = processResponse(response, showMessage, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populateBookTable(result.getData());
    }

    private int findDefaultBookFilterIndex() {
        for (int i = 0; i < cmbFiltroTipoLibro.getItemCount(); i++) {
            String value = cmbFiltroTipoLibro.getItemAt(i);
            if ("Todos los Libros".equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(DataChangeEvent event) {
        if (event == null || event.getType() == null) {
            return;
        }
        refreshDataHandler.dispatch(event.getType());
    }

    private void txtStandPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStandPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStandPriceActionPerformed

    private void txtStandIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStandIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStandIdActionPerformed

    private void txtPersonIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonIdActionPerformed

    private void txtPersonNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonNameActionPerformed

    private void txtPersonLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPersonLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPersonLastNameActionPerformed

    private void txtPublisherNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherNitActionPerformed

    private void txtPublisherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherNameActionPerformed

    private void txtPublisherAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherAddressActionPerformed

    private void txtBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookTitleActionPerformed

    private void txtBookIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookIsbnActionPerformed

    private void rbtnLibroAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLibroAudioActionPerformed
        applyBookTypeState(BookType.AUDIOBOOK);
    }//GEN-LAST:event_rbtnLibroAudioActionPerformed

    private void txtBookPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookPriceActionPerformed

    private void txtCopiasLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCopiasLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCopiasLibroActionPerformed

    private void txtPaginasLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaginasLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaginasLibroActionPerformed

    private void txtHipervinculoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHipervinculoLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHipervinculoLibroActionPerformed

    private void txtDuracionLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionLibroActionPerformed

    private void rbtnLibroImpresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLibroImpresoActionPerformed
        applyBookTypeState(BookType.PRINTED);
    }//GEN-LAST:event_rbtnLibroImpresoActionPerformed

    private void rbtnLibroDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLibroDigitalActionPerformed
        applyBookTypeState(BookType.DIGITAL);
    }//GEN-LAST:event_rbtnLibroDigitalActionPerformed

    private void btnRegistrarStandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarStandActionPerformed
        Response response = standController.createStand(new StandCreationRequest(txtStandId.getText(), txtStandPrice.getText()));
        responseProcessor.handleAndRun(this, response, true, this::clearStandForm);
    }//GEN-LAST:event_btnRegistrarStandActionPerformed

    private void btnRegistrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAutorActionPerformed
        boolean success = createPerson(PersonRole.AUTHOR);
        if (success) {
            refreshPersonTable(false);
        }
    }//GEN-LAST:event_btnRegistrarAutorActionPerformed

    private void btnRegistrarGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarGerenteActionPerformed
        boolean success = createPerson(PersonRole.MANAGER);
        if (success) {
            refreshPersonTable(false);
        }
    }//GEN-LAST:event_btnRegistrarGerenteActionPerformed

    private void btnRegistrarNarradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNarradorActionPerformed
        boolean success = createPerson(PersonRole.NARRATOR);
        if (success) {
            refreshPersonTable(false);
        }
    }//GEN-LAST:event_btnRegistrarNarradorActionPerformed

    private void btnRegistrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEditorialActionPerformed
        SelectionOptionDto managerOption = getSelectedOption(cmbGerenteEditorial);
        String managerId = managerOption != null ? managerOption.getValue() : null;
        Response response = publisherController.createPublisher(
                new PublisherCreationRequest(
                        txtPublisherNit.getText().trim(),
                        txtPublisherName.getText().trim(),
                        txtPublisherAddress.getText().trim(),
                        managerId
                )
        );
        responseProcessor.handleAndRun(this, response, true, this::clearPublisherForm);
    }//GEN-LAST:event_btnRegistrarEditorialActionPerformed

    private void btnAgregarAutorLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutorLibroActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbAutoresDisponibles);
        if (option == null) {
            return;
        }
        if (selectedAuthorIds.add(option.getValue())) {
            refreshSelectedAuthorsArea();
        } else {
            showError("Ese autor ya está en la lista del libro");
        }
    }//GEN-LAST:event_btnAgregarAutorLibroActionPerformed

    private void btnEliminarAutorLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAutorLibroActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbAutoresDisponibles);
        if (option == null) {
            return;
        }
        if (selectedAuthorIds.remove(option.getValue())) {
            refreshSelectedAuthorsArea();
        } else {
            showError("Ese autor no está en la lista actual");
        }
    }//GEN-LAST:event_btnEliminarAutorLibroActionPerformed

    private void btnRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarLibroActionPerformed
        SelectionOptionDto publisherOption = getSelectedOption(cmbEditorialLibro);
        String publisherNit = publisherOption != null ? publisherOption.getValue() : null;
        String genre = getSelectedText(cmbGeneroLibro);
        String format = getSelectedText(cmbFormatoLibro);
        BookType type = rbtnLibroImpreso.isSelected() ? BookType.PRINTED
                : rbtnLibroDigital.isSelected() ? BookType.DIGITAL
                : rbtnLibroAudio.isSelected() ? BookType.AUDIOBOOK : null;
        
        String copies = type == BookType.PRINTED ? txtCopiasLibro.getText() : null;
        String pages = type == BookType.PRINTED ? txtPaginasLibro.getText() : null;
        String hyperlink = txtHipervinculoLibro.getText().trim();
        String duration = type == BookType.AUDIOBOOK ? txtDuracionLibro.getText() : null;
        String narratorId = null;
        
        if (type == BookType.AUDIOBOOK) {
            SelectionOptionDto narratorOption = getSelectedOption(cmbNarradoresLibro);
            if (narratorOption != null) {
                narratorId = narratorOption.getValue();
            }
        }
        
        List<String> authorIds = new ArrayList<>(selectedAuthorIds);
        String price = txtBookPrice.getText();

        Response response = bookController.createBook(
                new BookCreationRequest(
                        txtBookTitle.getText().trim(),
                        authorIds,
                        txtBookIsbn.getText().trim(),
                        genre,
                        format,
                        price,
                        publisherNit,
                        type,
                        pages,
                        copies,
                        hyperlink,
                        duration,
                        narratorId
                )
        );
        responseProcessor.handleAndRun(this, response, true, this::clearBookForm);
    }//GEN-LAST:event_btnRegistrarLibroActionPerformed

    private void btnAgregarStandCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarStandCompraActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbStandCompra);
        if (option == null) {
            return;
        }
        if (selectedStandIds.add(option.getValue())) {
            refreshSelectedStandsArea();
        } else {
            showError("Ese stand ya está en la lista");
        }
    }//GEN-LAST:event_btnAgregarStandCompraActionPerformed

    private void btnEliminarStandCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarStandCompraActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbStandCompra);
        if (option == null) {
            return;
        }
        if (selectedStandIds.remove(option.getValue())) {
            refreshSelectedStandsArea();
        } else {
            showError("Ese stand no está en la lista");
        }
    }//GEN-LAST:event_btnEliminarStandCompraActionPerformed

    private void btnAgregarEditorialCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEditorialCompraActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbEditorialCompra);
        if (option == null) {
            return;
        }
        if (selectedPublisherNits.add(option.getValue())) {
            refreshSelectedPublishersArea();
        } else {
            showError("Esa editorial ya está seleccionada");
        }
    }//GEN-LAST:event_btnAgregarEditorialCompraActionPerformed

    private void btnEliminarEditorialCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEditorialCompraActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbEditorialCompra);
        if (option == null) {
            return;
        }
        if (selectedPublisherNits.remove(option.getValue())) {
            refreshSelectedPublishersArea();
        } else {
            showError("Esa editorial no está seleccionada");
        }
    }//GEN-LAST:event_btnEliminarEditorialCompraActionPerformed

    private void btnConfirmarCompraStandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCompraStandActionPerformed
        List<String> standIds = new ArrayList<>(selectedStandIds);
        List<String> publisherNits = new ArrayList<>(selectedPublisherNits);
        Response response = purchaseController.purchaseStands(
                new StandPurchaseRequest(standIds, publisherNits)
        );
        responseProcessor.handleAndRun(this, response, true, () -> {
            selectedStandIds.clear();
            selectedPublisherNits.clear();
            refreshSelectedStandsArea();
            refreshSelectedPublishersArea();
            refreshStandOptions(false);
        });
    }//GEN-LAST:event_btnConfirmarCompraStandActionPerformed

    private void btnActualizarTablaEditorialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaEditorialesActionPerformed
        refreshPublisherTable(true);
    }//GEN-LAST:event_btnActualizarTablaEditorialesActionPerformed

    private void btnActualizarTablaPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaPersonasActionPerformed
        refreshPersonTable(true);
    }//GEN-LAST:event_btnActualizarTablaPersonasActionPerformed

    private void btnActualizarTablaStandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTablaStandsActionPerformed
        refreshStandTable(true);
    }//GEN-LAST:event_btnActualizarTablaStandsActionPerformed

    private void cmbFiltroTipoLibroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroTipoLibroItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            executeBookFilter(false);
        }
    }//GEN-LAST:event_cmbFiltroTipoLibroItemStateChanged

    private void btnFiltrarLibrosPorTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarLibrosPorTipoActionPerformed
        executeBookFilter(true);
    }//GEN-LAST:event_btnFiltrarLibrosPorTipoActionPerformed

    private void btnBuscarLibrosPorAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibrosPorAutorActionPerformed
        SelectionOptionDto option = getSelectedOption(cmbFiltroAutor);
        String authorId = option != null ? option.getValue() : null;
        Response response = queryController.getBooksByAuthor(authorId);
        ResponseProcessor.ProcessingResult<List<BookTableDto>> result
                = processResponse(response, true, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populateConsultationTable(result.getData());
    }//GEN-LAST:event_btnBuscarLibrosPorAutorActionPerformed

    private void btnBuscarLibrosPorFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibrosPorFormatoActionPerformed
        String format = getSelectedText(cmbFiltroFormato);
        Response response = queryController.getBooksByFormat(format);
        ResponseProcessor.ProcessingResult<List<BookTableDto>> result
                = processResponse(response, true, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populateConsultationTable(result.getData());
    }//GEN-LAST:event_btnBuscarLibrosPorFormatoActionPerformed

    private void btnBuscarAutoresDestacadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutoresDestacadosActionPerformed
        Response response = queryController.getAuthorsWithMorePublishers();
        ResponseProcessor.ProcessingResult<List<AuthorRankingDto>> result
                = processResponse(response, true, resp -> getData(resp, ResponseKeys.ROWS));
        if (!result.isSuccess()) {
            return;
        }
        populateAuthorsRankingTable(result.getData());
    }//GEN-LAST:event_btnBuscarAutoresDestacadosActionPerformed

    @Override
    public void dispose() {
        notifier.removeObserver(this);
        super.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarStand;
    private javax.swing.JButton btnAgregarStandCompra;
    private javax.swing.JButton btnEliminarStandCompra;
    private javax.swing.JButton btnActualizarTablaEditoriales;
    private javax.swing.JButton btnActualizarTablaPersonas;
    private javax.swing.JButton btnActualizarTablaStands;
    private javax.swing.JButton btnFiltrarLibrosPorTipo;
    private javax.swing.JButton btnRegistrarGerente;
    private javax.swing.JButton btnRegistrarNarrador;
    private javax.swing.JButton btnBuscarLibrosPorAutor;
    private javax.swing.JButton btnBuscarLibrosPorFormato;
    private javax.swing.JButton btnRegistrarAutor;
    private javax.swing.JButton btnBuscarAutoresDestacados;
    private javax.swing.JButton btnRegistrarEditorial;
    private javax.swing.JButton btnRegistrarLibro;
    private javax.swing.JButton btnAgregarEditorialCompra;
    private javax.swing.JButton btnConfirmarCompraStand;
    private javax.swing.JButton btnEliminarEditorialCompra;
    private javax.swing.JButton btnAgregarAutorLibro;
    private javax.swing.JButton btnEliminarAutorLibro;
    private javax.swing.JComboBox<SelectionOptionDto> cmbGerenteEditorial;
    private javax.swing.JComboBox<SelectionOptionDto> cmbFiltroAutor;
    private javax.swing.JComboBox<String> cmbFiltroFormato;
    private javax.swing.JComboBox<String> cmbGeneroLibro;
    private javax.swing.JComboBox<SelectionOptionDto> cmbAutoresDisponibles;
    private javax.swing.JComboBox<String> cmbFormatoLibro;
    private javax.swing.JComboBox<SelectionOptionDto> cmbEditorialLibro;
    private javax.swing.JComboBox<SelectionOptionDto> cmbNarradoresLibro;
    private javax.swing.JComboBox<SelectionOptionDto> cmbStandCompra;
    private javax.swing.JComboBox<SelectionOptionDto> cmbEditorialCompra;
    private javax.swing.JComboBox<String> cmbFiltroTipoLibro;
    private javax.swing.JLabel lblPrecioStand;
    private javax.swing.JLabel lblTituloLibro;
    private javax.swing.JLabel lblAutoresLibro;
    private javax.swing.JLabel lblIsbnLibro;
    private javax.swing.JLabel lblGeneroLibro;
    private javax.swing.JLabel lblTipoLibro;
    private javax.swing.JLabel lblFormatoLibro;
    private javax.swing.JLabel lblValorLibro;
    private javax.swing.JLabel lblEditorialLibro;
    private javax.swing.JLabel lblCopiasLibro;
    private javax.swing.JLabel lblPaginasLibro;
    private javax.swing.JLabel lblIdStand;
    private javax.swing.JLabel lblHipervinculoLibro;
    private javax.swing.JLabel lblDuracionLibro;
    private javax.swing.JLabel lblNarradorLibro;
    private javax.swing.JLabel lblEditorialesCompra;
    private javax.swing.JLabel lblStandsCompra;
    private javax.swing.JLabel lblFiltroTipoLibros;
    private javax.swing.JLabel lblConsultasTitulo;
    private javax.swing.JLabel lblConsultaAutor;
    private javax.swing.JLabel lblConsultaFormato;
    private javax.swing.JLabel lblAutoresDestacadosTitulo;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblIdPersona;
    private javax.swing.JLabel lblApellidoPersona;
    private javax.swing.JLabel lblNitEditorial;
    private javax.swing.JLabel lblNombreEditorial;
    private javax.swing.JLabel lblDireccionEditorial;
    private javax.swing.JLabel lblGerenteEditorial;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelTablaLibros;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelStand;
    private javax.swing.JPanel panelPersona;
    private javax.swing.JPanel panelEditorial;
    private javax.swing.JPanel panelLibro;
    private javax.swing.JPanel panelCompraStand;
    private javax.swing.JPanel panelTablaEditoriales;
    private javax.swing.JPanel panelTablaPersonas;
    private javax.swing.JPanel panelTablaStands;
    private javax.swing.JRadioButton rbtnLibroImpreso;
    private javax.swing.JRadioButton rbtnLibroDigital;
    private javax.swing.JRadioButton rbtnLibroAudio;
    private javax.swing.JScrollPane scrollEditorialesCompra;
    private javax.swing.JScrollPane scrollAutoresLibro;
    private javax.swing.JScrollPane scrollStandsCompra;
    private javax.swing.JScrollPane scrollTablaEditoriales;
    private javax.swing.JScrollPane scrollTablaPersonas;
    private javax.swing.JScrollPane scrollTablaStands;
    private javax.swing.JScrollPane scrollTablaLibros;
    private javax.swing.JScrollPane scrollTablaConsultasLibros;
    private javax.swing.JScrollPane scrollTablaAutoresDestacados;
    private javax.swing.JTabbedPane tabbedModuloPrincipal;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTable tblStands;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTable tblConsultasLibros;
    private javax.swing.JTable tblAutoresDestacados;
    private javax.swing.JTextArea txaEditorialesCompra;
    private javax.swing.JTextArea txaAutoresLibro;
    private javax.swing.JTextArea txaStandsCompra;
    private javax.swing.JTextField txtStandPrice;
    private javax.swing.JTextField txtBookIsbn;
    private javax.swing.JTextField txtBookPrice;
    private javax.swing.JTextField txtCopiasLibro;
    private javax.swing.JTextField txtPaginasLibro;
    private javax.swing.JTextField txtHipervinculoLibro;
    private javax.swing.JTextField txtDuracionLibro;
    private javax.swing.JTextField txtStandId;
    private javax.swing.JTextField txtPersonId;
    private javax.swing.JTextField txtPersonName;
    private javax.swing.JTextField txtPersonLastName;
    private javax.swing.JTextField txtPublisherNit;
    private javax.swing.JTextField txtPublisherName;
    private javax.swing.JTextField txtPublisherAddress;
    private javax.swing.JTextField txtBookTitle;
    // End of variables declaration//GEN-END:variables
}

