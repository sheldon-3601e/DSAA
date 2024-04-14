package com.sheldon;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sheldon
 * @version 1.0
 * @className Main
 * @date 2024/4/8 17:37
 * @description TODO
 */
public class Main {


    public static void main(String[] args) {
        BigInteger res = BigInteger.ZERO;
        Map<BigInteger, BigInteger> map = new HashMap<>();
        map.put(BigInteger.ONE, BigInteger.ONE);

        for (long i = 2; i <= 202320230203L; i++) {
            res = res.add(traversal(i, map));
        }
        System.out.println(res);
    }

    public static BigInteger traversal(long num, Map<BigInteger, BigInteger> map) {
        BigInteger res = BigInteger.ONE;
        BigInteger subtract = BigInteger.valueOf(num);
        BigInteger multiply = map.get(subtract.subtract(BigInteger.ONE)).multiply(subtract);
        map.put(subtract, multiply);
        return multiply;
    }

}

