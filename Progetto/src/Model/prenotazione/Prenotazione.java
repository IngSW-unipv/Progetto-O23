package Model.prenotazione;

import java.sql.Date;

import Model.SqlDateTime;



public class Prenotazione {
		    private String Cod_Pr;
		    private Date CheckIn;
		    private Date CheckOut;
		    private float Costo;
		    private SqlDateTime Data_Pr;

		    // CONSTRUCTOR OF RESERVE CLASS
		    public Prenotazione(String Cod_Pr, Date CheckIn, Date CheckOut, float Costo, SqlDateTime Data_Pr) {
		        this.Cod_Pr = Cod_Pr;
		        this.CheckIn = CheckIn;
		        this.CheckOut = CheckOut;
		        this.Costo = Costo;
		        this.Data_Pr = Data_Pr;
		    }

		    
		    //GETTERS & SETTERS
			public String getCod_Pr() {
				return Cod_Pr;
			}

			public void setCod_Pr(String cod_Pr) {
				Cod_Pr = cod_Pr;
			}

			public Date getCheckIn() {
				return CheckIn;
			}

			public void setCheckIn(Date checkIn) {
				CheckIn = checkIn;
			}

			public Date getCheckOut() {
				return CheckOut;
			}

			public void setCheckOut(Date checkOut) {
				CheckOut = checkOut;
			}

			public float getCosto() {
				return Costo;
			}

			public void setCosto(float costo) {
				Costo = costo;
			}

			public SqlDateTime getData_Pr() {
				return Data_Pr;
			}

			public void setData_Pr(SqlDateTime data_Pr) {
				Data_Pr = data_Pr;
			}


		    
		    
}


