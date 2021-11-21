package model;

public class Adresa {
	protected String ulica;
	protected String broj;
	protected String grad;
	protected String drzava;
	
	
	public Adresa(String ulica)
	{
		this.ulica = ulica;
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
		//return new String(ulica + broj + grad + drzava);
		return new String(ulica);
	}
}
