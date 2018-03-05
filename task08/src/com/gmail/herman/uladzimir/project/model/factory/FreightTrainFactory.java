package com.gmail.herman.uladzimir.project.model.factory;

import com.gmail.herman.uladzimir.project.model.entity.FreightTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.functional.TrainInitializer;

public class FreightTrainFactory implements TrainFactory {

    @Override
    public Train createTrain() {
        return new FreightTrain(TrainInitializer.initializeNumTrain(), TrainInitializer.initializeRoute(),
                TrainInitializer.initializeQuantityWagons(), TrainInitializer.initializeFreightWagonWeight(),
                TrainInitializer.initializeFreightWagonLength(), TrainInitializer.initializeFreightWagonType(),
                TrainInitializer.initializeDangerousGoods());
    }

}