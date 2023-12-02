package Controller.turni;
import java.awt.event.ActionEvent;
import java.sql.SQLException;




import View.turni.VisualizzaTurniGUI;
public class VisualizzaTurniGUIController {
	private final VisualizzaTurniGUI view;

	public VisualizzaTurniGUIController( VisualizzaTurniGUI view) {
        this.view = view;
    }



public void riempitabella(ActionEvent e) throws SQLException {
	int id = view.getID();
	
	 VisualizzaTurniGUI dao = new VisualizzaTurniGUI(null, id, null);
	
	dao.MostraTurni(id, view.table_1);
}




}


