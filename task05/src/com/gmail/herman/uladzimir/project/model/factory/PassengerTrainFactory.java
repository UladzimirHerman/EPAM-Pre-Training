package com.gmail.herman.uladzimir.project.model.factory;

import com.gmail.herman.uladzimir.project.model.entity.PassengerTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.util.RandomUtil;

public class PassengerTrainFactory implements TrainFactory {

    @Override
    public Train createTrain() {
        return new PassengerTrain(RandomUtil.createNumTrain(), RandomUtil.createRoute(),
                RandomUtil.createQuantityWagons(), RandomUtil.definePassengerWagonType(),
                RandomUtil.createTicketPrice(), RandomUtil.createFiling());
    }

}