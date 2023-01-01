package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    private List<Machine> allMachines = null;

    @Override
    public List<Machine> getAll(Class type) {
        allMachines = new ArrayList<>();
        List<? extends Machine> listMachine = new ArrayList<>();
        if (Bulldozer.class.equals(type)) {
            listMachine = new BulldozerProducer().get();
        } else if (Excavator.class.equals(type)) {
            listMachine = new ExcavatorProducer().get();
        } else if (Truck.class.equals(type)) {
            listMachine = new TruckProducer().get();
        } else {
            return new ArrayList<>();
        }
        for (int i = 0; i < listMachine.size(); i++) {
            allMachines.add(listMachine.get(i));
        }
        return allMachines;
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        Collections.fill(machines, value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (int i = 0; i < machines.size(); i++) {
            machines.get(i).doWork();
        }
    }
}
