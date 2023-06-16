package br.unipar.central.services;

import br.unipar.central.dao.CidadeDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Cidade;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class CidadeService {

    public void validar(Cidade cidade) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException {

        if (cidade == null) {
            throw new EntidadeNaoInformadaException("Cidade");
        }

        if (cidade.getNome() == null
                || cidade.getNome().isBlank()
                || cidade.getNome().isEmpty()) {
            throw new CampoNaoInformadoException("Nome");
        }
        if (cidade.getNome().length() > 120) {
            throw new TamanhoCampoInvalidoException("Nome", 120);
        }
    }

    public List<Cidade> findAll() throws SQLException {
        CidadeDAO cidadeDAO = new CidadeDAO();
        List<Cidade> resultado = cidadeDAO.findAll();

        return resultado;
    }

    public Cidade findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception {

        if (id <= 0) {
            throw new TamanhoCampoInvalidoException("id", 1);
        }

        CidadeDAO cidadeDAO = new CidadeDAO();

        Cidade retorno = cidadeDAO.findById(id);

        if (retorno == null) {
            throw new Exception("Não foi possível encontrar um cidade com o id " + id + " informado.");
        }

        return retorno;

    }

    public void insert(Cidade cidade) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.insert(cidade);

    }

    public void update(Cidade cidade) throws SQLException,
            EntidadeNaoInformadaException,
            CampoNaoInformadoException,
            TamanhoCampoInvalidoException {

        validar(cidade);
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.update(cidade);

    }

    public void delete(int id) throws SQLException {

        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.delete(id);

    }
}
