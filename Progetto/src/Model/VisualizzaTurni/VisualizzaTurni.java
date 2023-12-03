package Model.VisualizzaTurni;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import dao.Gestione_Dao;

public class VisualizzaTurni {
	
		private Date Giorno;
		private Time Ora_inizio;
		private Time Ora_fine;
		private String ruolo;
		private int stipendio;
		private int ID_L;
		

		public VisualizzaTurni(Date giorno, Time ora_inizio, Time ora_fine, String ruolo, int stipendio, int iD_L) {
			
			Giorno = giorno;
			Ora_inizio = ora_inizio;
			Ora_fine = ora_fine;
			ruolo = ruolo;
			stipendio = stipendio;
			ID_L = iD_L;
			
		}

		public Date getGiorno() {
			return Giorno;
		}

		public void setGiorno(Date giorno) {
			Giorno = giorno;
		}

		public Time getOra_inizio() {
			return Ora_inizio;
		}

		public void setOra_inizio(Time ora_inizio) {
			Ora_inizio = ora_inizio;
		}

		public Time getOra_fine() {
			return Ora_fine;
		}

		public void setOra_fine(Time ora_fine) {
			Ora_fine = ora_fine;
		}
		
		public int getID_L() {
			return ID_L;
		}

		public void setID_L(int iD_L) {
			ID_L = iD_L;
		}

		public String getRuolo() {
			return ruolo;
		}

		public void setRuolo(String ruolo) {
			this.ruolo = ruolo;
		}

		public int getStipendio() {
			return stipendio;
		}

		public void setStipendio(int stipendio) {
			this.stipendio = stipendio;
		}

		public void GetOrarioLavoro() throws SQLException {
			Gestione_Dao g = new Gestione_Dao();
			VisualizzaTurniDAO v = new VisualizzaTurniDAO();
			g.OttieniParametriLavoratore(ID_L);
			Giorno = g.OttieniParametroDateTurniLavoro("giorno",ID_L);
			Ora_inizio = g.OttieniParametroTimeTurniLavoro("ora_inizio", ID_L);
			Ora_fine = g.OttieniParametroTimeTurniLavoro("ora_fine", ID_L);
			//ruolo = v.vediTurni(ID_L);
			//stipendio = v.vediTurni("stipendio",ID_L);
		}

		@Override
		public String toString() {
			return "Turni_Lavoro [Giorno=" + Giorno + ", Ora_inizio=" + Ora_inizio + ", Ora_fine=" + Ora_fine + "]";
		}
		
		
	}

