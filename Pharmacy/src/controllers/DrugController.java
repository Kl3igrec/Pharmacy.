package controllers;

import domain.Drug;
import interfaces.ControllerInterface;
import repository.inmemory.DrugRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DrugController implements ControllerInterface<Integer, Drug> {
    private DrugRepository DrugRepository;


    public DrugController(DrugRepository drugRepository) {
        DrugRepository = drugRepository;
    }

    @Override
    public List<Drug> getAll() {
        return this.DrugRepository.findAll();

    }

    @Override
    public List<Drug> sortedByName() {
        List<Drug> copy = new ArrayList<Drug>();
        copy.addAll(this.DrugRepository.findAll());
        Collections.sort(copy, Comparator.comparing(Drug::getName));
        return copy;

    }

    public List<Drug> sortedByPrice() {
        List<Drug> copy = new ArrayList<Drug>();
        copy.addAll(this.DrugRepository.findAll());
        Collections.sort(copy, Comparator.comparing(Drug::getPrice));
        return copy;
    }

    public List<Drug> sortedByQuantity() {
        List<Drug> copy = new ArrayList<Drug>();
        copy.addAll(this.DrugRepository.findAll());
        Collections.sort(copy, Comparator.comparing(Drug::getQuantity));
        return copy;
    }

    @Override
    public boolean add(Drug D) {
        if (this.DrugRepository.findByID(D.getID()) == null) {
            this.DrugRepository.Add(D);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Drug D) {

        if (this.DrugRepository.findByID(D.getID()) != null) {
            this.DrugRepository.remove(D.getID());
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer ID, Drug D) {
        if (this.DrugRepository.findByID(D.getID()) == null) {
            this.DrugRepository.update(ID, D);
            return true;
        }
        return false;
    }


}
