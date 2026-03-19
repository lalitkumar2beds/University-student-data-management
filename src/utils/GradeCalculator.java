package utils;

import java.util.List;

public class GradeCalculator {

    public static double calculateWeightedScore(
            double marks,
            double maxMarks,
            double weight) {

        if (maxMarks == 0) {
            return 0;
        }

        double percentage = (marks / maxMarks) * 100;

        return (percentage * weight) / 100;
    }

    public static double calculateFinalGrade(List<Double> weightedScores) {

        double total = 0;

        for (double score : weightedScores) {
            total += score;
        }

        return total;
    }

    public static String getLetterGrade(double score) {

        if (score >= 70) {
            return "A";
        }

        if (score >= 60) {
            return "B";
        }

        if (score >= 50) {
            return "C";
        }

        if (score >= 40) {
            return "D";
        }

        return "F";
    }

}