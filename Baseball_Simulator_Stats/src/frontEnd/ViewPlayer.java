package frontEnd;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;

import rojeru_san.componentes.RSDateChooser;
import sun.java2d.pipe.TextPipe;
import rojeru_san.componentes.RSCalendar;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import backEnd.Lidom;
import backEnd.Stadium;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewPlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblListaJugadores;
	private JPanel panelHeader;
	private JScrollPane scrollPane;

	private static DefaultTableModel model;
	private static JTable tablePlayer;
	private static Object[] column;
	private JButton button;
	private JButton button_1;
	private JLabel label;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton button_2;


	/**
	 * Create the dialog.
	 */
	public ViewPlayer() {

		getContentPane().setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 732, 566);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelBg = new JPanel();
			panelBg.setBackground(new Color(255, 255, 255));
			panelBg.setBounds(0, 0, 732, 566);
			contentPanel.add(panelBg);
			panelBg.setLayout(null);

			panelHeader = new JPanel();
			panelHeader.setLayout(null);
			panelHeader.setBackground(new Color(0, 30, 72));
			panelHeader.setBounds(0, 0, 732, 45);
			panelBg.add(panelHeader);

			lblListaJugadores = new JLabel("LISTA JUGADORES");
			lblListaJugadores.setHorizontalTextPosition(SwingConstants.CENTER);
			lblListaJugadores.setBounds(269, 0, 192, 45);
			panelHeader.add(lblListaJugadores);
			lblListaJugadores.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaJugadores.setForeground(new Color(255, 255, 255));
			lblListaJugadores.setFont(new Font("Consolas", Font.BOLD, 20));

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 154, 710, 329);
			panelBg.add(scrollPane);

			tablePlayer = new JTable();
			tablePlayer.setRowMargin(0);
			tablePlayer .setFocusable(false);
			tablePlayer.setRowHeight(20);
			tablePlayer.setIntercellSpacing(new Dimension(0, 0));
			tablePlayer.setGridColor(new Color(255, 255, 255));
			tablePlayer.setShowVerticalLines(false);
			tablePlayer.getTableHeader().setReorderingAllowed(false);
			tablePlayer.setSelectionBackground(new Color(239, 108, 0));
			tablePlayer.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 16));
			tablePlayer.getTableHeader().setOpaque(false);

			tablePlayer.getTableHeader().setBackground(new Color(255,255,255));
			tablePlayer.setFont(new Font("Consolas", Font.PLAIN, 15));
			tablePlayer.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"N\u00FAmero ID", "Nombre", "Apellidos", "Equipo", "# Uniforme"
					}
					) {
				Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
						false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(tablePlayer);

			button = new JButton("Registrar");
			button.setIconTextGap(5);
			button.setHorizontalTextPosition(SwingConstants.LEFT);
			button.setForeground(new Color(255, 255, 240));
			button.setFont(new Font("Consolas", Font.BOLD, 17));
			button.setBorder(null);
			button.setBackground(new Color(0, 30, 72));
			button.setBounds(218, 523, 146, 30);
			panelBg.add(button);

			button_1 = new JButton("Cancelar");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ImageIcon icon = new ImageIcon(getClass().getResource("/iconos_imagenes/icons8_cancel_2_48px_1.png"));
					String[] options = {"Si", "No"};	

					int xOption	= JOptionPane.showOptionDialog(null, "�Seguro que desea cancelar?, la ventana se cerrar�.", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);

					if (xOption == 0) {
						dispose(); 
					}
				}
			});
			button_1.setIconTextGap(5);
			button_1.setHorizontalTextPosition(SwingConstants.LEFT);
			button_1.setForeground(new Color(255, 255, 240));
			button_1.setFont(new Font("Consolas", Font.BOLD, 17));
			button_1.setBorder(null);
			button_1.setBackground(new Color(0, 30, 70));
			button_1.setBounds(376, 523, 146, 30);
			panelBg.add(button_1);

			label = new JLabel("Buscar por:");
			label.setVerticalTextPosition(SwingConstants.BOTTOM);
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setForeground(Color.BLACK);
			label.setFont(new Font("Consolas", Font.PLAIN, 20));
			label.setBounds(10, 71, 125, 31);
			panelBg.add(label);

			comboBox = new JComboBox();
			comboBox.setFont(new Font("Consolas", Font.PLAIN, 18));
			comboBox.setBounds(135, 72, 125, 30);
			panelBg.add(comboBox);

			textField = new JTextField() {
				private static final long serialVersionUID = 1L;
				/************* PARA REDONDEAR JTEXTFIELD *************/
				@Override 
				protected void paintComponent(Graphics g) {
					if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
						Graphics2D g2 = (Graphics2D) g.create();
						g2.setPaint(getBackground());
						g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
								0, 0, getWidth() - 1, getHeight() - 1));
						g2.dispose();
					}
					super.paintComponent(g);
				}
				@Override 
				public void updateUI() {
					super.updateUI();
					setOpaque(false);
					setBorder(new RoundedCornerBorder());
				}
			};
			/**********************************************************/	
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Consolas", Font.PLAIN, 18));
			textField.setDisabledTextColor(Color.BLACK);
			textField.setColumns(10);
			textField.setBounds(272, 72, 311, 30);
			panelBg.add(textField);

			button_2 = new JButton("Buscar");
			button_2.setIconTextGap(30);
			button_2.setHorizontalTextPosition(SwingConstants.RIGHT);
			button_2.setForeground(new Color(255, 255, 240));
			button_2.setFont(new Font("Consolas", Font.BOLD, 20));
			button_2.setBorder(null);
			button_2.setBackground(new Color(4, 10, 20));
			button_2.setBounds(595, 72, 125, 30);
			panelBg.add(button_2);

			try {
				// Definici�n de la m�scara para ID.
				MaskFormatter maskID = null;
				maskID = new MaskFormatter("##-###-###");
				maskID.setPlaceholderCharacter('#');
				/**********************************************************/		
			} 
			catch (ParseException e) {
				e.printStackTrace();
			}
		}


		loadTablePlayer(); // para cargar la tabla de los jugadores registrados.
	}



	/** Metodos **/

	public void loadTablePlayer() {

		model = (DefaultTableModel) tablePlayer.getModel();
		model.setRowCount(0);
		column = new Object[model.getColumnCount()];

		for (int i = 0; i < Lidom.getInstance().getListPlayer().size(); i++) {
			column[0] = Lidom.getInstance().getListPlayer().get(i).getId();
			column[1] =  Lidom.getInstance().getListPlayer().get(i).getName();
			column[2] =  Lidom.getInstance().getListPlayer().get(i).getLastname();
			column[3] =   Lidom.getInstance().getListPlayer().get(i).getTeamName();
			column[4] =  Lidom.getInstance().getListPlayer().get(i).getNumber();

			model.addRow(column);

		}
	}



}