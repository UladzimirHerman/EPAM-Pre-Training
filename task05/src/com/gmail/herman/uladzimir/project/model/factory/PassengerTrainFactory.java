package com.gmail.herman.uladzimir.project.model.factory;

import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.functional.TrainInitializer;

public class PassengerTrainFactory implements TrainFactory {

    @Override
    public Train createTrain() {
        return new PassengerTrain(TrainInitializer.initializeNumTrain(), TrainInitializer.initializeRoute(),
                TrainInitializer.initializeQuantityWagons(), TrainInitializer.initializePassengerWagonWeight(),
                TrainInitializer.initializePassengerWagonLength(), TrainInitializer.initializePassengerWagonType(),
                TrainInitializer.initializePassengerWagonCapacity(), TrainInitializer.initializeTicketPrice(),
                TrainInitializer.initializeFiling());
    }

}