package lab9;

import java.time.LocalDate;

public class Persoana {
	private String nume;
	private LocalDate datanasterii;
	private String adresa;
	private String telefon;
	
	
	public Persoana(String nume, LocalDate datanasterii, String adresa, String telefon) {
		this.nume = nume;
		this.datanasterii = datanasterii;
		this.adresa = adresa;
		this.telefon = telefon;
	}

	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public LocalDate getDatanasterii() {
		return datanasterii;
	}
	public void setDatanasterii(LocalDate datanasterii) {
		this.datanasterii = datanasterii;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

		@Override
	public String toString() {
		return "<tr><td>" + nume + "</td></td>"+ datanasterii+" </td></td> "+ adresa+"</td></td> "+ telefon+ "</td></tr>";
		
		}
	
	

}
