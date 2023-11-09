package aed.modelo.contactos;

public class Contacto {
    private String primeiro_nome;
    private String ultimo_nome;
    private long numero_telefone;
    private String morada;
    private Data data_nascimento;

    public Contacto(String primeiro_nome, String ultimo_nome, long numero_telefone, String morada, Data data_nascimento) {
        this.primeiro_nome = primeiro_nome;
        this.ultimo_nome = ultimo_nome;
        this.numero_telefone = numero_telefone;
        this.morada = morada;
        this.data_nascimento = data_nascimento;
    }

    public Data getData_nascimento() {
        return data_nascimento;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public String getUltimo_nome() {
        return ultimo_nome;
    }

    public long getNumero_telefone() {
        return numero_telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public void setUltimo_nome(String ultimo_nome) {
        this.ultimo_nome = ultimo_nome;
    }

    public void setNumero_telefone(long numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setData_nascimento(Data data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "primeiro_nome='" + primeiro_nome + '\'' +
                ", ultimo_nome='" + ultimo_nome + '\'' +
                ", numero_telefone=" + numero_telefone +
                ", morada='" + morada + '\'' +
                ", data_nascimento=" + data_nascimento +
                '}';
    }
}
