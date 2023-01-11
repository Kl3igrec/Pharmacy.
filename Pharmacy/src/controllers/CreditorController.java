package controllers;

import domain.CreditCustomer;
import interfaces.ControllerInterface;
import repository.inmemory.CreditorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreditorController implements ControllerInterface<Integer, CreditCustomer> {

    private CreditorRepository CreditorRepository;

    public CreditorController(CreditorRepository creditorRepository) {
        CreditorRepository = creditorRepository;
    }

    @Override
    public List<CreditCustomer> getAll() {
        return this.CreditorRepository.findAll();
    }

    @Override
    public List<CreditCustomer> sortedByName() {
        List<CreditCustomer> copy = new ArrayList<CreditCustomer>();
        copy.addAll(this.CreditorRepository.findAll());
        Collections.sort(copy, (o1, o2) -> o1.getLastName().compareTo(o2.getFirstName()));
        return copy;
    }

    @Override
    public boolean add(CreditCustomer Entity) {
        if (this.CreditorRepository.findByID(Entity.getID()) == null) {
            this.CreditorRepository.Add(Entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(CreditCustomer Entity) {
        if (this.CreditorRepository.findByID(Entity.getID()) != null) {
            this.CreditorRepository.remove(Entity.getID());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer ID, CreditCustomer Entity) {
        if (this.CreditorRepository.findByID(Entity.getID()) == null) {
            this.CreditorRepository.update(ID, Entity);
            return true;
        }
        return false;
    }
}
