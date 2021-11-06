package com.mt.designmodel.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * java_study
 * 实现目标
 * 进去的时候1-2
 * 回来的时候2-1
 */
public class ChainTest_V1 {
    public static void main(String[] args) {
        IntValue intValue = new IntValue();
        FilterChain chain = new FilterChain();
        chain.add(new AddFilter());
        chain.add(new SubFilter());
        chain.doFilter(intValue);
    }
}

interface Filter_{
    void doFilter(IntValue intValue);
}

class AddFilter implements Filter_{

    @Override
    public void doFilter(IntValue intValue) {
        System.out.println("addFilter before " + intValue.value);
        intValue.value++;
        System.out.println("addFilter after " + intValue.value);
    }
}

class SubFilter implements Filter_{

    @Override
    public void doFilter(IntValue intValue) {
        System.out.println("subFilter before " + intValue.value);
        intValue.value--;
        System.out.println("subFilter after " + intValue.value);
    }
}

class FilterChain implements Filter_{
    List<Filter_> list = new ArrayList<>();
    public void add(Filter_ filter) {
        list.add(filter);
    }

    @Override
    public void doFilter(IntValue intValue) {
        for (Filter_ filter_ : list) {
            filter_.doFilter(intValue);
        }
    }
}

class IntValue{
    int value;
}
