package com.vika.way.pre.algorithm.alg.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Feature {
    private int x;
    private int y;

    public Feature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) o;
        return x == feature.x &&
            y == feature.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class FeatureExtract {

    public int longestFeature(int[][] features) {
        int x, y;
        Feature[][] feature = new Feature[features.length][];
        for (int m = 0; m < features.length; m++) {
            feature[m] = new Feature[features[m].length / 2];
            for (int k = 0; k < features[m].length; k += 2) {
                x = features[m][k];
                y = features[m][k + 1];
                feature[m][k / 2] = new Feature(x, y);
            }
        }
        return longestFeature(feature);
    }


    public int longestFeature(Feature[][] feature) {
        int m = feature.length;
        Map<Feature, Integer>[] dp = new Map[m + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = new HashMap<>();
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < feature[i].length; j++) {
                int num = dp[i].getOrDefault(feature[i][j], 0) + 1;
                dp[i + 1].put(feature[i][j], num);
                max = Math.max(max, num);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] array = {
            {1, 1, 2, 2},
            {1, 1, 1, 4},
            {1, 1, 2, 2},
            {2, 2, 1, 4},
            {},
            {},
            {1, 1},
            {1, 1}};
        FeatureExtract featureExtract = new FeatureExtract();
        System.out.println(featureExtract.longestFeature(array));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M, K;
        int x, y;
        Feature[][] features;
        for (int n = 0; n < N; n++) {
            M = scanner.nextInt();
            features = new Feature[M][];
            for (int m = 0; m < M; m++) {
                K = scanner.nextInt();
                features[m] = new Feature[K];
                for (int k = 0; k < K; k++) {
                    x = scanner.nextInt();
                    y = -scanner.nextInt();
                    features[m][k] = new Feature(x, y);

                }
            }
            System.out.println(featureExtract.longestFeature(features));
        }
    }
}
