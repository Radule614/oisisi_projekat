package model;

import utility.Utility;

public class Adresa {
	protected String ulica;
	protected String broj;
	protected String grad;
	protected String drzava;
	
	
	public Adresa(String ulica, String broj, String grad, String drzava)
	{
		this.ulica = ulica;
		this.broj = broj;
		this.grad = grad;
		this.drzava = drzava;
	}
	
	public Adresa(String input)
	{
		String[] parts = input.split(",");
		parts = Utility.trimEach(parts);
		this.ulica = parts[0];
		this.broj = parts[1];
		this.grad = parts[2];
		this.drzava = parts[3];
	}


	public String getUlica() {
		return ulica;
	}


	public void setUlica(String ulica) {
		this.ulica = ulica;
	}


	public String getBroj() {
		return broj;
	}


	public void setBroj(String broj) {
		this.broj = broj;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	@Override
	public String toString()
	{
		return new String(ulica + ", " + broj + ", "  + grad + ", " + drzava);
		//return new String(ulica);
	}
}
