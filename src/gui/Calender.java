package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

	
	    public class Calender extends JPanel {
	    	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public Rectangle rect;

			public Calender() {
	            setLayout(new GridBagLayout());

	            GridBagConstraints gbc = new GridBagConstraints();
	            for (int row = 0; row < 5; row++) {
	                for (int col = 0; col < 7; col++) {
	                    gbc.gridx = col;
	                    gbc.gridy = row;

	                    CellPane cellPane = new CellPane();
	                    Border border = null;
	                    if (row < 4) {
	                        if (col < 6) {
	                            border = new MatteBorder(3, 3, 0, 0, Color.GRAY);
	                        } else {
	                            border = new MatteBorder(3, 3, 0, 3, Color.GRAY);
	                        }
	                    } else {
	                        if (col < 6) {
	                           border = new MatteBorder(3, 3, 3, 0, Color.GRAY);
	                        } else {
	                           border = new MatteBorder(3, 3, 3, 3, Color.GRAY);
	                        }
	                    }
	                    cellPane.setBorder(border);
	                    add(cellPane, gbc);
	                }
	            }
	        }
			
		    public class CellPane extends JPanel {
				private static final long serialVersionUID = 1L;
				private Color defaultBackground;

		        public CellPane() {
		            addMouseListener(new MouseAdapter() {
		                @Override
		                public void mouseEntered(MouseEvent e) {
		                    defaultBackground = getBackground();
		                    setBackground(Color.BLUE);
		                }

		                @Override
		                public void mouseExited(MouseEvent e) {
		                    setBackground(defaultBackground);
		                }
		            });
		        }

		        @Override
		        public Dimension getPreferredSize() {
		            return new Dimension(90, 90);
		        }
		    }
	    }



