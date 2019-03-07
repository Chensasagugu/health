package hdu.cn.hziee.util;

import java.util.*;

/*
* 描述：Alias抽奖算法
* */
public class AliasUtil {
    private final Random random;
    private final int[] alias;
    private final double[] probability;

    public AliasUtil(List<Double> probabilities) {
        this(probabilities, new Random());
    }
    public AliasUtil(List<Double> probabilities, Random random) {
        if (probabilities == null || random == null)
            throw new NullPointerException();
        if (probabilities.size() == 0)
            throw new IllegalArgumentException("Probability vector must be nonempty.");
        probability = new double[probabilities.size()];
        alias = new int[probabilities.size()];
        this.random = random;
        final double average = 1.0 / probabilities.size();
        probabilities = new ArrayList<Double>(probabilities);
        Deque<Integer> small = new ArrayDeque<Integer>();
        Deque<Integer> large = new ArrayDeque<Integer>();

        /* Populate the stacks with the input probabilities. */
        for (int i = 0; i < probabilities.size(); ++i) {
            if (probabilities.get(i) >= average)
                large.add(i);
            else
                small.add(i);
        }

        while (!small.isEmpty() && !large.isEmpty()) {
            /* Get the index of the small and the large probabilities. */
            int less = small.removeLast();
            int more = large.removeLast();
            probability[less] = probabilities.get(less) * probabilities.size();
            alias[less] = more;
            probabilities.set(more,
                    (probabilities.get(more) + probabilities.get(less)) - average);

            if (probabilities.get(more) >= 1.0 / probabilities.size())
                large.add(more);
            else
                small.add(more);
        }

        while (!small.isEmpty())
            probability[small.removeLast()] = 1.0;
        while (!large.isEmpty())
            probability[large.removeLast()] = 1.0;
    }
    /**
     * 抽奖
     * 返回抽到的下标
     */
    public int next() {

        int column = random.nextInt(probability.length);
        boolean coinToss = random.nextDouble() < probability[column];
        return coinToss ? column : alias[column];
    }
}
