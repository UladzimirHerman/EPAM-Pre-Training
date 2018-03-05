package com.gmail.herman.uladzimir.project.model.functional;

import com.gmail.herman.uladzimir.container.exception.ListIsEmptyException;
import com.gmail.herman.uladzimir.container.exception.ObjectIsNullException;
import com.gmail.herman.uladzimir.project.model.entity.Train;

public class TrainSorter<T extends Comparable<T>> {

    //O(n^2)
    public static void sortBubble() throws ListIsEmptyException, ObjectIsNullException {
        Train trainsArray[] = TrainManager.getAllTrain().
                toArray(new Train[TrainStatistics.countTrain()]);
        Train tempTrain;
        int iteration = trainsArray.length - 1;
        boolean sort;

        for (int j = iteration; j > 0; j--) {
            sort = false;

            for (int i = 0; i < j; i++) {
                if (trainsArray[i].compareTo(trainsArray[i + 1]) > 0) {
                    tempTrain = trainsArray[i];
                    trainsArray[i] = trainsArray[i + 1];
                    trainsArray[i + 1] = tempTrain;
                    sort = true;
                }
            }

            if (!sort) {
                break;
            }
        }

        TrainManager.removeAllTrain();
        TrainManager.addTrain(trainsArray);
    }

    //O(n^2)
    public static void sortInsertion() throws ListIsEmptyException, ObjectIsNullException {
        Train trainsArray[] = TrainManager.getAllTrain().
                toArray(new Train[TrainStatistics.countTrain()]);
        Train tempTrain;
        int iteration = trainsArray.length;

        for (int j = 1; j < iteration; j++) {

            for (int i = j; i > 0; i--) {
                if (trainsArray[i].compareTo(trainsArray[i - 1]) < 0) {
                    tempTrain = trainsArray[i];
                    trainsArray[i] = trainsArray[i - 1];
                    trainsArray[i - 1] = tempTrain;
                }
            }

        }

        TrainManager.removeAllTrain();
        TrainManager.addTrain(trainsArray);
    }

    //O(n^2)
    public static void sortSelection() throws ListIsEmptyException, ObjectIsNullException {
        Train trainsArray[] = TrainManager.getAllTrain().
                toArray(new Train[TrainStatistics.countTrain()]);
        int iteration = trainsArray.length;
        int index;

        for (int i = 0; i < iteration - 1; i++) {
            index = i;

            for (int j = i + 1; j < iteration; j++) {
                if (trainsArray[j].compareTo(trainsArray[index]) < 0) {
                    index = j;
                }
            }

            Train tempTrain = trainsArray[index];
            trainsArray[index] = trainsArray[i];
            trainsArray[i] = tempTrain;
        }

        TrainManager.removeAllTrain();
        TrainManager.addTrain(trainsArray);
    }

    //O(n*log(n))
    public static void sortMerge() throws ListIsEmptyException, ObjectIsNullException {
        Train[] trainsArray = TrainManager.getAllTrain().
                toArray(new Train[TrainStatistics.countTrain()]);
        sortMergeRecursively(trainsArray, 0, trainsArray.length - 1);
        TrainManager.removeAllTrain();
        TrainManager.addTrain(trainsArray);
    }

    private static void sortMergeRecursively(Train[] trainsArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sortMergeRecursively(trainsArray, left, middle);
            sortMergeRecursively(trainsArray, middle + 1, right);
            doMerge(trainsArray, left, middle, right);
        }
    }

    private static void doMerge(Train[] trainsArray, int left, int middle, int right) {
        int tempLengthOne = middle - left + 1;
        int tempLengthTwo = right - middle;
        Train[] tempTrainsOne = new Train[tempLengthOne];
        Train[] tempTrainsTwo = new Train[tempLengthTwo];

        for (int i = 0; i < tempLengthOne; ++i) {
            tempTrainsOne[i] = trainsArray[left + i];
        }

        for (int j = 0; j < tempLengthTwo; ++j) {
            tempTrainsTwo[j] = trainsArray[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < tempLengthOne && j < tempLengthTwo) {
            if (tempTrainsOne[i].compareTo(tempTrainsTwo[j]) <= 0) {
                trainsArray[k] = tempTrainsOne[i];
                i++;
            } else {
                trainsArray[k] = tempTrainsTwo[j];
                j++;
            }
            k++;
        }

        while (i < tempLengthOne) {
            trainsArray[k] = tempTrainsOne[i];
            i++;
            k++;
        }

        while (j < tempLengthTwo) {
            trainsArray[k] = tempTrainsTwo[j];
            j++;
            k++;
        }
    }

    //O(n*log(n))
    public static void sortQuick() throws ListIsEmptyException, ObjectIsNullException {
        Train[] trainsArray = TrainManager.getAllTrain().
                toArray(new Train[TrainStatistics.countTrain()]);
        sortQuickRecursively(trainsArray, 0, trainsArray.length - 1);
        TrainManager.removeAllTrain();
        TrainManager.addTrain(trainsArray);
    }

    private static void sortQuickRecursively(Train[] trainsArray, int startIndex, int finishIndex) {

        if (startIndex >= finishIndex) {
            return;
        }

        int start = startIndex;
        int finish = finishIndex;
        int middle = start - (start - finish) / 2;

        while (start < finish) {

            while (start < middle && (trainsArray[start].compareTo(trainsArray[middle]) <= 0)) {
                start++;
            }

            while (finish > middle && (trainsArray[middle].compareTo(trainsArray[finish]) <= 0)) {
                finish--;
            }

            if (start < finish) {
                Train temp = trainsArray[start];
                trainsArray[start] = trainsArray[finish];
                trainsArray[finish] = temp;

                if (start == middle) {
                    middle = finish;
                } else if (finish == middle) {
                    middle = start;
                }

            }
        }
        sortQuickRecursively(trainsArray, startIndex, middle);
        sortQuickRecursively(trainsArray, middle + 1, finishIndex);
    }

}