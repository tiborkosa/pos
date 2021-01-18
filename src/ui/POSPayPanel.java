package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import buttons.POSButton;
import models.Check;
import util.PayCheck;

public class POSPayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private int itemsAddedCount = 0;
	private JButton deleteButton;
	private JTextField subTotal;
	private JTextField tax;
	private JTextField total;
	private JButton payButton;

	private Check check = new Check();

	public POSPayPanel() {

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 20, 10, 20));

		JLabel title = new JLabel("Check # 1", SwingConstants.CENTER) {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getMaximumSize() {
				Dimension d = super.getMaximumSize();
				d.width = Integer.MAX_VALUE;
				return d;
			}
		};
		title.setForeground(Color.LIGHT_GRAY);
		title.setBorder(new EmptyBorder(20, 0, 20, 0));
		title.setFont(new Font("Verdana", Font.BOLD, 17));
		
		add(title, BorderLayout.NORTH);

		setBackground(new Color(0, 0, 0, 220));

		// need of label Order and maybe a check number

		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane listScrollPane = new JScrollPane(list); // adding scroll bar
		listScrollPane.setBorder(BorderFactory.createTitledBorder("Order"));
		add(listScrollPane, BorderLayout.CENTER);

		JPanel bottom = new JPanel(new GridBagLayout());

		// need of the list that was added
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(2, 4, 2, 4);

		// need the labels to show the total, tax and other things
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;

		bottom.add(new JLabel("Total: "), gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.NONE;

		total = new JTextField("0");
		total.setEnabled(false);
		total.setColumns(10);
		bottom.add(total, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		bottom.add(new JLabel("Tax: "), gbc);

		gbc.gridx = 1;
		tax = new JTextField("0");
		tax.setEnabled(false);
		tax.setColumns(10);
		bottom.add(tax, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		bottom.add(new JLabel("Subtotal: "), gbc);

		gbc.gridx = 1;
		subTotal = new JTextField("0");
		subTotal.setEnabled(false);
		subTotal.setColumns(10);
		bottom.add(subTotal, gbc);

		// need of the pay and delete from the check
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(35, 0, 10, 0);
		deleteButton = new POSButton("Delete");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new DeleteItemListener());
		bottom.add(deleteButton, gbc);

		gbc.gridx = 1;
		payButton = new POSButton("Pay");
		payButton.addActionListener(new PayListener());
		payButton.setEnabled(false);
		bottom.add(payButton, gbc);

		add(bottom, BorderLayout.SOUTH);

	}

	public void addItemToCheck(String desc, Double price) {
		list.ensureIndexIsVisible(itemsAddedCount);
		listModel.addElement(desc + " " + price);
		check.addMore(price);
		updatePrice();

		deleteButton.setEnabled(true);
		payButton.setEnabled(true);
		list.setSelectedIndex(0);
	}

	private void updatePrice() {

		total.setText(check.getTotal());
		tax.setText(check.getTax());
		subTotal.setText(check.getSubTotal());
	}

	class DeleteItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int index = list.getSelectedIndex();

			// strip the price out and adjust the check
			String[] chunks = list.getSelectedValue().trim().split(" ");
			check.deleteItem(Double.parseDouble(chunks[chunks.length - 1]));
			updatePrice();

			listModel.remove(index);

			int size = listModel.getSize();

			if (size == 0) { // Nobody's left, disable firing.
				deleteButton.setEnabled(false);
				payButton.setEnabled(false);
			} else { // Select an index.
				if (index == listModel.getSize()) {
					// removed item in last position
					index--;
				}

				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index);
			}
		}
	}
	
	class PayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PayCheck.pay(check.getSubTotal());
			PayCheck.printCheck(listModel, check);
			check = new Check();
			updatePrice();
			listModel.clear();
		}
	}

}
