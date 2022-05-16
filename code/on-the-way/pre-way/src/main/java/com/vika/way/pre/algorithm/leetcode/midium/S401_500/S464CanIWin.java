package com.vika.way.pre.algorithm.leetcode.midium.S401_500;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class S464CanIWin {

    //有误
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        } else if (maxChoosableInteger + 1 >= desiredTotal) {
            return false;
        }
        int total = 1 + maxChoosableInteger;
        if (maxChoosableInteger % 2 == 1) {
            desiredTotal -= (maxChoosableInteger + 1) / 2;
            if (desiredTotal % total == 0) {
                return true;
            }
            return (desiredTotal / total) % 2 == 0;
        } else {
            return desiredTotal % total != 0 && (desiredTotal / total) % 2 != 0;
        }
    }

    //超时
    public boolean canIWin0(int maxChoosableInteger, int desiredTotal) {
        int canReachTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (canReachTotal < desiredTotal) {
            return false;
        } else if (canReachTotal == desiredTotal) {
            return (maxChoosableInteger & 1) == 1;
        }
        return dfs(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
    }

    public boolean dfs(int maxChoosableInteger, int desiredTotal, boolean[] visited) {
        for (int i = maxChoosableInteger; i > 0; i--) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, visited)) {
                visited[i] = false;
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public boolean canIWin1(int maxChoosableInteger, int desiredTotal) {
        int canReachTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (canReachTotal < desiredTotal) {
            return false;
        } else if (canReachTotal == desiredTotal) {
            return (maxChoosableInteger & 1) == 1;
        }
        return dfs(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    public boolean dfs(int maxChoosableInteger, int desiredTotal, int status, Map<Integer, Boolean> memo) {
        if (memo.containsKey(status)) {
            return memo.get(status);
        }
        for (int i = maxChoosableInteger; i > 0; i--) {
            if (((status >> i) & 1) == 1) {
                continue;
            }
            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, status | (1 << i), memo)) {
                memo.put(status, true);
                return true;
            }
        }
        memo.put(status, false);
        return false;
    }

    public boolean canIWin2(int maxChoosableInteger, int desiredTotal) {
        int canReachTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (canReachTotal < desiredTotal) {
            return false;
        } else if (canReachTotal == desiredTotal) {
            return (maxChoosableInteger & 1) == 1;
        }
        return dfs(maxChoosableInteger, desiredTotal, 0, new Integer[1 << maxChoosableInteger + 1]);
    }

    public boolean dfs(int maxChoosableInteger, int desiredTotal, int status, Integer[] memo) {
        if (memo[status] != null) {
            return memo[status] == 1;
        }
        for (int i = maxChoosableInteger; i > 0; i--) {
            if (((status >> i) & 1) == 1) {
                continue;
            }
            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, status | (1 << i), memo)) {
                memo[status] = 1;
                return true;
            }
        }
        AtomicReference<S430FlattenAMultilevelDoublyLinkedList.Node> atomicReference;
        memo[status] = 0;
        return false;
    }


}
