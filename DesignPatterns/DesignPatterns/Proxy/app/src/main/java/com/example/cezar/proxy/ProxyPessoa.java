package com.example.cezar.proxy;

/**
 * Created by Cezar on 29/02/2016.
 */
class ProxyPessoa implements Pessoa {
    private int id;
    private Pessoa pessoa;
    //mesma interface public
    ProxyPessoa(int id)
    {
        this.id = id;
    }
    /**
     * Método comum da interface * * @see Pessoa#getNome()
     */
    public String getNome()
    {
        if (pessoa == null) { //Apenas cria o objeto real quando chamar este método
            pessoa = PessoaDAO.getPessoaByID(this.id);
        }
        /** Delega para o objeto real **/
        return pessoa.getNome();
    }

    public int getId(){
        return this.id;
    }
}

