package com.gmail.herman.uladzimir.project.model.factory;

import com.gmail.herman.uladzimir.project.model.entity.FreightTrain;
import com.gmail.herman.uladzimir.project.model.entity.Train;
import com.gmail.herman.uladzimir.project.model.util.RandomUtil;

public class FreightTrainFactory implements TrainFactory {

    @Override
    public Train createTrain() {
        return new FreightTrain(RandomUtil.createNumTrain(), RandomUtil.createRoute(),
                RandomUtil.createQuantityWagons(), RandomUtil.defineFreightWagonType(),
                RandomUtil.isDangerousGoods());
    }

}