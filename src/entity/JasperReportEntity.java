package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class JasperReportEntity {
	public JFrame compileTransportReport() {
		{
			try {
				
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(ConstsDbManageElect.CONN_STR)) {
	            	
	            	JasperPrint print = JasperFillManager.fillReport(
	            			getClass().getResourceAsStream("../boundary/TransportationReport.jasper"),
	                        new HashMap<String, Object>(), conn);
	                JFrame frame = new JFrame("Transportation Report");
	                frame.getContentPane().add(new JRViewer(print));
	                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	                frame.pack();
	                return frame;
	            } catch (SQLException | JRException | NullPointerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
}
