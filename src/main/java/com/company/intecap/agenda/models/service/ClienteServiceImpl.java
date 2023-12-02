package com.company.intecap.agenda.models.service;

import com.company.intecap.agenda.models.dao.IClienteDao;
import com.company.intecap.agenda.models.entity.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    //@Autowired
    //private IClienteDao clienteDao;

    private final  IClienteDao clienteDao;  // @Autowired ---- declarar como final

    public ClienteServiceImpl(IClienteDao clienteDao){ //@Autowired crear un constructor
        this.clienteDao = clienteDao;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeClienteConNombre(String nombre) {
        Optional<Cliente> cliente = clienteDao.findByNombre(nombre);
        return cliente.isPresent(); //True
    }

}
