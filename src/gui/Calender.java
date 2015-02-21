package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
	            int day = 1;
	            
	            
	        }
			
		    public class CellPane extends JPanel {
				private static final long serialVersionUID = 1L;
				private Color defaultBackground;

		        public CellPane() {
		            addMouseListener(new MouseAdapter() {
		                @Override
		                public void mouseEntered(MouseEvent e) {
		                    defaultBackground = getBackground();
		                    setBackground(Color.RED);
		                }

		                @Override
		                public void mouseExited(MouseEvent e) {
		                    setBackground(defaultBackground);
		                }
		            });
		        }

		        @Override
		        public Dimension getPreferredSize() {
		            return new Dimension(90,90);
		        }
		    }
	    }



