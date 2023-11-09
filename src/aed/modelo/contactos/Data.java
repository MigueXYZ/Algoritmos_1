package aed.modelo.contactos;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia,int mes,int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }

    public int getAno() {
        return ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return dia + "-" + mes + "-" + ano ;
    }
}
