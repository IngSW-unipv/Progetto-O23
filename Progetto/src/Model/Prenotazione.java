package Model;

import java.sql.Date;



public class Prenotazione {
		    private String Cod_Pr;
		    private Date CheckIn;
		    private Date CheckOut;
		    private float Costo;
		    private SqlDateTime Data_Pr;
		    private int Num_Persone;
		    private boolean Confermata;

		    // Costruttore della classe Prenotazione
		    public Prenotazione(String Cod_Pr, Date CheckIn, Date CheckOut, float Costo, SqlDateTime Data_Pr, int Num_Persone, boolean Confermata) {
		        this.Cod_Pr = Cod_Pr;
		        this.CheckIn = CheckIn;
		        this.CheckOut = CheckOut;
		        this.Costo = Costo;
		        this.Data_Pr = Data_Pr;
		        this.Num_Persone = Num_Persone;
		        this.Confermata = false; // di default la prenotazione non è ancora stata confermata
		    }

		    // Metodo per confermare la prenotazione
		    public void ConfermaPrenotazione() {
		        this.Confermata = true;
		    }

		    // Metodo per annullare la prenotazione
		    public void AnnullaPrenotazione() {
		        this.Confermata = false;
		    }

		    // Metodo per restituire lo stato della prenotazione
		    public boolean IsConfermata() {
		        return this.Confermata;
		    }

		    // Metodo toString per stampare le informazioni della prenotazione
		    @Override
		    public String toString() {
		        return "Prenotazione [CodicePrenotazione=" + Cod_Pr + ", DataPrenotazione=" + Data_Pr + ", CheckIn=" + CheckIn +", CheckOut=" + CheckOut +",NumeroPersone=" + Num_Persone + ", Costo=" + Costo +", Conferma=" + Confermata + "]";
		    }
}



